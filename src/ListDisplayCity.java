import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class ListDisplayCity extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private String header[] = {"Names","Countryes","Short name"};
    private JTable table;
    private JScrollPane scrollPane;

    private JButton but;

    public ListDisplayCity(MainFrameAdmin parent) {
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
                parent.showMainDisplayCities();

            }
        });
    }
    public void generateTable(ArrayList<Cities> cityes){

        Object Cityes[][] = new Object[cityes.size()][3];

        for(int i =0;i<cityes.size();i++){
            Cityes[i][0] = cityes.get(i).getName();
            Cityes[i][1] = cityes.get(i).getCountry();
            Cityes[i][2] = cityes.get(i).getShortName();

        }
        DefaultTableModel model = new DefaultTableModel(Cityes, header);
        this.table.setModel(model);
    }
    }

