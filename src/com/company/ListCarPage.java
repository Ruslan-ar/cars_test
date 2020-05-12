package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListCarPage extends Container {

    private MainFrame parent;
    private ApplicationButton backButton;
    private JTable table;
    private JScrollPane pane;
    private JPanel panel;

    public ListCarPage(MainFrame parent){

        this.parent = parent;

        setSize(630, 680);
        setLocation(0, 0);
        setLayout(null);

        backButton = new ApplicationButton("BACK");
        backButton.setLocation(250,550);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.hideAddCarPage();
                parent.showAddCarPage();
            }
        });

        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(600,400));
        table.setRowHeight(30);

        pane = new JScrollPane(table);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setLocation(0,0);
        panel.setSize(638,430);

        panel.add(pane);
        add(panel);
    }

    public void fillTable(ArrayList<Cars> cars){
        CarsTableMode tableMode = new CarsTableMode(cars);
        table.setModel(tableMode);
        parent.refresh();
    }
}
