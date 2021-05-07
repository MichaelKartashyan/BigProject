import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class AddDisplayCity extends JPanel  implements Serializable {
    MainFrameAdmin parent;
    PackageData pd;
    Cities city;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private JButton but1;
    private JButton but2;

    public AddDisplayCity(MainFrameAdmin parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        lbl1 = new JLabel("City name ");
        lbl1.setBounds(200,100,100,20);
        add(lbl1);

        textField1 = new JTextField();
        textField1.setBounds(300,100,100,20);
        add(textField1);

        lbl2 = new JLabel("Country ");
        lbl2.setBounds(200,150,100,20);
        add(lbl2);

        textField2 = new JTextField();
        textField2.setBounds(300,150,100,20);
        add(textField2);

        lbl3 = new JLabel("City short name ");
        lbl3.setBounds(200,200,100,20);
        add(lbl3);

        textField3 = new JTextField();
        textField3.setBounds(300,200,100,20);
        add(textField3);


        but1 = new JButton("Add City");
        but1.setBounds(200,350,100,20);
        add(but1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String country = textField2.getText();
                String shortName = textField3.getText();

                city = new Cities(null,name,country, shortName);
                try{
                    pd = new PackageData("AddCity", city);
                    ClientAdmin.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");

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
    }

