import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class EditDisplayCashier extends JPanel implements Serializable {
    MainFrameCashier parent;
    //private ArrayList<Tickets> tickets;
   private PackageData pd;
   private Tickets ticket;

    private Tickets[] ticketss= new Tickets[20];
    private JComboBox comboBox;

    private JButton select;

    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;

    Integer flight[] = new Integer[20];
    private JComboBox comboBox2;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    private JButton but1;
    private JButton but2;



    private Long id;




    public EditDisplayCashier(MainFrameCashier parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);


        select = new JButton("Select");
        select.setBounds(200,30,100,20);
        add(select);
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tickets tickets2 = (Tickets)comboBox.getSelectedItem();

                textField1.setText(tickets2.getName());
                textField2.setText(tickets2.getSurname());
                textField3.setText(tickets2.getPassportNumber());
                textField4.setText(tickets2.getTicketType());
                id = tickets2.getId();
            }
        });


        comboBox = new JComboBox();
        comboBox.setBounds(30,1,400,20);
        add(comboBox);

        lbl1 = new JLabel("Customer name ");
        lbl1.setBounds(100,100,100,20);
        add(lbl1);

        textField1 = new JTextField();
        textField1.setBounds(200,100,100,20);
        add(textField1);

        for(Integer i =0;i<10;i++){
            flight[i] = i+1;
        }

        lbl5 = new JLabel("Select Flights");
        lbl5.setBounds(100,300,100,20);
        add(lbl5);
        comboBox2 = new JComboBox(flight);
        comboBox2.setBounds(200,300,100,20);
        add(comboBox2);


        lbl2 = new JLabel("Customer surname ");
        lbl2.setBounds(100,150,100,20);
        add(lbl2);

        textField2 = new JTextField();
        textField2.setBounds(200,150,100,20);
        add(textField2);

        lbl3 = new JLabel("Passport number ");
        lbl3.setBounds(100,200,100,20);
        add(lbl3);

        textField3 = new JTextField();
        textField3.setBounds(200,200,100,20);
        add(textField3);

        lbl4 = new JLabel("Ticket type ");
        lbl4.setBounds(100,250,100,20);
        add(lbl4);

        textField4 = new JTextField();
        textField4.setBounds(200,250,100,20);
        add(textField4);

        but1 = new JButton("Edit tickets");
        but1.setBounds(200,350,100,20);
        add(but1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String surname = textField2.getText();
                String passportNumber = textField3.getText();
                String ticketType = textField4.getText();
                Long flightId = (Long)comboBox2.getSelectedItem();
                ticket = new Tickets(id,flightId,name, surname,passportNumber,ticketType);
                try{
                    pd = new PackageData("EditTicket", ticket);
                    ClientCashier.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                comboBox.setSelectedIndex(0);
                parent.showMainDisplayCashier();
            }
        });

        but2 = new JButton("Come back");
        but2.setBounds(300,350,100,20);
        add(but2);
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayCashier();
            }
        });
    }

    public void SelectEdit(ArrayList<Tickets> tickets){
        if(ClientCashier.tickets!=null){
            for(int i =0;i<tickets.size();i++){
                ticketss[i] = tickets.get(i);
            }
                comboBox.setModel(new DefaultComboBoxModel(ticketss));

        }
    }
    }

