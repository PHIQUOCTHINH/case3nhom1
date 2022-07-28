package com.example.demo12.DAO;

import com.example.demo12.connection.MyConnection;
import com.example.demo12.model.Book;
import com.example.demo12.model.Category;
import com.example.demo12.model.Location;
import com.example.demo12.model.PublishingCompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepository {
    private final MyConnection myConnection = new MyConnection();
    private final CategoryRepository categoryRepository = new CategoryRepository();
    private final LocationRepository locationRepository = new LocationRepository();
    private final PublishingCompanyRepository publishingCompanyRepository = new PublishingCompanyRepository();
    private final String SELECT_ALL_BOOK = "select * from Book";
    private final String INSERT_BOOK = "insert into Book(namebook, describe_book, image, status_book, id_Category,id_Publishing,id_location)" +
            "value(?,?,?,?,?,?,?)";
    private final String DELETE_BOOK_BY_ID = "delete from Book where id = ?";
    private final String SELECT_BOOK_BY_ID = "select * from Book where id = ?";
    private final String UPDATE_BOOK = "update Book set namebook = ?, describe_book = ?, image = ?,status_book = ?, id_Category = ?,id_Publishing = ?,id_location = ?  " +
            "where id = ?";
    private Book getBook(int id, ResultSet resultSet)throws SQLException {
        String name_book = resultSet.getString("namebook");
        String describe_book = resultSet.getString("describe_book");
        String image = resultSet.getString("image");
        String status_book = resultSet.getString("status_book");
        int id_Category = resultSet.getInt("id_Category");
        int id_Publishing = resultSet.getInt("id_Publishing");
        int id_location = resultSet.getInt("id_location");
        Category category = categoryRepository.findById(id_Category);
        Location location = locationRepository.findById(id_location);
        PublishingCompany publishingCompany = publishingCompanyRepository.findById(id_Publishing);
        return new Book(id,name_book,describe_book,image,status_book,category,publishingCompany,location);

    }
    public Book findById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return getBook(id, resultSet);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    public ArrayList<Book> findAll() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Book book =  getBook(id, resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
        return books;
    }
    public void create(Book book) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(INSERT_BOOK, book);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    public void update(Book book) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(UPDATE_BOOK, book);
            preparedStatement.setInt(8, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    private PreparedStatement getPreparedStatement(String SQL, Book book) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, book.getNameBook());
        preparedStatement.setString(2, book.getDescribeBook());
        preparedStatement.setString(3, book.getImage());
        preparedStatement.setString(4, book.getStatusBook());
        preparedStatement.setInt(5, book.getCategory().getId());
        preparedStatement.setInt(6, book.getPublishingCompany().getId());
        preparedStatement.setInt(7, book.getLocation().getId());
        return preparedStatement;
    }
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }

}
