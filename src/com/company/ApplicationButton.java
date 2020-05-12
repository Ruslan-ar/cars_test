package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ApplicationButton extends JButton {
    public ApplicationButton(String text){
        super(text);
        setSize(200,30);
        setBackground(StaticConfig.buttonBackgroundColor);
        setForeground(StaticConfig.buttonTextColor);
        setBorder(new LineBorder(StaticConfig.butonBorderColor));
        setFont(StaticConfig.textFont);
    }

}
