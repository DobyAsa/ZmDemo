package com.dobyasa.controller;

import com.dobyasa.entity.Users;
import com.dobyasa.service.UserService;
import com.dobyasa.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginController")
public class LoginController extends HttpServlet {

	private UserService service = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		// System.out.println("name=" + name);
		// System.out.println("password=" + pwd);

		Users users = new Users();

		users.setName(name);
		users.setPwd(pwd);

		boolean flag = service.checkUser(users);

		// 登录验证
		if (flag) {// 登录成功
			request.getRequestDispatcher("/Main").forward(request, response);
		} else {
			// 登录失败
			request.setAttribute("errMsg", "对不起，用户名不存在或密码不匹配，请重新输入");
			request.getRequestDispatcher("/Login").forward(request, response);

		}

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
