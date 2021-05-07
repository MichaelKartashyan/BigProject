import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class MainDisplayCashier extends JPanel implements Serializable {
   private MainFrameCashier parent;
   private JButton addT;
   private JButton listT;
   private JButton editT;
   private JButton deleteT;
   private JButton exit;

    public MainDisplayCashier( MainFrameCashier parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);
        addT = new JButton("Add tickets");
        addT.setBounds(200,100,100,30);
        add(addT);
        addT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientCashier.takeFlights();
                parent.addDisplayCashier.SelectFlights(ClientCashier.flights);
                parent.showAddDisplayCashier();

            }
        });

        listT = new JButton("List tickets");
        listT.setBounds(200,150,100,30);
        add(listT);
        listT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientCashier.SendList();
                ClientCashier.tickets = ClientCashier.takeTickets();
                parent.showListDisplayCashier();
                parent.listDisplayCashier.generateTable(ClientCashier.tickets);
            }
        });


        editT = new JButton("Edit tickets");
        editT.setBounds(200,200,100,30);
        add(editT);
        editT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientCashier.SendList();
                ClientCashier.tickets = ClientCashier.takeTickets();
                parent.editDisplayCashier.SelectEdit(ClientCashier.tickets);
                parent.showEditDisplayCashier();


            }
        });

        deleteT = new JButton("Delete tickets");
        deleteT.setBounds(200,250,100,30);
        add(deleteT);
        deleteT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientCashier.SendList();
                ClientCashier.tickets = ClientCashier.takeTickets();
                parent.deleteDisplayCashier.SelectDelete(ClientCashier.tickets);
                parent.showDeleteDisplayCashier();
            }
        });

        exit = new JButton("Exit");
        exit.setBounds(200,300,100,30);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
