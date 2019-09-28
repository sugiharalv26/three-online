package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import servise.UserRegistService;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userRegist")
public class UserRegistController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setPassword(request.getParameter("password"));
		user.setConfirmPassword(request.getParameter("confirmPassword"));
		user.setUserName(request.getParameter("userName"));
		user.setUserNameKana(request.getParameter("userNameKana"));
		user.setUserGender(request.getParameter("gender"));
		user.setStrBirthDay(request.getParameter("birthDay"));
		user.setUserZip(request.getParameter("zip"));
		user.setUserAddress(request.getParameter("address"));
		user.setUserPhoneNumber(request.getParameter("phone"));
		user.setUserMailAddress(request.getParameter("mailAddress"));

		UserRegistService registService = new UserRegistService();
		try {
			registService.registUser(user);
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			RequestDispatcher dispatch = request.getRequestDispatcher("/userRegist.jsp");
			dispatch.forward(request, response);
		}
		request.setAttribute("errorMsg", "ユーザー登録しました！");
		RequestDispatcher dispatch = request.getRequestDispatcher("/login.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher("/");
		dispatch.forward(request, response);
	}

}
