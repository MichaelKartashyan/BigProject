import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class EditDisplayAircrafts extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private PackageData pd;
    private Aircrafts aircrafts;

    private Aircrafts[] Aircrafts= new Aircrafts[20];
    private JComboBox comboBox;

    private JButton select;

    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;


    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;


    private JButton but1;
    private JButton but2;

    private Long id;


    public EditDisplayAircrafts(MainFrameAdmin parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        comboBox = new JComboBox();
        comboBox.setBounds(30,1,400,20);
        add(comboBox);

        select = new JButton("Select");
        select.setBounds(200,30,100,20);
        add(select);
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aircrafts aircrafts2 = (Aircrafts) comboBox.getSelectedItem();

                textField1.setText(aircrafts2.getName());
                textField2.setText(aircrafts2.getModel());
                textField3.setText(String.valueOf(aircrafts2.getBusiness_class_capacity()));
                textField4.setText(String.valueOf(aircrafts2.getEconom_class_capacity()));

                id = aircrafts2.getId();
            }
        });




        lbl1 = new JLabel("Name ");
        lbl1.setBounds(100,100,100,20);
        add(lbl1);

        textField1 = new JTextField();
        textField1.setBounds(200,100,100,20);
        add(textField1);


        lbl2 = new JLabel("Model ");
        lbl2.setBounds(100,150,100,20);
        add(lbl2);

        textField2 = new JTextField();
        textField2.setBounds(200,150,100,20);
        add(textField2);

        lbl3 = new JLabel("Business class capacity ");
        lbl3.setBounds(100,200,100,20);
        add(lbl3);

        textField3 = new JTextField();
        textField3.setBounds(200,200,100,20);
        add(textField3);

        lbl4 = new JLabel("Econom class capacity ");
        lbl4.setBounds(100,250,100,20);
        add(lbl4);

        textField4 = new JTextField();
        textField4.setBounds(200,250,100,20);
        add(textField4);


        but1 = new JButton("Edit City");
        but1.setBounds(200,350,100,20);
        add(but1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String model = textField2.getText();
                int business_class_capacity = Integer.parseInt(textField3.getText());
                int econom_class_capacity = Integer.parseInt(textField4.getText());

                aircrafts = new Aircrafts(id,name, model,business_class_capacity,econom_class_capacity);
                try{
                    pd = new PackageData("EditAircraft", aircrafts);
                    ClientAdmin.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");

                parent.showMainDisplayAircrafts();

            }
        });

        but2 = new JButton("Come back");
        but2.setBounds(300,350,100,20);
        add(but2);
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayAircrafts();
            }
        });
    }

    public void SelectEdit(ArrayList<Aircrafts> aircrafts){
        if(ClientAdmin.cities!=null){
            for(int i =0;i<aircrafts.size();i++){
                Aircrafts[i] = aircrafts.get(i);
            }
            comboBox.setModel(new DefaultComboBoxModel(Aircrafts));
        }
    }
}
