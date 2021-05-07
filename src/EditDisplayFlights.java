import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class EditDisplayFlights extends JPanel implements Serializable {
    MainFrameAdmin parent;

    PackageData pd;
    Flights flight;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;


    private Flights[] Flights= new Flights[20];
    private JComboBox comboBox4;

    private Aircrafts[] Aircrafts= new Aircrafts[20];
    private JComboBox comboBox;

    private Cities[] Cities = new Cities[20];
    private JComboBox comboBox2;
    private JComboBox comboBox3;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    private JButton but1;
    private JButton but2;
    private JButton select;

    Long id;

    public EditDisplayFlights(MainFrameAdmin parent) {
        this.parent = parent;



        setSize(500,500);
        setLayout(null);


        comboBox4 = new JComboBox();
        comboBox4.setBounds(100,0,300,20);
        add(comboBox4);
        select = new JButton("Select");
        select.setBounds(200,25,100,20);
        add(select);
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flights flights2 = (Flights) comboBox4.getSelectedItem();

                textField1.setText(flights2.getDescription());
                textField2.setText(flights2.getDepartureTime());
                textField3.setText(String.valueOf(flights2.getEconomPlacePrice()));
                textField4.setText(String.valueOf(flights2.getBusinessPlacePrice()));

                id = flights2.getId();
            }
        });


        lbl1 = new JLabel("Flight description ");
        lbl1.setBounds(100,50,100,20);
        add(lbl1);

        textField1 = new JTextField();
        textField1.setBounds(200,50,200,20);
        add(textField1);

        comboBox = new JComboBox();
        comboBox.setBounds(100,100,300,20);
        add(comboBox);

        comboBox2 = new JComboBox();
        comboBox2.setBounds(100,150,300,20);
        add(comboBox2);

        comboBox3 = new JComboBox();
        comboBox3.setBounds(100,200,300,20);
        add(comboBox3);

        lbl2 = new JLabel("Departure time ");
        lbl2.setBounds(100,250,100,20);
        add(lbl2);

        textField2 = new JTextField();
        textField2.setBounds(200,250,200,20);
        add(textField2);

        lbl3 = new JLabel("Econom place price ");
        lbl3.setBounds(100,300,100,20);
        add(lbl3);

        textField3 = new JTextField();
        textField3.setBounds(200,300,200,20);
        add(textField3);

        lbl4 = new JLabel("Business place price ");
        lbl4.setBounds(100,350,100,20);
        add(lbl4);

        textField4 = new JTextField();
        textField4.setBounds(200,350,200,20);
        add(textField4);


        but1 = new JButton("Edit Flight");
        but1.setBounds(200,400,100,20);
        add(but1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = textField1.getText();
                Aircrafts aircrafts = (Aircrafts) comboBox.getSelectedItem();
                Cities city1 = (Cities) comboBox2.getSelectedItem();
                Cities city2 = (Cities) comboBox3.getSelectedItem();
                String departureTime = textField2.getText();
                int economPrice = Integer.parseInt(textField3.getText());
                int businessPrice = Integer.parseInt(textField4.getText());


                flight = new Flights(id,description,aircrafts.getId(),city1.getId(),city2.getId(),departureTime,economPrice,businessPrice);
                try{
                    pd = new PackageData("EditFlights", flight);
                    ClientAdmin.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                comboBox.setSelectedIndex(0);
                comboBox2.setSelectedIndex(0);
                comboBox3.setSelectedIndex(0);

            }
        });

        but2 = new JButton("Come back");
        but2.setBounds(300,400,100,20);
        add(but2);
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayFlights();
            }
        });
    }



    public void SelectFlights(ArrayList<Flights> flights){
        if(ClientAdmin.cities!=null){
            for(int i =0;i<flights.size();i++){
                Flights[i] = flights.get(i);
            }
            comboBox4.setModel(new DefaultComboBoxModel(Flights));
        }
    }

    public void SelectAircrafts(ArrayList<Aircrafts> aircrafts){
        if(ClientAdmin.cities!=null){
            for(int i =0;i<aircrafts.size();i++){
                Aircrafts[i] = aircrafts.get(i);
            }
            comboBox.setModel(new DefaultComboBoxModel(Aircrafts));
        }
    }
    public void SelectCity(ArrayList<Cities> cities){
        if(ClientAdmin.cities!=null){
            for(int i =0;i<cities.size();i++){
                Cities[i] = cities.get(i);
            }
            comboBox2.setModel(new DefaultComboBoxModel(Cities));
            comboBox3.setModel(new DefaultComboBoxModel(Cities));
        }
    }
}
