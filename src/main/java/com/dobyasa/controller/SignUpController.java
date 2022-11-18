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
import java.util.Base64;

@WebServlet(urlPatterns = "/SignUpController")
public class SignUpController extends HttpServlet {
    private final UserService service = new UserServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        pwd = Base64.getEncoder().encodeToString(pwd.getBytes());

        Users user = new Users();

        user.setName(name);
        user.setPwd(pwd);

        boolean flag = service.addUser(user);
        // 注册验证
        if (flag) {// 成功
            request.getRequestDispatcher("/Main").forward(request, response);
        } else {
            // 登录失败
            request.setAttribute("errMsg", "对不起，该用户已存在。");
            request.getRequestDispatcher("/Login").forward(request, response);

        }

        out.flush();
        out.close();
    }
}
