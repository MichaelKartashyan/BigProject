import java.io.Serializable;

public class Tickets implements Serializable {
   private Long id;
    private Long  flightId;
    private String name;
    private  String surname ;
    private String passportNumber;
    private String ticketType;

    public Tickets(Long id, Long flightId, String name, String surname, String passportNumber, String ticketType) {
        this.id = id;
        this.flightId = flightId;
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.ticketType = ticketType;
    }

    public Tickets() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return  id +
                " , flightId=" + flightId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }
}
