import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class ListDisplayFlights extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private String header[] = {"description","Departure Time","Econom Place Price","Business Place Price"};
    private JTable table;
    private JScrollPane scrollPane;

    private JButton but;

    public ListDisplayFlights(MainFrameAdmin parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);



        table = new JTable();
        table.setFont(new Font("Calibri",Font.PLAIN, 12));
        table.setRowHeight(30);
        add(table);


        scrollPane = new JScrollPane(table);
        scrollPane.setSize(400,400);
        scrollPane.setLocation(50,10);
        add(scrollPane);


        but = new JButton("Go back");
        but.setSize(300,20);
        but.setLocation(100,420);
        add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayFlights();

            }
        });
    }
    public void generateTable(ArrayList<Flights> flights){

        Object Flights[][] = new Object[flights.size()][4];

        for(int i =0;i<flights.size();i++){
            Flights[i][0] = flights.get(i).getDescription();
            Flights[i][1] = flights.get(i).getDepartureTime();
            Flights[i][2] = flights.get(i).getEconomPlacePrice();
            Flights[i][3] = flights.get(i).getBusinessPlacePrice();

        }
        DefaultTableModel model = new DefaultTableModel(Flights, header);
        this.table.setModel(model);
    }

}
