package com.example.demo12.controller;

import com.example.demo12.model.*;
import com.example.demo12.service.impl.BookService;
import com.example.demo12.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    BookService bookService = new BookService();
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                showLoginForm(request,response);
                break;
            case "sign":
                showCreateForm(request, response);
                break;
            case "updateUser":
                showCreateUForm(request,response);
                break;
            default:
                displayAllBook(request,response);
                break;

        }
    }
        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "login":
                    login(request, response);
                    break;
                case "sign":
                    sign(request, response);
                    break;
                case "updateUser":
                    updateUser(request,response);
                    break;

            }}
    private void sign(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        User user = new User(email,password);
        UserService userService = new UserService();

        try {
            if (!isExitUser(email)){
                userService.create(user);
                response.sendRedirect("/loginServlet?action=login");
            }else {
                request.setAttribute("message","Tài khoản đã tồn tại!");
                request.getRequestDispatcher("user/create.jsp").forward(request,response);

            }
        }catch (Exception e){
            System.out.println();
        }
    }
            private void login (HttpServletRequest request, HttpServletResponse response){
                String email = request.getParameter("email");
                String password = request.getParameter("pass");
                try {
                    if (isExitUser(email, password)) {
                        ArrayList<Book> books = bookService.findAll();
                        request.setAttribute("books", books);
                       request.setAttribute("email",email);
                        request.getRequestDispatcher("book/display.jsp").forward(request,response);
                    } else {
                        request.setAttribute("message","Tài khoản hoặc mật khẩu chưa đúng!");
                        request.getRequestDispatcher("user/login.jsp").forward(request,response);
                    }

                } catch (Exception e) {
                    System.out.println();
                }

            }
            private boolean isExitUser (String email, String password){
                UserService userService = new UserService();
                ArrayList<User> users = userService.findAll();
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getEmail().equals(email) && users.get(i).getPassword_user().equals(password)) {
                        return true;
                    }
                }
                return false;
            }
    private boolean isExitUser (String email){
        UserService userService = new UserService();
        ArrayList<User> users = userService.findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void displayAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/default.jsp");
        ArrayList<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        requestDispatcher.forward(request, response);
    }

    private void showCreateUForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        User user = userService.findByEmail(email);

        request.setAttribute("u",user);
        request.getRequestDispatcher("user/update.jsp").forward(request,response);
    }


    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String birth = request.getParameter("date");
        String pass = request.getParameter("pass");
        String phone = request.getParameter("phone");
        String image = request.getParameter("image");
        User user = new User(name,email,pass,birth,phone,image);
        userService.update(user);
        response.sendRedirect("book/display.jsp");
    }

}
