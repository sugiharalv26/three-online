package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Item;
import servise.SearchItemService;
import util.MessageConst;
import util.ThreeUtils;

class SearchItemServiceTest {

	SearchItemService service = new SearchItemService();;

	@Test
	void testCase1() {
		System.out.println("◆テストCASE1 START------------------------------");
		//Input
		String keyword = null;
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.isEmpty(list));
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_ITEM_NAME);

		System.out.println("◆テストCASE1 END--------------------------------");
	}

	@Test
	void testCase2() {
		System.out.println("◆テストCASE2 START------------------------------");
		//Input
		String keyword = "";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.isEmpty(list));
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_ITEM_NAME);

		System.out.println("◆テストCASE2 END--------------------------------");
	}

	@Test
	void testCase3() {
		System.out.println("◆テストCASE3 START------------------------------");
		//Input
		String keyword = " ";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.isEmpty(list));
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_ITEM_NAME);

		System.out.println("◆テストCASE3 END--------------------------------");
	}


	@Test
	void testCase4() {
		System.out.println("◆テストCASE4 START------------------------------");
		//Input
		String keyword = "　";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.isEmpty(list));
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_ITEM_NAME);

		System.out.println("◆テストCASE4 END--------------------------------");
	}

	@Test
	void testCase5() {
		System.out.println("◆テストCASE5 START------------------------------");
		//Input
		String keyword = " 　";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.isEmpty(list));
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_ITEM_NAME);

		System.out.println("◆テストCASE5 END--------------------------------");
	}

	 //0件
	// "該当する物品情報が存在しません。が表示される。
	@Test
	void testCase6() {
		System.out.println("◆テストCASE6 START------------------------------");
		//Input
		String keyword = "あああああああ";
		//Output
		//検索結果がない。
		List<Item> list = new ArrayList<>();
		String message = "";
		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			//"該当する物品情報が存在しません。"を取得している？
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.isEmpty(list));
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_RESULT_EMPTY_ITEM_LIST);

		System.out.println("◆テストCASE6 END--------------------------------");
	}

	@Test
	void testCase7() {
		System.out.println("◆テストCASE7 START------------------------------");
		//Input
		String keyword = "AB物品";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		//Expected
		List<Item> expectedList = new ArrayList<>();
		Item expectedItem = new Item();
		expectedItem.setItemId("TEST000002");
		expectedItem.setItemName("TESTAB物品CD名");
		expectedItem.setItemGenre("item_genre2");
		expectedItem.setItemPublisher("item_publisher2");
		expectedItem.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setItemImgPath("/item_img_path2");
		expectedItem.setItemComment("item_comment2");
		expectedItem.setDeleteFlg("0");
		expectedItem.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem);

		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(list, expectedList));

		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));

		System.out.println("◆テストCASE7 END--------------------------------");
	}

	//1件分、完全一致
	@Test
	void testCase8() {
		System.out.println("◆テストCASE8 START------------------------------");
		//Input
		String keyword = "TEST物品名2";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		//Expected
		List<Item> expectedList = new ArrayList<>();
		Item expectedItem = new Item();
		expectedItem.setItemId("TEST000004");
		expectedItem.setItemName("TEST物品名2");
		expectedItem.setItemGenre("item_genre4");
		expectedItem.setItemPublisher("item_publisher4");
		expectedItem.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setItemImgPath("/item_img_path4");
		expectedItem.setItemComment("item_comment4");
		expectedItem.setDeleteFlg("0");
		expectedItem.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem);

		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(list, expectedList));

		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));

		System.out.println("◆テストCASE8 END--------------------------------");
	}

	//検索文字列n件　半角スペース　0件
	@Test
	void testCase9() {
		System.out.println("◆テストCASE9 START------------------------------");
		//Input
		String keyword = "FF 聖剣伝説";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";

		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.isEmpty(list));
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_RESULT_EMPTY_ITEM_LIST);

		System.out.println("◆テストCASE9 END--------------------------------");
	}

	//検索n件　半角スペース　部分一致　１件
	@Test
	void testCase10() {
		System.out.println("◆テストCASE10 START------------------------------");
		//Input
		String keyword = "あああ ABC";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		//Expected
		List<Item> expectedList = new ArrayList<>();
		Item expectedItem = new Item();
		expectedItem.setItemId("TEST000001");
		expectedItem.setItemName("TESTABC物品名");
		expectedItem.setItemGenre("item_genre1");
		expectedItem.setItemPublisher("item_publisher1");
		expectedItem.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setItemImgPath("/item_img_path1");
		expectedItem.setItemComment("item_comment1");
		expectedItem.setDeleteFlg("0");
		expectedItem.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem);

		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(list, expectedList));

		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));

		System.out.println("◆テストCASE10 END--------------------------------");
	}

	//検索n件　半角スペース　完全一致　１件
	@Test
	void testCase11() {
		System.out.println("◆テストCASE11 START------------------------------");
		//Input
		String keyword = "TESTAB物品CD名 FF";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		//Expected
		List<Item> expectedList = new ArrayList<>();
		Item expectedItem = new Item();
		expectedItem.setItemId("TEST000002");
		expectedItem.setItemName("TESTAB物品CD名");
		expectedItem.setItemGenre("item_genre2");
		expectedItem.setItemPublisher("item_publisher2");
		expectedItem.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setItemImgPath("/item_img_path2");
		expectedItem.setItemComment("item_comment2");
		expectedItem.setDeleteFlg("0");
		expectedItem.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem);

		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(list, expectedList));

		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));

		System.out.println("◆テストCASE11 END--------------------------------");
	}


	//検索n件分　半角スペース　部分一致　n件
	@Test
	void testCase12() {
		System.out.println("◆テストCASE12 START------------------------------");
		//Input
		String keyword = "ABC 物品C";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		//Expected
		List<Item> expectedList = new ArrayList<>();
		Item expectedItem = new Item();
		Item expectedItem2 = new Item();

		expectedItem.setItemId("TEST000001");
		expectedItem.setItemName("TESTABC物品名");
		expectedItem.setItemGenre("item_genre1");
		expectedItem.setItemPublisher("item_publisher1");
		expectedItem.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setItemImgPath("/item_img_path1");
		expectedItem.setItemComment("item_comment1");
		expectedItem.setDeleteFlg("0");
		expectedItem.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem);

		expectedItem2.setItemId("TEST000002");
		expectedItem2.setItemName("TESTAB物品CD名");
		expectedItem2.setItemGenre("item_genre2");
		expectedItem2.setItemPublisher("item_publisher2");
		expectedItem2.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem2.setItemImgPath("/item_img_path2");
		expectedItem2.setItemComment("item_comment2");
		expectedItem2.setDeleteFlg("0");
		expectedItem2.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem2.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem2);

		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(list, expectedList));

		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));

		System.out.println("◆テストCASE12 END--------------------------------");
	}

	// n件分　半角スペース　完全一致　結果n件
	@Test
	void testCase13() {
		System.out.println("◆テストCASE13 START------------------------------");
		//Input
		// TESTABC物品名  TESTAB物品CD名
		String keyword = "TEST物品名2 TESTAB物品CD名";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		//Expected
		List<Item> expectedList = new ArrayList<>();
		Item expectedItem = new Item();
		Item expectedItem2 = new Item();

		expectedItem.setItemId("TEST000003");
		expectedItem.setItemName("TEST物品名1");
		expectedItem.setItemGenre("item_genre3");
		expectedItem.setItemPublisher("item_publisher3");
		expectedItem.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setItemImgPath("/item_img_path3");
		expectedItem.setItemComment("item_comment3");
		expectedItem.setDeleteFlg("0");
		expectedItem.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem);


		expectedItem2.setItemId("TEST000004");
		expectedItem2.setItemName("TEST物品名2");
		expectedItem2.setItemGenre("item_genre4");
		expectedItem2.setItemPublisher("item_publisher4");
		expectedItem2.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem2.setItemImgPath("/item_img_path4");
		expectedItem2.setItemComment("item_comment4");
		expectedItem2.setDeleteFlg("0");
		expectedItem2.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem2.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem2);



		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(list, expectedList));

		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));

		System.out.println("◆テストCASE13 END--------------------------------");
	}

	// n件分　半角スペース　部分一致+完全一致 結果n件
	@Test
	void testCase14() {
		System.out.println("◆テストCASE14 START------------------------------");
		//Input
		String keyword = "TESTAB物品CD名 1";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		//Expected
		List<Item> expectedList = new ArrayList<>();
		Item expectedItem = new Item();
		Item expectedItem2 = new Item();
		expectedItem.setItemId("TEST000002");
		expectedItem.setItemName("TESTAB物品CD名");
		expectedItem.setItemGenre("item_genre2");
		expectedItem.setItemPublisher("item_publisher2");
		expectedItem.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setItemImgPath("/item_img_path2");
		expectedItem.setItemComment("item_comment2");
		expectedItem.setDeleteFlg("0");
		expectedItem.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem);

		expectedItem2.setItemId("TEST000003");
		expectedItem2.setItemName("TEST物品名1");
		expectedItem2.setItemGenre("item_genre3");
		expectedItem2.setItemPublisher("item_publisher3");
		expectedItem2.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem2.setItemImgPath("/item_img_path3");
		expectedItem2.setItemComment("item_comment3");
		expectedItem2.setDeleteFlg("0");
		expectedItem2.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem2.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem2);

		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(list, expectedList));

		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));

		System.out.println("◆テストCASE14 END--------------------------------");
	}

	// n件分　全角スペース　部分一致
	@Test
	void testCase15() {
		System.out.println("◆テストCASE15 START------------------------------");
		//Input
		String keyword = "3　CD";
		//Output
		List<Item> list = new ArrayList<>();
		String message = "";
		//Expected
		List<Item> expectedList = new ArrayList<>();
		Item expectedItem = new Item();
		Item expectedItem2 = new Item();

		expectedItem.setItemId("TEST000002");
		expectedItem.setItemName("TESTAB物品CD名");
		expectedItem.setItemGenre("item_genre2");
		expectedItem.setItemPublisher("item_publisher2");
		expectedItem.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setItemImgPath("/item_img_path2");
		expectedItem.setItemComment("item_comment2");
		expectedItem.setDeleteFlg("0");
		expectedItem.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem);


		expectedItem2.setItemId("TEST000005");
		expectedItem2.setItemName("TEST物品名3");
		expectedItem2.setItemGenre("item_genre5");
		expectedItem2.setItemPublisher("item_publisher5");
		expectedItem2.setItemArrivalDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem2.setItemImgPath("/item_img_path5");
		expectedItem2.setItemComment("item_comment5");
		expectedItem2.setDeleteFlg("0");
		expectedItem2.setInsertDate(ThreeUtils.createDate("2019-06-07"));
		expectedItem2.setUpdateDate(ThreeUtils.createDate("2019-06-07"));
		expectedList.add(expectedItem2);


		try {
			list = service.searchItem(keyword);
		} catch (Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(list, expectedList));

		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));

		System.out.println("◆テストCASE15 END--------------------------------");
	}
}
