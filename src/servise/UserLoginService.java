package servise;

import dao.UserDao;
import model.User;
import util.MessageConst;
import util.ThreeUtils;

/**
 * ユーザーログインサービス
 *
 * @author Three-in
 */
public class UserLoginService {

	/**
	 * ユーザーログイン
	 */
	public User searchUser(String userId, String password) throws Exception {

		if (ThreeUtils.isEmpty(userId) && ThreeUtils.isEmpty(password)) {
			throw new Exception(MessageConst.MSG_INPUT_EMPTY_ID_AND_PASS);
		}

		if (ThreeUtils.isEmpty(userId)) {
			throw new Exception(MessageConst.MSG_INPUT_EMPTY_USER_ID);
		}

		if (ThreeUtils.isEmpty(password)) {
			throw new Exception(MessageConst.MSG_INPUT_EMPTY_PASSWORD);
		}

		UserDao dao = new UserDao();
		User user = dao.getUser(userId, password);

		if (user == null) {
			throw new Exception(MessageConst.MSG_ERR_LOGIN_ERROR);
		}

		return user;
	}
}
