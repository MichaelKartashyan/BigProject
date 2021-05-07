import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ClientHandler extends Thread implements Serializable {
    private Socket socket;
    private static Connection connection;


    public ClientHandler(Socket socket) {
        this.socket = socket;

    }

    public void run() {
        try {
            connect();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data = null;
            while ((data = (PackageData) inputStream.readObject()) != null) {
                System.out.println(data);
                if (data.getOperationType().equals("GetAllFlights")) {
                    PackageData response = new PackageData();
                    ArrayList<Flights> flights = new ArrayList<>();
                    flights = getAllFlights();
                    response.setFlights(flights);
                    outputStream.writeObject(response);

                } else if (data.getOperationType().equals("AddTicket")) {
                    addTickets(data.getCashier());

                } else if (data.getOperationType().equals("LIST_Tickets")) {
                    PackageData response = new PackageData();
                    ArrayList<Tickets> tickets = new ArrayList<>();
                    tickets = getAllTickets();
                    response.setTickets(tickets);
                    outputStream.writeObject(response);

                } else if (data.getOperationType().equals("EditTicket")) {
                    EditTickets(data.getCashier());

                } else if (data.getOperationType().equals("DeleteTicket")) {
                    DeleteTickets(data.getCashier());

                } else if (data.getOperationType().equals("AddCity")) {
                    addCity(data.getCity());

                } else if (data.getOperationType().equals("LISTCities")) {
                    PackageData response = new PackageData();
                    ArrayList<Cities> cities = new ArrayList<>();
                    cities = getAllCityes();
                    response.setCities(cities);
                    outputStream.writeObject(response);

                } else if (data.getOperationType().equals("EditCity")) {
                    EditCity(data.getCity());

                } else if (data.getOperationType().equals("DeleteCity")) {
                    DeleteCity(data.getCity());

                } else if (data.getOperationType().equals("AddAircraft")) {
                    addAircraft(data.getAircraft());

                } else if (data.getOperationType().equals("LISTAircrafts")) {

                    PackageData response = new PackageData();
                    ArrayList<Aircrafts> aircrafts = new ArrayList<>();
                    aircrafts = getAllAircrafts();
                    response.setAircrafts(aircrafts);
                    outputStream.writeObject(response);
                } else if (data.getOperationType().equals("EditAircraft")) {
                    EditAircraft(data.getAircraft());
                } else if (data.getOperationType().equals("DeleteAircraft")) {
                    DeleteAircraft(data.getAircraft());

                } else if (data.getOperationType().equals("AddFlight")) {
                    addFlight(data.getFlight());
                } else if (data.getOperationType().equals("LISTFlights")) {
                    PackageData response = new PackageData();
                    ArrayList<Flights> flights = new ArrayList<>();
                    flights = getAllFlights();
                    response.setFlights(flights);
                    outputStream.writeObject(response);
                } else if (data.getOperationType().equals("EditFlights")) {
                    EditFlights(data.getFlight());
                }else if(data.getOperationType().equals("DeleteFlights")){
                    DeleteFlights(data.getFlight());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean connect() {
        boolean check = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/bproject", "root", "");
            System.out.println("Connected");
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }


    public static void addTickets(Tickets tickets) {
        try {
            PreparedStatement st = connection.prepareStatement("insert into tickets(flight_id,name,surname,passport_number,ticket_type) values(?,?,?,?,?)");
            st.setLong(1, tickets.getFlightId());
            st.setString(2, tickets.getName());
            st.setString(3, tickets.getSurname());
            st.setString(4, tickets.getPassportNumber());
            st.setString(5, tickets.getTicketType());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void EditTickets(Tickets tickets) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE `tickets` SET flight_id=?,name=?,surname=?,passport_number=?,ticket_type=? WHERE id=?");
            st.setLong(6, tickets.getId());
            st.setLong(1, tickets.getFlightId());
            st.setString(2, tickets.getName());
            st.setString(3, tickets.getSurname());
            st.setString(4, tickets.getPassportNumber());
            st.setString(5, tickets.getTicketType());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DeleteTickets(Tickets tickets) {
        try {
            PreparedStatement st = connection.prepareStatement("delete from tickets where id = ?");
            st.setLong(1, tickets.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Tickets> getAllTickets() {
        ArrayList<Tickets> tickets = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM `tickets`");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long flightId = resultSet.getLong("flight_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String passportNumber = resultSet.getString("passport_number");
                String ticketType = resultSet.getString("ticket_type");

                tickets.add(new Tickets(id, flightId, name, surname, passportNumber, ticketType));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }


    //admin city
    public static void addCity(Cities city) {
        try {
            PreparedStatement st = connection.prepareStatement("insert into cities(name,country,short_name) values(?,?,?)");
            st.setString(1, city.getName());
            st.setString(2, city.getCountry());
            st.setString(3, city.getShortName());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cities> getAllCityes() {
        ArrayList<Cities> cities = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM `cities`");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                String shortName = resultSet.getString("short_name");

                cities.add(new Cities(id, name, country, shortName));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void EditCity(Cities city) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE `cities` SET name=?,country=?,short_name=? WHERE id=?");
            st.setLong(4, city.getId());
            st.setString(1, city.getName());
            st.setString(2, city.getCountry());
            st.setString(3, city.getShortName());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DeleteCity(Cities city) {
        try {
            PreparedStatement st = connection.prepareStatement("delete from cities where id = ?");
            st.setLong(1, city.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Aircraft

    public static void addAircraft(Aircrafts aircraft) {
        try {
            PreparedStatement st = connection.prepareStatement("insert into aircrafts(name,model,business_class_capacity,econom_class_capacity) values(?,?,?,?)");
            st.setString(1, aircraft.getName());
            st.setString(2, aircraft.getModel());
            st.setInt(3, aircraft.getBusiness_class_capacity());
            st.setInt(4, aircraft.getEconom_class_capacity());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Aircrafts> getAllAircrafts() {
        ArrayList<Aircrafts> aircrafts = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM `aircrafts`");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                int business_class_capacity = resultSet.getInt("business_class_capacity");
                int econom_class_capacity = resultSet.getInt("econom_class_capacity");


                aircrafts.add(new Aircrafts(id, name, model, business_class_capacity, econom_class_capacity));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aircrafts;
    }

    public static void EditAircraft(Aircrafts aircrafts) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE `aircrafts` SET name=?,model=?,business_class_capacity=?,econom_class_capacity=? WHERE id=?");
            st.setLong(5, aircrafts.getId());
            st.setString(1, aircrafts.getName());
            st.setString(2, aircrafts.getModel());
            st.setInt(3, aircrafts.getBusiness_class_capacity());
            st.setInt(4, aircrafts.getEconom_class_capacity());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DeleteAircraft(Aircrafts aircrafts) {
        try {
            PreparedStatement st = connection.prepareStatement("delete from aircrafts where id = ?");
            st.setLong(1, aircrafts.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Flights


    public static void addFlight(Flights flights) {
        try {
            PreparedStatement st = connection.prepareStatement("insert into flights(description,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) values(?,?,?,?,?,?,?)");
            st.setString(1, flights.getDescription());
            st.setLong(2, flights.getAircraftId());
            st.setLong(3, flights.getDeparture_cityId());
            st.setLong(4, flights.getArrival_cityId());
            st.setString(5, flights.getDepartureTime());
            st.setInt(6, flights.getEconomPlacePrice());
            st.setInt(7, flights.getBusinessPlacePrice());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Flights> getAllFlights() {
        ArrayList<Flights> flights = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM `flights`");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                Long aircraftId = resultSet.getLong("aircraft_id");
                Long departure_cityId = resultSet.getLong("departure_city_id");
                Long arrival_cityId = resultSet.getLong("arrival_city_id");
                String departureTime = resultSet.getString("departure_time");
                int economPlacePrice = resultSet.getInt("econom_place_price");
                int businessPlacePrice = resultSet.getInt("business_place_price");
                flights.add(new Flights(id, description, aircraftId, departure_cityId, arrival_cityId, departureTime, economPlacePrice, businessPlacePrice));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    public static void EditFlights(Flights flights) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE `flights` SET description=?,aircraft_id=?,departure_city_id=?,arrival_city_id=?,departure_time=?,econom_place_price=?,business_place_price=? WHERE id=?");
            st.setLong(8, flights.getId());
            st.setString(1, flights.getDescription());
            st.setLong(2, flights.getAircraftId());
            st.setLong(3, flights.getDeparture_cityId());
            st.setLong(4, flights.getArrival_cityId());
            st.setString(5, flights.getDepartureTime());
            st.setInt(6, flights.getEconomPlacePrice());
            st.setInt(7, flights.getBusinessPlacePrice());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void DeleteFlights(Flights flights) {
        try {
            PreparedStatement st = connection.prepareStatement("delete from flights where id = ?");
            st.setLong(1, flights.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}