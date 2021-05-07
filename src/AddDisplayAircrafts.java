import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;


public class AddDisplayAircrafts extends JPanel implements Serializable {
    private MainFrameAdmin parent;

    PackageData pd;
    Aircrafts aircrafts;
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



    public AddDisplayAircrafts(MainFrameAdmin parent) {
        this.parent = parent;


        setSize(500,500);
        setLayout(null);

        lbl1 = new JLabel("Aircrafts name ");
        lbl1.setBounds(200,100,100,20);
        add(lbl1);

        textField1 = new JTextField();
        textField1.setBounds(300,100,100,20);
        add(textField1);

        lbl2 = new JLabel("Aircrafts model ");
        lbl2.setBounds(200,150,100,20);
        add(lbl2);

        textField2 = new JTextField();
        textField2.setBounds(300,150,100,20);
        add(textField2);

        lbl3 = new JLabel("Aircrafts business class capacity ");
        lbl3.setBounds(200,200,100,20);
        add(lbl3);

        textField3 = new JTextField();
        textField3.setBounds(300,200,100,20);
        add(textField3);

        lbl4 = new JLabel("Aircrafts econom class capacity ");
        lbl4.setBounds(200,250,100,20);
        add(lbl4);

        textField4 = new JTextField();
        textField4.setBounds(300,250,100,20);
        add(textField4);


        but1 = new JButton("Add Aircrafts");
        but1.setBounds(200,350,100,20);
        add(but1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String model = textField2.getText();
                int economCap = Integer.parseInt(textField3.getText());
                int businessCap = Integer.parseInt(textField4.getText());


                aircrafts = new Aircrafts(null,name,model, economCap,businessCap);
                try{
                    pd = new PackageData("AddAircraft", aircrafts);
                    ClientAdmin.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");

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
}
