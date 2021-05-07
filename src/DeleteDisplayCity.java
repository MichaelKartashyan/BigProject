import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;


public class DeleteDisplayCity extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private PackageData pd;
    private Cities city;

    private Cities[] Cities= new Cities[20];
    private JComboBox comboBox;

    private JButton del;
    private JButton back;

    public DeleteDisplayCity(MainFrameAdmin parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);


        comboBox = new JComboBox();
        comboBox.setBounds(30,1,400,20);
        add(comboBox);

        del = new JButton("Delete");
        del.setBounds(200,150,100,20);
        add(del);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Cities citiesDel = (Cities) comboBox.getSelectedItem();
                try{
                    pd = new PackageData("DeleteCity", citiesDel);
                    ClientAdmin.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}
                parent.showMainDisplayCities();
            }
        });

        back = new JButton("Come back");
        back.setBounds(300,150,100,20);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayCities();
            }
        });

    }
    public void SelectDelete(ArrayList<Cities> cities){
        if(ClientAdmin.cities!=null){
            for(int i =0;i<cities.size();i++){
                Cities[i] = cities.get(i);
            }
            comboBox.setModel(new DefaultComboBoxModel(Cities));

        }
    }
}
