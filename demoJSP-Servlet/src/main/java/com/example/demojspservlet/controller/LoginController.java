package com.example.demojspservlet.controller;

import com.example.demojspservlet.entity.User;
import com.example.demojspservlet.service.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginController extends HttpServlet {

    private LoginService loginService;

    public LoginController(){
        loginService = new LoginService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String)request.getParameter("username");
        String password = (String)request.getParameter("password");

        User user = null;
        try {
            user = loginService.login(username, password);
            if(user != null){
                request.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home.jsp");
            } else{
                getServletContext().getRequestDispatcher("/login.jsp").forward (request, response);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
