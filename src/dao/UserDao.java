package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.ThreeUtils;

/**
 * ユーザーDao
 *
 * @author Three-in
 */
public class UserDao extends ConnectionDao {

	/**
	 * ユーザー情報取得
	 *
	 * @param ユーザーID
	 * @return ユーザー情報
	 */
	public User getUser(String userId) {
		return getUser(userId, null);
	}

	/**
	 * ユーザー情報取得
	 *
	 * @param ユーザーID
	 * @param パスワード
	 * @return ユーザー情報
	 */
	public User getUser(String userId, String password) {

		// SQL作成
		StringBuilder sql = new StringBuilder("");
		sql.append("SELECT ");
		sql.append("    user_id ");
		sql.append("    ,password ");
		sql.append("    ,user_name ");
		sql.append("    ,user_name_kana ");
		sql.append("    ,user_gender ");
		sql.append("    ,user_birth_day ");
		sql.append("    ,user_zip ");
		sql.append("    ,user_address ");
		sql.append("    ,user_phone_number ");
		sql.append("    ,user_mail_address ");
		sql.append("    ,delete_flg ");
		sql.append("    ,insert_date ");
		sql.append("    ,update_date ");
		sql.append("FROM ");
		sql.append("    USER ");
		sql.append("WHERE ");
		sql.append("    user_id = ? ");
		if (!ThreeUtils.isEmpty(password)) {
			sql.append("    AND password = ?");
		}

		//コネクション生成
		super.createConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;

		try {
			stmt = super.connection.prepareStatement(sql.toString());
			stmt.setString(1, userId);
			if (!ThreeUtils.isEmpty(password)) {
				stmt.setString(2, password);
			}
			rs = stmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("user_name"));
				user.setUserNameKana(rs.getString("user_name_kana"));
				user.setUserGender(rs.getString("user_gender"));
				user.setUserBirthDay(rs.getDate("user_birth_day"));
				user.setUserZip(rs.getString("user_zip"));
				user.setUserAddress(rs.getString("user_address"));
				user.setUserPhoneNumber(rs.getString("user_phone_number"));
				user.setUserMailAddress(rs.getString("user_mail_address"));
				user.setDeleteFlg(rs.getString("delete_flg"));
				user.setInsertDate(rs.getDate("insert_date"));
				user.setUpdateDate(rs.getDate("update_date"));
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
		return user;
	}

	/**
	 * ユーザー情報登録
	 *
	 * @param ユーザー情報
	 * @return 登録件数
	 */
	public int registUser(User user) {

		// SQL作成
		StringBuilder sql = new StringBuilder("");
		sql.append("INSERT INTO USER VALUES (");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '0', SYSDATE(), SYSDATE() ");
		sql.append(");");

		//コネクション生成
		super.createConnection();

		PreparedStatement stmt = null;
		Integer result = 0;

		try {
			stmt = super.connection.prepareStatement(sql.toString());
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUserName());
			stmt.setString(4, user.getUserNameKana());
			stmt.setString(5, user.getUserGender());
			stmt.setDate(6, ThreeUtils.convUtilDateToSqlDate(user.getUserBirthDay()));
			stmt.setString(7, user.getUserZip());
			stmt.setString(8, user.getUserAddress());
			stmt.setString(9, user.getUserPhoneNumber());
			stmt.setString(10, user.getUserMailAddress());
			result = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			super.closeConnection();
		}
		return result;
	}
}
