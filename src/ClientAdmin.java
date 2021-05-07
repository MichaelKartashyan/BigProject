import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;


public class ClientAdmin implements Serializable{
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
   public static ArrayList<Aircrafts> aircrafts;
   Aircrafts aircraft;
    public static ArrayList<Cities> cities;
    Cities city;
    public static ArrayList<Flights> flights;
    Flights flight;



    public static void main(String[] args) {
        if(Connect()){
            takeCityess();
            takeAircraftss();
            takeFlightss();
            MainFrameAdmin frame = new MainFrameAdmin();
            frame.setVisible(true);



        }
    }

    public static Boolean Connect(){
        Boolean succsess = false;
        try {
            Socket socket = new Socket("127.0.0.1",1978);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            succsess = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return succsess;
    }
    public static void SendList(){
        try{
            PackageData pd = new PackageData("LISTCities");
            outputStream.writeObject(pd);
        }catch (Exception ex){ex.printStackTrace();}
    }
    public static void takeCityess(){
        try{
            PackageData pd = new PackageData("LISTCities");
            outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                cities = pd.getCities();
            }
        }catch (Exception ex){ex.printStackTrace();}
    }


    public static ArrayList<Cities> takeCityes(){
        ArrayList<Cities> cities = new ArrayList<>();
        PackageData data = null;
        try{
            if ((data = (PackageData) inputStream.readObject()) != null) {
                cities = data.getCities();
            }
        }catch (Exception e){e.printStackTrace();}

        return cities;
    }

    public static void SendListAircrafts(){
        try{
            PackageData pd = new PackageData("LISTAircrafts");
            outputStream.writeObject(pd);
        }catch (Exception ex){ex.printStackTrace();}
    }
    public static void takeAircraftss(){
        try{
            PackageData pd = new PackageData("LISTAircrafts");
            outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                aircrafts = pd.getAircrafts();
            }
        }catch (Exception ex){ex.printStackTrace();}
    }


    public static ArrayList<Aircrafts> takeAircrafts(){
        ArrayList<Aircrafts> aircrafts = new ArrayList<>();
        PackageData data = null;
        try{
            if ((data = (PackageData) inputStream.readObject()) != null) {
                aircrafts = data.getAircrafts();
            }
        }catch (Exception e){e.printStackTrace();}

        return aircrafts;
    }



    //Flights


    public static void SendListFlights(){
        try{
            PackageData pd = new PackageData("LISTFlights");
            outputStream.writeObject(pd);
        }catch (Exception ex){ex.printStackTrace();}
    }
    public static void takeFlightss(){
        try{
            PackageData pd = new PackageData("LISTFlights");
            outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                flights = pd.getFlights();
            }
        }catch (Exception ex){ex.printStackTrace();}
    }


    public static ArrayList<Flights> takeFlights(){
        ArrayList<Flights> flights = new ArrayList<>();
        PackageData data = null;
        try{
            if ((data = (PackageData) inputStream.readObject()) != null) {
                flights = data.getFlights();
            }
        }catch (Exception e){e.printStackTrace();}

        return flights;
    }






    public ArrayList<Aircrafts> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(ArrayList<Aircrafts> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }

    public ArrayList<Cities> getCities() {
        return cities;
    }

    public void setCities(ArrayList<Cities> cities) {
        this.cities = cities;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public ArrayList<Flights> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = flights;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }
}
