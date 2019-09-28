package servise;

import java.text.SimpleDateFormat;

import dao.UserDao;
import model.User;
import util.MessageConst;
import util.ThreeUtils;

/**
 * ユーザー登録サービス
 *
 * @author Three-in
 */
public class UserRegistService {

	/**
	 * ユーザー登録
	 */
	public void registUser(User user) throws Exception {

		//入力チェック
		String errMsg = inputCheck(user);
		if (!ThreeUtils.isEmpty(errMsg)) {
			throw new Exception(errMsg);
		}

		UserDao dao = new UserDao();

		//ユーザー重複チェック
		if (dao.getUser(user.getUserId()) != null) {
			throw new Exception(MessageConst.MSG_ERR_EXISTS_USER_ID_ERROR);
		}

		//ユーザー情報登録
		if (dao.registUser(user) == 0) {
			throw new Exception(MessageConst.MSG_ERR_REGIST_ERROR);
		}
	}

	private String inputCheck(User user) {
		//必須チェック
		if (ThreeUtils.isEmpty(user.getUserId())) {
			return "ユーザーID" + MessageConst.MSG_ERR_EMPTY;
		}
		if (ThreeUtils.isEmpty(user.getPassword())) {
			return "パスワード" + MessageConst.MSG_ERR_EMPTY;
		}
		if (ThreeUtils.isEmpty(user.getConfirmPassword())) {
			return "パスワード(確認用)" + MessageConst.MSG_ERR_EMPTY;
		}
		if (ThreeUtils.isEmpty(user.getUserName())) {
			return "ユーザー名" + MessageConst.MSG_ERR_EMPTY;
		}
		if (ThreeUtils.isEmpty(user.getUserNameKana())) {
			return "ユーザー名(カナ)" + MessageConst.MSG_ERR_EMPTY;
		}
		if (ThreeUtils.isEmpty(user.getUserGender())) {
			return "性別" + MessageConst.MSG_ERR_EMPTY;
		}
		if (ThreeUtils.isEmpty(user.getStrBirthDay())) {
			return "生年月日" + MessageConst.MSG_ERR_EMPTY;
		}
		if (ThreeUtils.isEmpty(user.getUserZip())) {
			return "郵便番号" + MessageConst.MSG_ERR_EMPTY;
		}
		if (ThreeUtils.isEmpty(user.getUserAddress())) {
			return "住所" + MessageConst.MSG_ERR_EMPTY;
		}

		//確認用入力チェック
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			return MessageConst.MSG_ERR_PASSWORD_MISMATCH;
		}

		//形式チェック
		if (!user.getUserId().matches("^[a-zA-Z0-9]+$")) {
			return "ユーザーID" + MessageConst.MSG_ERR_TYPE_ERROR;
		}
		if (!user.getPassword().matches("^[a-zA-Z0-9]+$")) {
			return "パスワード" + MessageConst.MSG_ERR_TYPE_ERROR;
		}
		if (!user.getUserNameKana().matches("^[ァ-ヶ]+$")) {
			return "ユーザー名(カナ)" + MessageConst.MSG_ERR_TYPE_ERROR;
		}
		if (!user.getUserGender().equals("男") && !user.getUserGender().equals("女")) {
			return "性別" + MessageConst.MSG_ERR_TYPE_ERROR;
		}
		try {
			user.setUserBirthDay(new SimpleDateFormat("yyyy-mm-dd").parse(user.getStrBirthDay()));
		} catch (Exception e) {
			return "生年月日" + MessageConst.MSG_ERR_TYPE_ERROR;
		}
		if (!user.getUserZip().matches("^[0-9]{3}-[0-9]{4}$")) {
			return "郵便番号" + MessageConst.MSG_ERR_TYPE_ERROR;
		}
		if (!ThreeUtils.isEmpty(user.getUserPhoneNumber())
				&& !user.getUserPhoneNumber().matches("^\\d{2,3}-\\d{1,4}-\\d{4}$")) {
			return "電話番号" + MessageConst.MSG_ERR_TYPE_ERROR;
		}
		if (!ThreeUtils.isEmpty(user.getUserMailAddress())
				&& !user.getUserMailAddress().matches("^[a-zA-Z0-9-_\\.]+@[a-zA-Z0-9-_\\.]+$")) {
			return "メールアドレス" + MessageConst.MSG_ERR_TYPE_ERROR;
		}
		return "";
	}
}
