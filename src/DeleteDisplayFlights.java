import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class DeleteDisplayFlights extends JPanel implements Serializable {
    MainFrameAdmin parent;

    private PackageData pd;
    private Aircrafts aircrafts;

    private Flights[] Flights = new Flights[20];
    private JComboBox comboBox;

    private JButton del;
    private JButton back;

    public DeleteDisplayFlights(MainFrameAdmin parent) {
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

                Flights flightsDel = (Flights) comboBox.getSelectedItem();
                try{
                    pd = new PackageData("DeleteFlights", flightsDel);
                    ClientAdmin.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}
                parent.showMainDisplayFlights();
            }
        });

        back = new JButton("Come back");
        back.setBounds(300,150,100,20);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayFlights();
            }
        });
    }


    public void SelectDelete(ArrayList<Flights> flights){
        if(ClientAdmin.aircrafts!=null){
            for(int i =0;i<flights.size();i++){
                Flights[i] = flights.get(i);
            }
            comboBox.setModel(new DefaultComboBoxModel(Flights));

        }
    }
}
