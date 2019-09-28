package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import servise.UserLoginService;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		User user = null;

		UserLoginService loginService = new UserLoginService();
		try {
			user = loginService.searchUser(request.getParameter("userId"), request.getParameter("password"));
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			RequestDispatcher dispatch = request.getRequestDispatcher("/userLogin.jsp");
			dispatch.forward(request, response);
			return;
		}
		request.setAttribute("user", user);
		RequestDispatcher dispatch = request.getRequestDispatcher("/userInfo.jsp");
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
