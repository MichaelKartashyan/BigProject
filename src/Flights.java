import javax.swing.text.Style;
import java.io.Serializable;

public class Flights implements Serializable {
    private Long id ;
    private String description;
    private Long aircraftId;
    private Long departure_cityId;
    private Long arrival_cityId;
    private String departureTime;
    private  int economPlacePrice;
    private int  businessPlacePrice;

    public Flights(Long id, String description, Long aircraftId, Long departure_cityId, Long arrival_cityId, String departureTime, int economPlacePrice, int businessPlacePrice) {
        this.id = id;
        this.description = description;
        this.aircraftId = aircraftId;
        this.departure_cityId = departure_cityId;
        this.arrival_cityId = arrival_cityId;
        this.departureTime = departureTime;
        this.economPlacePrice = economPlacePrice;
        this.businessPlacePrice = businessPlacePrice;
    }

    public Flights() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public Long getDeparture_cityId() {
        return departure_cityId;
    }

    public void setDeparture_cityId(Long departure_cityId) {
        this.departure_cityId = departure_cityId;
    }

    public Long getArrival_cityId() {
        return arrival_cityId;
    }

    public void setArrival_cityId(Long arrival_cityId) {
        this.arrival_cityId = arrival_cityId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getEconomPlacePrice() {
        return economPlacePrice;
    }

    public void setEconomPlacePrice(int economPlacePrice) {
        this.economPlacePrice = economPlacePrice;
    }

    public int getBusinessPlacePrice() {
        return businessPlacePrice;
    }

    public void setBusinessPlacePrice(int businessPlacePrice) {
        this.businessPlacePrice = businessPlacePrice;
    }

    @Override
    public String toString() {
        return id +" Description "+description+", aircraftId=" + aircraftId +
                ", departure_cityId=" + departure_cityId +
                ", arrival_cityId=" + arrival_cityId +
                ", departureTime='" + departureTime + '\'' +
                ", economPlacePrice=" + economPlacePrice +
                ", businessPlacePrice=" + businessPlacePrice +
                '}';
    }
}
