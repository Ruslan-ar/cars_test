package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private MenuPage menuPage;
    private AddCarPage addCarPage;
    private ListCarPage listCarPage;
    private DBConnection dbConnection;

    public MainFrame(){

        dbConnection = new DBConnection();
        dbConnection.connect();

        setSize(750,750);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle(" CARS CLIENT APPLICATION");

        menuPage = new MenuPage(this);
        menuPage.setVisible(true);
        add(menuPage);

        addCarPage = new AddCarPage(this);
        addCarPage.setVisible(false);
        add(menuPage);

        listCarPage = new ListCarPage(this);
        listCarPage.setVisible(false);
        add(listCarPage);

    }
    public void showMainMenuPage(){
        this.menuPage.setVisible(true);
    }
    public void hideMainMenuPage(){
        this.menuPage.setVisible(false);
    }
    public void showAddCarPage(){
        this.addCarPage.setVisible(true);
    }
    public void hideAddCarPage(){
        this.addCarPage.setVisible(false);
    }
    public void showListCarPage(){
        this.listCarPage.setVisible(true);
    }
    public void hideListCarPage(){
        this.listCarPage.setVisible(false);
    }
    public void addCar(Cars car){
        this.dbConnection.addCars(car);
    }
    public void fillTable(ArrayList<Cars> cars){
        this.listCarPage.fillTable(cars);
    }
    public ArrayList<Cars> listCars(){
        return this.dbConnection.getAllCars();
    }
    public void refresh(){
        setResizable(true);
        setSize((int)getSize().getWidth()+1, (int)getSize().getHeight());
        setSize((int)getSize().getWidth()-1, (int)getSize().getHeight());
        setResizable(false);
    }
}
