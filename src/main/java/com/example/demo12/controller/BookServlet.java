package com.example.demo12.controller;

import com.example.demo12.model.*;
import com.example.demo12.service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

@WebServlet(name = "BookServlet", value = "/bookServlet")
public class BookServlet extends HttpServlet {
    private final UserService userService = new UserService();

    private final BookService bookService = new BookService();
    private final CategoryService categoryService = new CategoryService();
    private final LocationService locationService = new LocationService();
    private final PublishingCompanyService publishingCompanyService = new PublishingCompanyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createBookGet(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            case "update":
                updateBookGet(request, response);
                break;
            case "detail":
                detailBook(request, response);
                break;
            default:
                displayAllBook(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        switch (action) {
            case "create":
                createBookPost(request, response);
                break;
            case "update":
                updateBookPost(request, response);
                break;
            case "createC":
                createCategory(request,response);
                break;
            case "createL":
                createLocation(request,response);
                break;
            case "createP":
                createPublishingCompany(request,response);
                break;
        }
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Category category = new Category(name);
        categoryService.create(category);
        createBookGet(request,response);
    }
    private void createPublishingCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        PublishingCompany publishingCompany = new PublishingCompany(name);
        publishingCompanyService.create(publishingCompany);
        createBookGet(request,response);
    }
    private void createLocation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String painted = request.getParameter("painted");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Location location = new Location(name,painted,capacity,amount);
        locationService.create(location);
        createBookGet(request,response);
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        bookService.deleteById(id);
        response.sendRedirect("/bookServlet?action=");
    }
    private void detailBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book/detail.jsp");
        Book book = bookService.findById(id);
        request.setAttribute("b",book);
        requestDispatcher.forward(request,response);
    }
    private void updateBookGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        ArrayList<Category> categories = categoryService.findAll();
        ArrayList<PublishingCompany> publishingCompanies = publishingCompanyService.findAll();
        ArrayList<Location> locations = locationService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book/edit.jsp");
        request.setAttribute("b", book);
        request.setAttribute("categories", categories);
        request.setAttribute("writers", publishingCompanies);
        request.setAttribute("locations", locations);
        requestDispatcher.forward(request, response);
    }
    private void updateBookPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        String image = request.getParameter("image");
        String status = request.getParameter("status");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        Category category = categoryService.findById(categoryId);
        int writerId = Integer.parseInt(request.getParameter("writer"));
        PublishingCompany publishingCompany = publishingCompanyService.findById(writerId);
        int locationId = Integer.parseInt(request.getParameter("location"));
        Location location = locationService.findById(locationId);
        Book book = new Book(id,name, describe,image,status,category,publishingCompany,location);
        bookService.update(book);
        response.sendRedirect("/bookServlet?action=");
    }

    private void createBookGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book/create.jsp");
        ArrayList<Category> categories = categoryService.findAll();
        ArrayList<PublishingCompany> publishingCompanies = publishingCompanyService.findAll();
        ArrayList<Location> locations = locationService.findAll();
        request.setAttribute("categories", categories);
        request.setAttribute("writers", publishingCompanies);
        request.setAttribute("locations", locations);
        requestDispatcher.forward(request, response);
    }

    private void createBookPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        String image = request.getParameter("image");
        String status = request.getParameter("status");

        int categoryId = Integer.parseInt(request.getParameter("category"));
        Category category = categoryService.findById(categoryId);
        int writerId = Integer.parseInt(request.getParameter("writer"));
        PublishingCompany publishingCompany = publishingCompanyService.findById(writerId);
        int locationId = Integer.parseInt(request.getParameter("location"));
        Location location = locationService.findById(locationId);
        Book book = new Book(name,describe,image,status,category,publishingCompany,location);
        bookService.create(book);
        response.sendRedirect("/bookServlet?action=");
    }

    private void displayAllBook( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book/display.jsp");
        ArrayList<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        request.setAttribute("email",email);
        requestDispatcher.forward(request, response);
    }




}
