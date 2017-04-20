package Files;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Glowny extends JFrame{
    JTable table1;

    public Glowny(ArrayList<List<String>> base){
        setLayout(new BorderLayout());
        Object[] columnNames = base.get(0).toArray();
        base.remove(0);
        final Object[][] r = new String[base.size()][];
        int i = 0;
        for (List<String> l : base)
            r[i++] = l.toArray(new String[l.size()]);
        table1 = new JTable(r,columnNames);
        table1.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table1.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table1);
        add(scrollPane);
    }

    public static void main(String[] args) {



    }
    private void createUIComponents() {

    }
}
