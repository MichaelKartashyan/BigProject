import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class MainFrameCashier extends JFrame implements Serializable  {
    MainDisplayCashier mainDisplayCashier;
    AddDisplayCashier addDisplayCashier;
    ListDisplayCashier listDisplayCashier;
    EditDisplayCashier editDisplayCashier;
    DeleteDisplayCashier deleteDisplayCashier;

    public MainFrameCashier() {
        setSize(500,500);
        setLayout(null);
        setTitle("Приложение кассира");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainDisplayCashier = new MainDisplayCashier(this);
        mainDisplayCashier.setVisible(true);
        add(mainDisplayCashier);

        addDisplayCashier = new AddDisplayCashier(this);
        addDisplayCashier.setVisible(false);
        add(addDisplayCashier);

        listDisplayCashier = new ListDisplayCashier(this);
        listDisplayCashier.setVisible(false);
        add(listDisplayCashier);

        editDisplayCashier = new EditDisplayCashier(this);
        editDisplayCashier.setVisible(false);
        add(editDisplayCashier);

        deleteDisplayCashier = new DeleteDisplayCashier(this);
        deleteDisplayCashier.setVisible(false);
        add(deleteDisplayCashier);

    }
    public void showMainDisplayCashier(){
        addDisplayCashier.setVisible(false);
        editDisplayCashier.setVisible(false);
        listDisplayCashier.setVisible(false);
        deleteDisplayCashier.setVisible(false);
        mainDisplayCashier.setVisible(true);
    }
    public void showAddDisplayCashier(){
        mainDisplayCashier.setVisible(false);
        editDisplayCashier.setVisible(false);
        listDisplayCashier.setVisible(false);
        deleteDisplayCashier.setVisible(false);
        addDisplayCashier.setVisible(true);
    }
    public void showListDisplayCashier(){
        mainDisplayCashier.setVisible(false);
        editDisplayCashier.setVisible(false);
        addDisplayCashier.setVisible(false);
        deleteDisplayCashier.setVisible(false);
        listDisplayCashier.setVisible(true);
    }
    public void showEditDisplayCashier(){
        mainDisplayCashier.setVisible(false);
        addDisplayCashier.setVisible(false);
        listDisplayCashier.setVisible(false);
        deleteDisplayCashier.setVisible(false);
        editDisplayCashier.setVisible(true);
    }
    public void showDeleteDisplayCashier(){
        mainDisplayCashier.setVisible(false);
        addDisplayCashier.setVisible(false);
        listDisplayCashier.setVisible(false);
        editDisplayCashier.setVisible(false);
        deleteDisplayCashier.setVisible(true);

    }
}
