package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
    private Connection connection;

    public void connect(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
            "jdbc:mysql//localhost:3306/test_cars?useUnicode=true&serverTimezone=UTC",
            "root", "");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addCars(Cars car){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                      "INSERT INTO cars (name, price, engineVolume)" +
                    "VALUES (?, ?, ?)");

            statement.setString(1, car.getName());
            statement.setInt(2, car.getPrice());
            statement.setDouble(3, car.getEngineVolume());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Cars> getAllCars(){
        ArrayList<Cars> cars = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "Select id, name, price, engineVolume FROM cars");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
             cars.add(new Cars(
                     resultSet.getLong("id"),
                     resultSet.getString("name"),
                     resultSet.getInt("price"),
                     resultSet.getDouble("engineVolume")
             ));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return cars;
    }

    public void updateCars(Cars car){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                            "UPDATE cars SET name = ?, price = ?, engineVolume = ?" +
                    "WHERE id = ?");


            statement.setString(1, car.getName());
            statement.setInt(2, car.getPrice());
            statement.setDouble(3, car.getEngineVolume());
            statement.setLong(4, car.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void deleteCars(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM cars WHERE id = ?");

            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
