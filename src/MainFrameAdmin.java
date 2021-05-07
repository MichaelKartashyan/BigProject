import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class MainFrameAdmin extends JFrame implements Serializable {
    JButton selectCities;
    JButton selectAircrafts;
    JButton selectFlights;
    JButton exit;

    MainDisplayCities mainDisplayCities;
    AddDisplayCity addDisplayCity;
    ListDisplayCity listDisplayCity;
    EditDisplayCity editDisplayCity;
    DeleteDisplayCity deleteDisplayCity;

    MainDisplayAircrafts mainDisplayAircrafts;
    AddDisplayAircrafts addDisplayAircrafts;
    ListDisplayAircrafts listDisplayAircrafts;
    EditDisplayAircrafts editDisplayAircrafts;
    DeleteDisplayAircrafts deleteDisplayAircrafts;

    MainDisplayFlights mainDisplayFlights;
    AddDisplayFlights addDisplayFlights;
    ListDisplayFlights listDisplayFlights;
    EditDisplayFlights editDisplayFlights;
    DeleteDisplayFlights deleteDisplayFlights;

    public MainFrameAdmin(){
        setSize(500,500);
        setLayout(null);
        setTitle("Приложение кассира");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        selectCities = new JButton("Select Cities");
        selectCities.setBounds(200,100,100,50);
        add(selectCities);
        selectCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainDisplayCities();
                selectCities.setVisible(false);
                selectAircrafts.setVisible(false);
                selectFlights.setVisible(false);
            }
        });
        selectAircrafts = new JButton("Select Aircrafts");
        selectAircrafts.setBounds(200,200,100,50);
        add(selectAircrafts);
        selectAircrafts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainDisplayAircrafts();
                selectCities.setVisible(false);
                selectAircrafts.setVisible(false);
                selectFlights.setVisible(false);
            }
        });
        selectFlights = new JButton("Select Flights");
        selectFlights.setBounds(200,300,100,50);
        add(selectFlights);
        selectFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectCities.setVisible(false);
                selectAircrafts.setVisible(false);
                selectFlights.setVisible(false);
                showMainDisplayFlights();
            }
        });

        exit = new JButton("Exit");
        exit.setBounds(200,400,100,50);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




        mainDisplayCities = new MainDisplayCities(this);
        mainDisplayCities.setVisible(false);
        add(mainDisplayCities);

        addDisplayCity = new AddDisplayCity(this);
        addDisplayCity.setVisible(false);
        add(addDisplayCity);

        listDisplayCity = new ListDisplayCity(this);
        listDisplayCity.setVisible(false);
        add(listDisplayCity);

        editDisplayCity = new EditDisplayCity(this);
        editDisplayCity.setVisible(false);
        add(editDisplayCity);

        deleteDisplayCity = new DeleteDisplayCity(this);
        deleteDisplayCity.setVisible(false);
        add(deleteDisplayCity);

        mainDisplayAircrafts = new MainDisplayAircrafts(this);
        mainDisplayAircrafts.setVisible(false);
        add(mainDisplayAircrafts);

        addDisplayAircrafts = new AddDisplayAircrafts(this);
        addDisplayAircrafts.setVisible(false);
        add(addDisplayAircrafts);

        listDisplayAircrafts = new ListDisplayAircrafts(this);
        listDisplayAircrafts.setVisible(false);
        add(listDisplayAircrafts);

        editDisplayAircrafts = new EditDisplayAircrafts(this);
        editDisplayAircrafts.setVisible(false);
        add(editDisplayAircrafts);

        deleteDisplayAircrafts = new DeleteDisplayAircrafts(this);
        deleteDisplayAircrafts.setVisible(false);
        add(deleteDisplayAircrafts);

        mainDisplayFlights = new MainDisplayFlights(this);
        mainDisplayFlights.setVisible(false);
        add(mainDisplayFlights);

        addDisplayFlights = new AddDisplayFlights(this);
        addDisplayFlights.setVisible(false);
        add(addDisplayFlights);

        listDisplayFlights = new ListDisplayFlights(this);
        listDisplayFlights.setVisible(false);
        add(listDisplayFlights);

        editDisplayFlights = new EditDisplayFlights(this);
        editDisplayFlights.setVisible(false);
        add(editDisplayFlights);

        deleteDisplayFlights = new DeleteDisplayFlights(this);
        deleteDisplayFlights.setVisible(false);
        add(deleteDisplayFlights);


    }
    public void showMainDisplayCities(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);

        deleteDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        deleteDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        addDisplayCity.setVisible(false);
        mainDisplayCities.setVisible(true);
    }
    public void showAddDisplayCities(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        deleteDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(true);
    }
    public void showListDisplayCity(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        deleteDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(true);
    }
    public void showEditDisplayCity(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(true);
    }
    public void showDeleteDisplayCity(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(true);
    }
    public void showMainDisplayAircrafts(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(true);
    }
    public void showAddDisplayAircrafts(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(true);
    }
    public void showListDisplayAircrafts(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(true);
    }
    public void showEditDisplayAircrafts(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(true);
    }
    public void showDeleteDisplayAircrafts(){

        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        deleteDisplayAircrafts.setVisible(true);

    }
    public void showMainDisplayFlights(){


        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        mainDisplayFlights.setVisible(true);
    }
    public void showAddDisplayFlights(){

        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(true);
    }
    public void showListDisplayFlights(){

        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(true);
    }
    public void showEditDisplayFlights(){


        deleteDisplayFlights.setVisible(false);
        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(true);
    }
    public void showDeleteDisplayFlights(){

        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(true);
    }
    public void hideAll(){

        mainDisplayCities.setVisible(false);
        addDisplayCity.setVisible(false);
        listDisplayCity.setVisible(false);
        editDisplayCity.setVisible(false);
        deleteDisplayCity.setVisible(false);
        mainDisplayAircrafts.setVisible(false);
        addDisplayAircrafts.setVisible(false);
        listDisplayAircrafts.setVisible(false);
        editDisplayAircrafts.setVisible(false);
        deleteDisplayAircrafts.setVisible(false);
        mainDisplayFlights.setVisible(false);
        addDisplayFlights.setVisible(false);
        listDisplayFlights.setVisible(false);
        editDisplayFlights.setVisible(false);
        deleteDisplayFlights.setVisible(false);
        selectCities.setVisible(true);
        selectAircrafts.setVisible(true);
        selectFlights.setVisible(true);
    }
}
