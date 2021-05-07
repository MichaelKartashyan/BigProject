import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;


public class MainDisplayFlights extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private JButton addT;
    private JButton listT;
    private JButton editT;
    private JButton deleteT;
    private JButton exit;

    public MainDisplayFlights(MainFrameAdmin parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        addT = new JButton("Add Flights");
        addT.setBounds(200,100,100,30);
        add(addT);
        addT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientAdmin.SendListAircrafts();
                ClientAdmin.aircrafts = ClientAdmin.takeAircrafts();
                ClientAdmin.SendList();
                ClientAdmin.cities = ClientAdmin.takeCityes();
                parent.addDisplayFlights.SelectAircrafts(ClientAdmin.aircrafts);
                parent.addDisplayFlights.SelectCity(ClientAdmin.cities);
                parent.showAddDisplayFlights();
            }
        });

        listT = new JButton("List Flights");
        listT.setBounds(200,150,100,30);
        add(listT);
        listT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientAdmin.SendListFlights();
                ClientAdmin.flights = ClientAdmin.takeFlights();
                parent.showListDisplayFlights();
                parent.listDisplayFlights.generateTable(ClientAdmin.flights);

            }
        });


        editT = new JButton("Edit Flights");
        editT.setBounds(200,200,100,30);
        add(editT);
        editT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientAdmin.SendListFlights();
                ClientAdmin.flights = ClientAdmin.takeFlights();
                ClientAdmin.SendListAircrafts();
                ClientAdmin.aircrafts = ClientAdmin.takeAircrafts();
                ClientAdmin.SendList();
                ClientAdmin.cities = ClientAdmin.takeCityes();
                parent.editDisplayFlights.SelectAircrafts(ClientAdmin.aircrafts);
                parent.editDisplayFlights.SelectCity(ClientAdmin.cities);
                parent.editDisplayFlights.SelectFlights(ClientAdmin.flights);
                parent.showEditDisplayFlights();

            }
        });

        deleteT = new JButton("Delete Flights");
        deleteT.setBounds(200,250,100,30);
        add(deleteT);
        deleteT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                ClientAdmin.SendListFlights();
//                ClientAdmin.flights = ClientAdmin.takeFlights();
                ClientAdmin.takeFlightss();
                parent.deleteDisplayFlights.SelectDelete(ClientAdmin.flights);
                parent.showDeleteDisplayFlights();
            }
        });

        exit = new JButton("Come back");
        exit.setBounds(200,300,100,30);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.hideAll();
            }
        });
    }
}
