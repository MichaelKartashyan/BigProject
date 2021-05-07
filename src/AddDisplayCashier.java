import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class AddDisplayCashier extends JPanel implements Serializable {
    private MainFrameCashier parent;
    Tickets tickets;
    PackageData pd;
    int id =0;
    private Flights[] Flights= new Flights[20];
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;

    private JComboBox comboBox;


    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    private JButton but1;
    private JButton but2;

    public AddDisplayCashier(MainFrameCashier parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        lbl1 = new JLabel("Customer name ");
        lbl1.setBounds(200,100,100,20);
        add(lbl1);

        textField1 = new JTextField();
        textField1.setBounds(300,100,100,20);
        add(textField1);



        lbl5 = new JLabel("Select Flights");
        lbl5.setBounds(200,300,100,20);

        comboBox = new JComboBox();
        comboBox.setBounds(100,300,300,20);
        add(comboBox);


        lbl2 = new JLabel("Customer surname ");
        lbl2.setBounds(200,150,100,20);
        add(lbl2);

        textField2 = new JTextField();
        textField2.setBounds(300,150,100,20);
        add(textField2);

        lbl3 = new JLabel("Passport number ");
        lbl3.setBounds(200,200,100,20);
        add(lbl3);

        textField3 = new JTextField();
        textField3.setBounds(300,200,100,20);
        add(textField3);

        lbl4 = new JLabel("Ticket type ");
        lbl4.setBounds(200,250,100,20);
        add(lbl4);

        textField4 = new JTextField();
        textField4.setBounds(300,250,100,20);
        add(textField4);

        but1 = new JButton("Add tickets");
        but1.setBounds(200,350,100,20);
        add(but1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flights flights2 = (Flights) comboBox.getSelectedItem();
                String name = textField1.getText();
                String surname = textField2.getText();
                String passportNumber = textField3.getText();
                String ticketType = textField4.getText();
                Long flightId = flights2.getId();
                tickets = new Tickets(null,flightId,name, surname,passportNumber,ticketType);
                try{
            pd = new PackageData("AddTicket", tickets);
            ClientCashier.outputStream.writeObject(pd);

        }catch (Exception ex){ex.printStackTrace();}

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                comboBox.setSelectedIndex(0);

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

    public void SelectFlights(ArrayList<Flights> flights){
        if(ClientCashier.flights!=null){
            for(int i =0;i<flights.size();i++){
                Flights[i] = flights.get(i);
            }
            comboBox.setModel(new DefaultComboBoxModel(Flights));
        }
    }

}
