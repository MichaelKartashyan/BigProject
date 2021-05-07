import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class MainDisplayAircrafts extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private JButton addT;
    private JButton listT;
    private JButton editT;
    private JButton deleteT;
    private JButton exit;

    public MainDisplayAircrafts(MainFrameAdmin parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        addT = new JButton("Add Aircraft");
        addT.setBounds(200,100,100,30);
        add(addT);
        addT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            parent.showAddDisplayAircrafts();
            }
        });

        listT = new JButton("List Aircrafts");
        listT.setBounds(200,150,100,30);
        add(listT);
        listT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientAdmin.SendListAircrafts();
                ClientAdmin.aircrafts = ClientAdmin.takeAircrafts();
                parent.showListDisplayAircrafts();
                parent.listDisplayAircrafts.generateTable(ClientAdmin.aircrafts);

            }
        });


        editT = new JButton("Edit Aircraft");
        editT.setBounds(200,200,100,30);
        add(editT);
        editT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientAdmin.SendListAircrafts();
                ClientAdmin.aircrafts = ClientAdmin.takeAircrafts();
                parent.editDisplayAircrafts.SelectEdit(ClientAdmin.aircrafts);
            parent.showEditDisplayAircrafts();

            }
        });

        deleteT = new JButton("Delete Aircraft");
        deleteT.setBounds(200,250,100,30);
        add(deleteT);
        deleteT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientAdmin.SendListAircrafts();
                ClientAdmin.aircrafts = ClientAdmin.takeAircrafts();
                parent.deleteDisplayAircrafts.SelectDelete(ClientAdmin.aircrafts);
                parent.showDeleteDisplayAircrafts();
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
