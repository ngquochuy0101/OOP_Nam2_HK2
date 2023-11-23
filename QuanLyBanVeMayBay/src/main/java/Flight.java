
import java.util.List;

public class Flight {

    private String flightNumber;
    private Airport departure; // san bay cat canh
    private Airport arrival;// san bay khoi hanh
    private int durationInMinutes;// thoi gia di chuyen
    private Ticket ticket;
    private Airline airline;

    Flight() {
    }
    // bo sung getset

    public Flight(String flightNumber, Airline airline, Airport departure, Airport arrival, int durationInMinutes, Ticket ticket) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.durationInMinutes = durationInMinutes;
        this.ticket = ticket;
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public FlightInstance[] getInstances() {
        // Trả về danh sách các chuyến bay cụ thể
        return null;
        // Trả về danh sách các chuyến bay cụ thể
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    

    public boolean cancel() {
        // Hủy chuyến bay
        return false;
        // Hủy chuyến bay
    }

    public boolean addFlightSchedule() {
        // Thêm lịch trình cho chuyến bay
        return false;
        // Thêm lịch trình cho chuyến bay
    }

}
