package servise;

import java.util.List;

import dao.ItemDao;
import model.Item;
import util.MessageConst;
import util.ThreeUtils;

/**
 * 物品検索サービス
 *
 * @author Three-in
 */
public class SearchItemService {

	/**
	 * 物品検索
	 * @throws Exception
	 */
	public List<Item> searchItem(String keyword) throws Exception {

		if (ThreeUtils.isEmpty(keyword)) {
			throw new Exception(MessageConst.MSG_INPUT_EMPTY_ITEM_NAME);
		}
		List<String> keywords = ThreeUtils.createKeyword(keyword);
		if (ThreeUtils.isEmpty(keywords)) {
			throw new Exception(MessageConst.MSG_INPUT_EMPTY_ITEM_NAME);
		}
		ItemDao dao = new ItemDao();
		List<Item> itemList = dao.searchItems(keywords);
		if (ThreeUtils.isEmpty(itemList)) {
			throw new Exception(MessageConst.MSG_RESULT_EMPTY_ITEM_LIST);
		}
		return itemList;
	}

}
