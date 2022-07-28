package com.example.demo12.DAO;

import com.example.demo12.connection.MyConnection;
import com.example.demo12.model.Category;
import com.example.demo12.model.PublishingCompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublishingCompanyRepository {
    private final MyConnection myConnection = new MyConnection();
    private final String SELECT_PUBLISH_COM_BY_ID ="select*from Publishing_company where id =?";
    private final String SELECT_ALL_PUBLISH_COM="select*from Publishing_company ";
    private final String INSERT_PUBLISH_COM = "insert into Publishing_company(name_Publishing)" +
            "value(?)";
    private final String UPDATE_PUBLISH_COM = "update Publishing_company set name_Publishing = ? " +
            "where id = ?";
    private final String DELETE_PUBLISH_COM_BY_ID = "delete from Publishing_company where id = ?";
    public ArrayList<PublishingCompany> findAll(){
        ArrayList<PublishingCompany> publishingCompanies = new ArrayList<>();
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PUBLISH_COM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name_Publishing");
                PublishingCompany publishingCompany = new PublishingCompany(id,name);
                publishingCompanies.add(publishingCompany);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return publishingCompanies;
    }

    public PublishingCompany findById( int id){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PUBLISH_COM_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name_Publishing");
                return new PublishingCompany(id,name);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }


    public void create(PublishingCompany publishingCompany) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(INSERT_PUBLISH_COM, publishingCompany);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    public void update(PublishingCompany publishingCompany) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(UPDATE_PUBLISH_COM, publishingCompany);
            preparedStatement.setInt(2, publishingCompany.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    private PreparedStatement getPreparedStatement(String SQL, PublishingCompany publishingCompany) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, publishingCompany.getNamePublishing());

        return preparedStatement;
    }
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PUBLISH_COM_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
}
