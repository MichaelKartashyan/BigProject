import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class EditDisplayCity extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private PackageData pd;
    private Cities city;

    private Cities[] Cityes= new Cities[20];
    private JComboBox comboBox;

    private JButton select;

    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;


    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;


    private JButton but1;
    private JButton but2;

    private Long id;

    public EditDisplayCity(MainFrameAdmin parent) {
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
                Cities cities2 = (Cities) comboBox.getSelectedItem();

                textField1.setText(cities2.getName());
                textField2.setText(cities2.getCountry());
                textField3.setText(cities2.getShortName());

                id = cities2.getId();
            }
        });




        lbl1 = new JLabel("City ");
        lbl1.setBounds(100,100,100,20);
        add(lbl1);

        textField1 = new JTextField();
        textField1.setBounds(200,100,100,20);
        add(textField1);


        lbl2 = new JLabel("Country ");
        lbl2.setBounds(100,150,100,20);
        add(lbl2);

        textField2 = new JTextField();
        textField2.setBounds(200,150,100,20);
        add(textField2);

        lbl3 = new JLabel("Short name ");
        lbl3.setBounds(100,200,100,20);
        add(lbl3);

        textField3 = new JTextField();
        textField3.setBounds(200,200,100,20);
        add(textField3);


        but1 = new JButton("Edit City");
        but1.setBounds(200,350,100,20);
        add(but1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String country = textField2.getText();
                String shortName = textField3.getText();

                city = new Cities(id,name, country,shortName);
                try{
                    pd = new PackageData("EditCity", city);
                    ClientAdmin.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");

                parent.showMainDisplayCities();

            }
        });

        but2 = new JButton("Come back");
        but2.setBounds(300,350,100,20);
        add(but2);
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayCities();
            }
        });
    }

    public void SelectEdit(ArrayList<Cities> cities){
        if(ClientAdmin.cities!=null){
            for(int i =0;i<cities.size();i++){
                Cityes[i] = cities.get(i);
            }
            comboBox.setModel(new DefaultComboBoxModel(Cityes));
        }
    }
    }

