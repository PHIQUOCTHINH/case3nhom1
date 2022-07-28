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

public class CategoryRepository {
    private final MyConnection myConnection = new MyConnection();
    private final String SELECT_CATEGORY_BY_ID ="select*from Category where id =?";
    private final String SELECT_ALL_CATEGORY="select*from Category ";
    private final String INSERT_CATEGORY = "insert into Category(nameCategory)" +
            "value(?)";
    private final String UPDATE_CATEGORY = "update Category set nameCategory = ? " +
            "where id = ?";
    private final String DELETE_CATEGORY_BY_ID = "delete from Category where id = ?";
    public ArrayList<Category> findAll(){
        ArrayList<Category> categories = new ArrayList<>();
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String category_name = resultSet.getString("nameCategory");
                Category category = new Category(id,category_name);
                categories.add(category);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return categories;
    }

    public Category findById( int id){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String category = resultSet.getString("nameCategory");

                return new Category(id,category);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public void create(Category category) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(INSERT_CATEGORY, category);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    public void update(Category category) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(UPDATE_CATEGORY, category);
            preparedStatement.setInt(2, category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    private PreparedStatement getPreparedStatement(String SQL, Category category) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, category.getNameCategory());

        return preparedStatement;
    }
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }

}
