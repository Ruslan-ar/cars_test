package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCarPage extends Container {

    private MainFrame parent;
    private ApplicationLabel nameLabel, priceLabel, engineVolumeLabel;
    private ApplicationField nameField, priceField, engineVolumeField;
    private ApplicationButton addButton, backButton;

    public AddCarPage(MainFrame parent){
        this.parent = parent;
        setSize(700,700);
        setLocation(0,0);
        setLayout(null);

        nameLabel = new ApplicationLabel("CAR NAME :");
        nameLabel.setLocation(150, 50);
        add(nameLabel);

        nameField = new ApplicationField();
        nameField.setLocation(350,50);
        add(nameField);

        priceLabel = new ApplicationLabel("CAR PRICE (USD) :");
        priceLabel.setLocation(150, 150);
        add(priceLabel);

        priceField = new ApplicationField();
        priceField.setText("0");
        priceField.setLocation(350,150);
        add(priceField);

        engineVolumeLabel = new ApplicationLabel("CAR ENGINE VOLUME :");
        engineVolumeLabel.setLocation(150, 250);
        add(engineVolumeLabel);

        engineVolumeField = new ApplicationField();
        engineVolumeField.setLocation(350,250);
        engineVolumeField.setText("0");
        add(engineVolumeField);

        addButton = new ApplicationButton("ADD CAR");
        addButton.setLocation(250, 480);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameField.getText();
                String priceText = priceField.getText();
                String engineVolumeText = engineVolumeField.getText();
                double engineVolume = 0;
                try{
                    engineVolume = Double.parseDouble(engineVolumeText);
                }catch (Exception e){
                }
                int price = 0;
                try{
                    price = Integer.parseInt(priceText);
                }catch (Exception e){
                }
                nameField.setText("");
                engineVolumeField.setText("0");
                priceField.setText("0");

                parent.addCar(new Cars(null, name, price, engineVolume));

            }
        });

        backButton = new ApplicationButton("BACK");
        backButton.setLocation(250, 550);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.hideAddCarPage();
                parent.showMainMenuPage();
            }
        });

    }

}
