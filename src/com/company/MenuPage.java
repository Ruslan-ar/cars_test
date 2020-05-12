package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends Container {

    private MainFrame parent;
    private ApplicationButton addCarButton, listCarsButton;

    public MenuPage(MainFrame parent){

        this.parent = parent;
        setSize(750,650);
        setLocation(0,0);
        setLayout(null);

        addCarButton = new ApplicationButton("ADD CAR");
        addCarButton.setLocation(250,50);
        add(addCarButton);
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.hideMainMenuPage();
                parent.showAddCarPage();
            }
        });

        listCarsButton = new ApplicationButton("LIST ALL CARS");
        listCarsButton.setLocation(250,150);
        add(listCarsButton);
        listCarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.fillTable(parent.listCars());
                parent.hideMainMenuPage();
                parent.showListCarPage();
            }
        });
    }
}
