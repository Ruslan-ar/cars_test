package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListCarPage extends Container {

    private  MainFrame parent;
    private  ApplicationButton backButton;
    private  JTable table;
    private  JScrollPane pane;
    private  JPanel panel;
    private final ApplicationButtonRenderer buttonRenderer = new ApplicationButtonRenderer();

    public ListCarPage(MainFrame parent){

        this.parent = parent;

        setSize(700,700);
        setLocation(0,0);
        setLayout(null);

        backButton = new ApplicationButton("BACK");
        backButton.setLocation(250, 550);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.hideListCarPage();
                parent.showMainMenuPage();
            }
        });

        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(650, 450));
        table.setRowHeight(30);
        table.addMouseListener(new TableButtonMouseListener(table, parent, this));

        pane = new JScrollPane(table);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setLocation(0,0);
        panel.setSize(688,480);

        panel.add(pane);
        add(panel);

    }

    public void fillTable(ArrayList<Cars> cars){
        CarsTableMode tableModel = new CarsTableMode(cars);
        table.setModel(tableModel);
        table.getColumn("EDIT").setCellRenderer(buttonRenderer);
        parent.refresh();
    }

}
