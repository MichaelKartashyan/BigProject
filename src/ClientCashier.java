import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCashier implements Serializable {
    public Tickets ticket;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static ArrayList<Tickets> tickets;
    public static ArrayList<Flights> flights;

    public static void main(String[] args) {
        if(Connect()){
            MainFrameCashier frame = new MainFrameCashier();
            frame.setVisible(true);
            try{
            PackageData pd = new PackageData("LIST_Tickets");
            ClientCashier.outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                    tickets = pd.getTickets();
            }
        }catch (Exception ex){ex.printStackTrace();}
        }else {
            System.out.println("Не удалось подключиться");
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
            PackageData pd = new PackageData("LIST_Tickets");
            outputStream.writeObject(pd);
        }catch (Exception ex){ex.printStackTrace();}
    }


    public static void takeFlights(){
        try{
            PackageData pd = new PackageData("LISTFlights");
            outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                flights = pd.getFlights();
            }
        }catch (Exception ex){ex.printStackTrace();}
    }


    public static ArrayList<Tickets> takeTickets(){
        ArrayList<Tickets> tickets = new ArrayList<>();
        PackageData data = null;
        try{
            if ((data = (PackageData) inputStream.readObject()) != null) {
                tickets = data.getTickets();
            }
        }catch (Exception e){e.printStackTrace();}

        return tickets;
    }
}
