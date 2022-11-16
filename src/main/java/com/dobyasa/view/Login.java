package com.dobyasa.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login", "/"})
public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String errMsg=(String) request.getAttribute("errMsg");

		out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'><html><head><title>login.html</title>");
		out.println("<meta http-equiv='keywords' content='keyword1,keyword2,keyword3'><meta http-equiv='description' content='this is my page'><meta http-equiv='content-type' content='text/html; charset=UTF-8'><!--<link rel='stylesheet' type='text/css' href='./styles.css'>-->");
		out.println("</head><body><h1>用户登录</h1>");
		out.println("<form action='LoginController' method='get'>");
		out.println("<label for='user'>用户名：</label>");
		out.println("<input type='text' name='name' id='user' /><br />");
		out.println("<label for='pwd'>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>");
		out.println("<input type='password' name='pwd' id='pwd' /><br />");
		out.println("<input type='submit' value='登录' /><input type='reset' value='重置' />");
		out.println("<p>"+errMsg+"<p/>");
		out.println("</form></body></html>");

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
