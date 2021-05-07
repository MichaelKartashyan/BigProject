import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class ListDisplayCashier extends JPanel implements Serializable {
    MainFrameCashier parent;

    private String header[] = {"flight number","Name","Surname","Pasport number","ticket type"};
    private JTable table;
    private JScrollPane scrollPane;

    private JButton but;


    public ListDisplayCashier(MainFrameCashier parent) {
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
            parent.showMainDisplayCashier();

        }
    });
}
    public void generateTable(ArrayList<Tickets> tickets){

        Object Tickets[][] = new Object[tickets.size()][5];

        for(int i =0;i<tickets.size();i++){
            System.out.println(tickets.get(i).toString());
            Tickets[i][0] = tickets.get(i).getFlightId();
            Tickets[i][1] = tickets.get(i).getName();
            Tickets[i][2] = tickets.get(i).getSurname();
            Tickets[i][3] = tickets.get(i).getPassportNumber();
            Tickets[i][4] = tickets.get(i).getTicketType();

        }

        DefaultTableModel model = new DefaultTableModel(Tickets, header);
        this.table.setModel(model);

    }
}
