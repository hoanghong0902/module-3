package controller;

import entity.UserMomo;
import service.IUserMomoService;
import service.impl.IUserMomoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private IUserMomoService IUserMomoService;
    public LoginController() {
        IUserMomoService = new IUserMomoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        request.setAttribute("phoneNumber", phoneNumber);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "login":
                loginMomo(request,response);
                break;
            case "register":
                registerMomo(request,response);
                break;
            default:
                RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("view/user/login.jsp");
                dispatcher.forward(request,response);
        }

    }

    private void registerMomo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("rsUsername");
        String password = request.getParameter("rsPassword");
        String bankAccountNumber = request.getParameter("rsBankAccountNumber");
        String phoneNumber = request.getParameter("rsPhoneNumber");
        boolean messenger;
        try {
            messenger = IUserMomoService.registerUser(username,phoneNumber,password,bankAccountNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher;
        request.setAttribute("messenger2",messenger);
        dispatcher = request.getRequestDispatcher("view/user/login.jsp");
        dispatcher.forward(request,response);
    }

    private void loginMomo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        UserMomo userMomo;
        try {
            userMomo = IUserMomoService.loginUser(phoneNumber,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher;
        if(userMomo!=null){
            if(password.equals(userMomo.getPassword())){
                request.setAttribute("phoneNumber", phoneNumber);
                request.setAttribute("userMomo", userMomo);
                dispatcher = request.getRequestDispatcher("view/home.jsp");
                dispatcher.forward(request,response);
            } else {
                request.setAttribute("messenger1",false);
                dispatcher = request.getRequestDispatcher("view/user/login.jsp");
                dispatcher.forward(request,response);
            }
        } else {
            request.setAttribute("messenger1",false);
            dispatcher = request.getRequestDispatcher("view/user/login.jsp");
            dispatcher.forward(request,response);
        }
    }
}
