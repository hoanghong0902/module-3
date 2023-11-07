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

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    private IUserMomoService IUserMomoService;
    public HomeController(){
        IUserMomoService = new IUserMomoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        try {
            UserMomo userMomo = IUserMomoService.getUser(phoneNumber);
            request.setAttribute("userMomo",userMomo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
        requestDispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        try {
            UserMomo userMomo = IUserMomoService.getUser(phoneNumber);
            request.setAttribute("userMomo",userMomo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("phoneNumber", phoneNumber);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
        requestDispatcher.forward(request, response);
    }

}
