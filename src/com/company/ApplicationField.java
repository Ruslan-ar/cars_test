package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ApplicationField extends JTextField {

    public ApplicationField(){
        super();
        setSize(200,30);
        setBackground(StaticConfig.textFieldBackgroundColor);
        setForeground(StaticConfig.textFieldTextColor);
        setBorder(new LineBorder(StaticConfig.textFieldBorderColor));
        setFont(StaticConfig.textFont);
    }
}
