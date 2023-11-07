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

@WebServlet(name = "ProfileController", value = "/profile")
public class ProfileController extends HttpServlet {
    private IUserMomoService IUserMomoService;
    public ProfileController(){
        IUserMomoService = new IUserMomoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "showProfile":
                try {
                    showProfile(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    showDeleteForm(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        UserMomo userMomo = IUserMomoService.getUser(phoneNumber);
        request.setAttribute("userMomo", userMomo);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/delete.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        UserMomo userMomo = IUserMomoService.getUser(phoneNumber);
        request.setAttribute("userMomo", userMomo);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        UserMomo userMomo = IUserMomoService.getUser(phoneNumber);
        request.setAttribute("userMomo", userMomo);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/profile.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "edit":
                try {
                    editUserMomo(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                deleteUserMomo(request,response);
                break;
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }

    private void deleteUserMomo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        boolean messenger;
        try {
            messenger = IUserMomoService.deleteUser(phoneNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (messenger){
            request.setAttribute("messenger",messenger);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void editUserMomo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String bankAccountNumber = request.getParameter("bankAccountNumber");
        String phoneNumber = request.getParameter("phoneNumber");
        boolean messenger;
        try {
            messenger = IUserMomoService.editUSer(username,phoneNumber,password,bankAccountNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (messenger){
            try {
                request.setAttribute("userMomo", IUserMomoService.getUser(phoneNumber));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/edit.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
