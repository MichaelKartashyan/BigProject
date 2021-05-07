import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class MainDisplayCities extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private JButton addT;
    private JButton listT;
    private JButton editT;
    private JButton deleteT;
    private JButton exit;

    public MainDisplayCities(MainFrameAdmin parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        addT = new JButton("Add city");
        addT.setBounds(200,100,100,30);
        add(addT);
        addT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showAddDisplayCities();
            }
        });

        listT = new JButton("List city");
        listT.setBounds(200,150,100,30);
        add(listT);
        listT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientAdmin.SendList();
                ClientAdmin.cities = ClientAdmin.takeCityes();
                parent.showListDisplayCity();
                parent.listDisplayCity.generateTable(ClientAdmin.cities);

            }
        });


        editT = new JButton("Edit city");
        editT.setBounds(200,200,100,30);
        add(editT);
        editT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ClientAdmin.SendList();
            ClientAdmin.cities = ClientAdmin.takeCityes();
            parent.editDisplayCity.SelectEdit(ClientAdmin.cities);
            parent.showEditDisplayCity();

            }
        });

        deleteT = new JButton("Delete city");
        deleteT.setBounds(200,250,100,30);
        add(deleteT);
        deleteT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientAdmin.SendList();
                ClientAdmin.cities = ClientAdmin.takeCityes();
                parent.deleteDisplayCity.SelectDelete(ClientAdmin.cities);
                parent.showDeleteDisplayCity();
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

