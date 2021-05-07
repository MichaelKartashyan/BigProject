import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class ListDisplayAircrafts extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private String header[] = {"Names","Model","Business Class Capacity","Econom Class Capacity"};
    private JTable table;
    private JScrollPane scrollPane;

    private JButton but;

    public ListDisplayAircrafts(MainFrameAdmin parent) {
        this.parent = parent;
        setSize(500,500);
        setLayout(null);



        table = new JTable();
        table.setFont(new Font("Calibri",Font.PLAIN, 12));
        table.setRowHeight(30);
        add(table);


        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,400);
        scrollPane.setLocation(100,10);
        add(scrollPane);


        but = new JButton("Go back");
        but.setSize(300,20);
        but.setLocation(100,420);
        add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayAircrafts();

            }
        });
    }
    public void generateTable(ArrayList<Aircrafts> aircrafts){

        Object Aircrafts[][] = new Object[aircrafts.size()][4];

        for(int i =0;i<aircrafts.size();i++){
            Aircrafts[i][0] = aircrafts.get(i).getName();
            Aircrafts[i][1] = aircrafts.get(i).getModel();
            Aircrafts[i][2] = aircrafts.get(i).getBusiness_class_capacity();
            Aircrafts[i][3] = aircrafts.get(i).getEconom_class_capacity();

        }
        DefaultTableModel model = new DefaultTableModel(Aircrafts, header);
        this.table.setModel(model);
    }
}
