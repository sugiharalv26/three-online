package test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import model.User;
import servise.UserLoginService;
import util.MessageConst;
import util.ThreeUtils;



public class UserLoginServiceTest {

	//インスタンス作成
	UserLoginService service = new UserLoginService();

	//ID：null　パスワード：DBに存在する　を値に入れるケース
	@Test
	void testCase1() {
		System.out.println("◆テストCASE1 START------------------------------");

		//input
		String userId = null;
		String password = "pass1111";

		//output
		User user = null;

		//例外処理をしたメッセージを受け取る為のmessage
		String message = "";

		try {
			user = service.searchUser(userId, password);
		} catch(Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", user==null);
		//期待値："ユーザーIDは必須入力です"
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_USER_ID);

		System.out.println("◆テストCASE1 END--------------------------------");

	}

	//ID 空文字　パスワード DB上にあるパスワード
	@Test
	void testCase2() {
		System.out.println("◆テストCASE2 START------------------------------");
		//input
		String userId = "";
		String password = "pass1111";

		//output
		//usermodelのインスタンスを作成
		User user = null;

		//例外処理をしたメッセージを受け取る為のmessage
		String message = "";

		try {
			user = service.searchUser(userId, password);
		} catch(Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", user==null);
		//期待値："ユーザーIDは必須入力です"
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_USER_ID);


		System.out.println("◆テストCASE2 END--------------------------------");

	}

	//ID DBに存在するID　パスワード　DBに存在するパスワード　同一ユーザーではない。
	@Test
	void testCase3() {
		System.out.println("◆テストCASE3 START------------------------------");
		//input
		String userId = "0000000008";
		String password = "pass1111";

		//output
		User user = null;

		//例外処理をしたメッセージを受け取る為のmessage
		String message = "";

		try {
			user = service.searchUser(userId, password);
		} catch(Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致",user==null);
		//期待値："ログイン処理に失敗しました。顧客ID、パスワードを確認してください。"
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_ERR_LOGIN_ERROR);


		System.out.println("◆テストCASE3 END--------------------------------");

	}

	//ID DBに存在するID　パスワード　DBに存在するパスワード　同一ユーザー
	@Test
	void testCase4() {
		System.out.println("◆テストCASE4 START------------------------------");
		//input
		String userId = "0000000007";
		String password = "a1b2c3d";

		//output
		//usermodelのインスタンスを作成
		User user = new User();

		User expectedUser = new User();
		expectedUser.setUserId("0000000007");
		expectedUser.setPassword("a1b2c3d");
		expectedUser.setUserName("TESTデータ夫");
		expectedUser.setUserNameKana("テストデータオ");
		expectedUser.setUserGender("男");
		expectedUser.setUserBirthDay(ThreeUtils.createDate("1955-05-01"));
		expectedUser.setUserZip("123-4566");
		expectedUser.setUserAddress("東京都江戸川区江戸川1-2-3");
		expectedUser.setUserPhoneNumber("000-111-234");
		expectedUser.setUserMailAddress("tesosu@tdata.com");
		expectedUser.setDeleteFlg("0");
		expectedUser.setInsertDate(ThreeUtils.createDate("2019-08-30"));
		expectedUser.setUpdateDate(ThreeUtils.createDate("2019-10-29"));

		//例外処理をしたメッセージを受け取る為のmessage
		String message = "";

		try {
			user = service.searchUser(userId, password);
		} catch(Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", ThreeUtils.modelMatch(user, expectedUser));
		assertTrue("メッセージ期待値不一致", ThreeUtils.isEmpty(message));


		System.out.println("◆テストCASE4 END--------------------------------");

	}

	//ID DB上にあるID　パスワード null
	@Test
	void testCase5() {
		System.out.println("◆テストCASE5 START------------------------------");
		//input
		String userId = "0000000008";
		String password = null;

		//output
		User user = null;

		//例外処理をしたメッセージを受け取る為のmessage
		String message = "";

		try {
			user = service.searchUser(userId, password);
		} catch(Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", user==null);
		//期待値："パスワードは必須入力です"
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_PASSWORD);


		System.out.println("◆テストCASE5 END--------------------------------");

	}

	//ID DB上にあるID　パスワード 空文字
	@Test
	void testCase6() {
		System.out.println("◆テストCASE6 START------------------------------");
		//input
		String userId = "0000000008";
		String password = "";

		//output
		User user = null;

		//例外処理をしたメッセージを受け取る為のmessage
		String message = "";

		try {
			user = service.searchUser(userId, password);
		} catch(Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", user==null);
		//期待値："パスワードは必須入力です"
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_PASSWORD);


		System.out.println("◆テストCASE6 END--------------------------------");

	}

	//ID null　パスワード  null
	@Test
	void testCase7() {
		System.out.println("◆テストCASE7 START------------------------------");
		//input
		String userId = null;
		String password = null;

		//output
		User user = null;

		//例外処理をしたメッセージを受け取る為のmessage
		String message = "";

		try {
			user = service.searchUser(userId, password);
		} catch(Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", user==null);
		//期待値："ユーザーID、パスワードは必須入力です"
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_ID_AND_PASS);


		System.out.println("◆テストCASE7 END--------------------------------");

	}

	//ID 空文字　パスワード  空文字
	@Test
	void testCase8() {
		System.out.println("◆テストCASE8 START------------------------------");
		//input
		String userId = "";
		String password = "";

		//output
		User user = null;

		//例外処理をしたメッセージを受け取る為のmessage
		String message = "";

		try {
			user = service.searchUser(userId, password);
		} catch(Exception e) {
			message = e.getMessage();
		}

		assertTrue("結果期待値不一致", user==null);
		//期待値："ユーザーID、パスワードは必須入力です"
		assertEquals("メッセージ期待値不一致", message, MessageConst.MSG_INPUT_EMPTY_ID_AND_PASS);


		System.out.println("◆テストCASE8 END--------------------------------");

	}

}
