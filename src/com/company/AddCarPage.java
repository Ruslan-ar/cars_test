package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCarPage extends Container {
    private MainFrame parent;
    private  ApplicationLabel nameLabel, priceLabel, engineVolumeLabel;
    private ApplicationField nameField, priceField, engineVolumeField;
    private ApplicationButton addButton, backButton;

    public AddCarPage(MainFrame parent){
        this.parent = parent;
        setSize(750,650);
        setLocation(0,0);
        setLayout(null);

        nameLabel = new ApplicationLabel("CAR NAME :");
        nameLabel.setLocation(150, 50);
        add(nameLabel);

        nameField = new ApplicationField ();
        nameField.setLocation(350, 50);
        add(nameField);

        priceLabel = new ApplicationLabel("CAR PRICE (USD) :");
        priceLabel.setLocation(150, 150);
        add(priceLabel);

        priceField = new ApplicationField ();
        priceField.setText("0");
        priceField.setLocation(350, 150);
        add(priceField);

        engineVolumeLabel = new ApplicationLabel("CAR ENGINE VOLUME :");
        engineVolumeLabel.setLocation(150, 250);
        add(engineVolumeLabel);

        engineVolumeField = new ApplicationField ();
        engineVolumeField.setText("0");
        engineVolumeField.setLocation(350, 250);
        add(engineVolumeField);

        addButton = new ApplicationButton("ADD CAR");
        addButton.setLocation(250,480);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameField.getText();
                String priceText = priceField.getText();
                String engineVolumeText = engineVolumeField.getText();
                double engineVolume = 0;
                try{
                    engineVolume = Integer.parseInt(engineVolumeText);
                }catch (Exception e){
                }
                nameField.setText("");
                priceField.setText("0");
                engineVolumeField.setText("0");

                parent.addCar(new Cars(null, name, priceText, engineVolume));

            }
        });

        backButton = new ApplicationButton("Back");
        backButton.setLocation(250, 550);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.hideMainMenuPage();
                parent.showAddCarPage();
            }
        });




    }
}
