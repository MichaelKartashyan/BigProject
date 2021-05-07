import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class DeleteDisplayCashier extends JPanel implements Serializable {
    MainFrameCashier parent;
    private PackageData pd;
    private Tickets ticket;

    private Tickets[] ticketss= new Tickets[20];
    private JComboBox comboBox;

    private JButton del;
    private JButton back;

    public DeleteDisplayCashier( MainFrameCashier parent) {
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

                Tickets ticketsDel = (Tickets) comboBox.getSelectedItem();
                try{
                    pd = new PackageData("DeleteTicket", ticketsDel);
                    ClientCashier.outputStream.writeObject(pd);

                }catch (Exception ex){ex.printStackTrace();}
                parent.showMainDisplayCashier();
            }
        });

        back = new JButton("Come back");
        back.setBounds(300,150,100,20);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplayCashier();
            }
        });
    }

    public void SelectDelete(ArrayList<Tickets> tickets){
        if(ClientCashier.tickets!=null){
            for(int i =0;i<tickets.size();i++){
                ticketss[i] = tickets.get(i);
            }
            comboBox.setModel(new DefaultComboBoxModel(ticketss));

        }
    }
}
