package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;

/**
 * 物品Dao
 *
 * @author Three-in
 */
public class ItemDao extends ConnectionDao {

	/**
	 * 物品情報取得
	 *
	 * @param 検索キーワード
	 * @return 検索結果
	 */
	public List<Item> searchItems(List<String> keywords) {

		// 取得結果
		List<Item> result = new ArrayList<>();
		// SQL作成
		StringBuilder sql = new StringBuilder("");
		sql.append("SELECT ");
		sql.append("    item_id ");
		sql.append("    , item_name ");
		sql.append("    , item_genre ");
		sql.append("    , item_publisher ");
		sql.append("    , item_arrival_date ");
		sql.append("    , item_img_path ");
		sql.append("    , item_comment ");
		sql.append("    , delete_flg ");
		sql.append("    , insert_date ");
		sql.append("    , update_date ");
		sql.append("FROM ");
		sql.append("    ITEM ");
		sql.append("WHERE ");
		sql.append("    1 = 1 ");
		for (int i = 0; i < keywords.size(); i++) {
			sql.append("    AND item_name LIKE ? ");
		}
		sql.append("ORDER BY item_id;");

		//コネクション生成
		super.createConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = super.connection.prepareStatement(sql.toString());
			int index = 1;
			for (String keyword : keywords) {
				stmt.setString(index++, "%" + keyword + "%");
			}
			rs = stmt.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getString("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemGenre(rs.getString("item_genre"));
				item.setItemPublisher(rs.getString("item_publisher"));
				item.setItemArrivalDate(rs.getDate("item_arrival_date"));
				item.setItemImgPath(rs.getString("item_img_path"));
				item.setItemComment(rs.getString("item_comment"));
				item.setDeleteFlg(rs.getString("delete_flg"));
				item.setInsertDate(rs.getDate("insert_date"));
				item.setUpdateDate(rs.getDate("update_date"));

				result.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			super.closeConnection();
		}
		return result;
	}
}
