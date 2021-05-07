import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    Tickets ticket;
    ArrayList<Tickets> tickets;

    ArrayList<Aircrafts> aircrafts;
    Aircrafts aircraft;
    ArrayList<Cities> cities;
    Cities city;
    ArrayList<Flights>flights ;
    Flights flight;

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public PackageData() {
    }

    public PackageData(String operationType, Flights flight) {
        this.operationType = operationType;
        this.flight = flight;
    }

    public PackageData(String operationType, Aircrafts aircraft) {
        this.operationType = operationType;
        this.aircraft = aircraft;
    }

    public PackageData(String operationType, Tickets tickets) {
        this.operationType = operationType;
        this.ticket = tickets;
    }

    public PackageData(String operationType, Cities city) {
        this.operationType = operationType;
        this.city = city;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
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

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public ArrayList<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Tickets> tickets) {
        this.tickets = tickets;
    }

    public Tickets getCashier() {
        return ticket;
    }

    public void setCashier(Tickets tickets) {
        this.ticket = tickets;
    }

    public String getOperationType() {
        return operationType;
    }

    public PackageData(String operationType, ArrayList<Flights> flights) {
        this.operationType = operationType;
        this.flights = flights;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Flights> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return operationType;
    }
}
