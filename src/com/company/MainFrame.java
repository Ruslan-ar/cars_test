package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private MenuPage menuPage;
    private AddCarPage addCarPage;
    private ListCarPage listCarPage;
    private EditCarPage editCarPage;

    private DBConnection dbConnection;

    public MainFrame(){

        dbConnection = new DBConnection();
        dbConnection.connect();

        setSize(700,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("CAR SHOP CLIENT APPLICATION");

        menuPage = new MenuPage(this);
        menuPage.setVisible(true);
        add(menuPage);

        addCarPage = new AddCarPage(this);
        addCarPage.setVisible(false);
        add(addCarPage);

        listCarPage = new ListCarPage(this);
        listCarPage.setVisible(false);
        add(listCarPage);

        editCarPage = new EditCarPage(this);
        editCarPage.setVisible(false);
        add(editCarPage);

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
    public void showEditCarPage(){ this.editCarPage.setVisible(true);}
    public void hideEditCarPage(){ this.editCarPage.setVisible(false);}

    public void fillCarsList(ArrayList<Cars> cars){
        this.listCarPage.fillTable(cars);
    }
    public void prepareEditCarPage(Cars car){this.editCarPage.prepareForm(car);}

    public void addCar(Cars car){
        this.dbConnection.addItem(car);
    }
    public ArrayList<Cars> listCars(){return this.dbConnection.getAllCars(); }
    public Cars getCar(Long id){ return this.dbConnection.getCar(id); }
    public void saveCar(Cars car){ this.dbConnection.updateCar(car);}
    public void deleteCar(Long id){this.dbConnection.deleteCar(id);}

    public void refresh(){
        setResizable(true);
        setSize((int)getSize().getWidth()+1, (int)getSize().getHeight());
        setSize((int)getSize().getWidth()-1, (int)getSize().getHeight());
        setResizable(false);
    }
}
