package com.example.demo12.DAO;

import com.example.demo12.connection.MyConnection;
import com.example.demo12.model.Category;
import com.example.demo12.model.PublishingCompany;
import com.example.demo12.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class UserRepository {
    private final MyConnection myConnection = new MyConnection();
    private final String SELECT_USER_BY_ID ="select*from Users where id =?";
    private final String SELECT_ALL_USER="select*from Users ";
    private final String INSERT_USER = "insert into Users(name_user,email,password_user,birth,phoneNumber,image)" +
            "value(?,?,?,?,?,?)";
    private final String UPDATE_USER = "update Users set name_user = ?,email = ?,password_user = ?, birth = ? ,phoneNumber = ?,image = ?" +
            "where email = ?";
    private final String DELETE_USER_BY_ID = "delete from Users where id = ?";
    private final String SELECT_USER_BY_EMAIL ="select*from Users where email =?";
    public ArrayList<User> findAll(){
        ArrayList<User> users = new ArrayList<>();
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name_user = resultSet.getString("name_user");
                String email = resultSet.getString("email");
                String password_user = resultSet.getString("password_user");
                String birth = resultSet.getString("birth");
                String phoneNumber = resultSet.getString("phoneNumber");
                String image = resultSet.getString("image");
                User user = new User(id,name_user,email,password_user,birth,phoneNumber,image);
                users.add(user);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return users;
    }

    public User findById( int id){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name_user = resultSet.getString("name_user");
                String email = resultSet.getString("email");
                String password_user = resultSet.getString("password_user");
                String birth = resultSet.getString("birth");
                String phoneNumber = resultSet.getString("phoneNumber");
                String image = resultSet.getString("image");

                return  new User(id,name_user,email,password_user,birth,phoneNumber,image);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public User findByEmail( String email){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name_user = resultSet.getString("name_user");
                String password_user = resultSet.getString("password_user");
                String birth = resultSet.getString("birth");
                String phoneNumber = resultSet.getString("phoneNumber");
                String image = resultSet.getString("image");

                return  new User(id,name_user,email,password_user,birth,phoneNumber,image);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public void create(User user) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(INSERT_USER, user);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public void update(User user) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(UPDATE_USER, user);
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    private PreparedStatement getPreparedStatement(String SQL, User user) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, user.getName_user());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPassword_user());
        preparedStatement.setDate(4, java.sql.Date.valueOf(user.getBirth()));
        preparedStatement.setString(5, user.getPhoneNumber());
        preparedStatement.setString(6, user.getImage());
        return preparedStatement;
    }
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
}
