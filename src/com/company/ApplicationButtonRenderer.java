package com.company;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ApplicationButtonRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ApplicationButton button = (ApplicationButton) value;
        return button;
    }
}
