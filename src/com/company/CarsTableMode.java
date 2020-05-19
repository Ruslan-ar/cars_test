package com.company;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CarsTableMode extends AbstractTableModel {

    private ArrayList<Cars> cars;

    public CarsTableMode(ArrayList<Cars> cars){
        super();
        this.cars = cars;
    }

    @Override
    public int getRowCount() {

        return cars.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col){
            case 0 :
                return cars.get(row).getId();
            case 1 :
                return cars.get(row).getName();
            case 2 :
                return cars.get(row).getPrice();
            case 3 :
                return cars.get(row).getEngineVolume();
            case 4:
                final ApplicationButton editButton = new ApplicationButton("EDIT CAR");
                editButton.setBackground(Color.DARK_GRAY);
                editButton.setFont(new Font("Calibri", 1, 16));
                editButton.setBorder(null);
                editButton.setSize(100, 20);
                return editButton;
            default: return "";
        }
    }
    @Override
    public String getColumnName(int column) {
        String result = "";
        switch (column){
            case 0:
                result = "ID";
                break;
            case 1:
                result = "NAME";
                break;
            case 2:
                result = "PRICE";
                break;
            case 3:
                result = "ENGINE VOLUME";
                break;
            case 4:
                result = "EDIT";
                break;

        }
        return result;
    }

}
