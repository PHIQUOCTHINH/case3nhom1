package com.example.demo12.DAO;

import com.example.demo12.connection.MyConnection;
import com.example.demo12.model.Category;
import com.example.demo12.model.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocationRepository {
    private final MyConnection myConnection = new MyConnection();
    private final String SELECT_LOCATION_BY_ID ="select*from location where id =?";
    private final String SELECT_ALL_LOCATION="select*from location ";
    private final String INSERT_LOCATION = "insert into location(name_location,painted,capacity,amount)" +
            "value(?,?,?,?)";
    private final String UPDATE_LOCATION = "update location set name_location = ?,painted = ?,capacity = ?, amount = ? " +
            "where id = ?";
    private final String DELETE_LOCATION_BY_ID = "delete from location where id = ?";


    public ArrayList<Location> findAll(){
        ArrayList<Location> locations = new ArrayList<>();
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOCATION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String location_name = resultSet.getString("name_location");
                String painted = resultSet.getString("painted");
                int capacity = resultSet.getInt("capacity");
                int amount = resultSet.getInt("amount");
                Location location = new Location(id,location_name,painted,capacity,amount);
                locations.add(location);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return locations;
    }

    public Location findById( int id){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOCATION_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String location_name = resultSet.getString("name_location");
                String painted = resultSet.getString("painted");
                int capacity = resultSet.getInt("capacity");
                int amount = resultSet.getInt("amount");
                return new Location(id,location_name,painted,capacity,amount);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public void update(Location location) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(UPDATE_LOCATION, location);
            preparedStatement.setInt(5, location.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    private PreparedStatement getPreparedStatement(String SQL, Location location) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, location.getNameLocation());
        preparedStatement.setString(2, location.getPainted());
        preparedStatement.setInt(3, location.getCapacity());
        preparedStatement.setInt(4, location.getAmount());
        return preparedStatement;
    }
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LOCATION_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    public void create(Location location) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(INSERT_LOCATION, location);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
}
