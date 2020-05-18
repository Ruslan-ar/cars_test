package com.company;


import javax.swing.*;

public class ApplicationLabel extends JLabel {

    public ApplicationLabel(String text){
        super(text);
        setSize(200,30);
        setForeground(StaticConfig.textFieldTextColor);
        setFont(StaticConfig.textFont);
    }

}