
import java.sql.Time;

public class FlightInstance implements FlightStatus// chuyen bay
{

    private int code;// ma chuyen bay
    private Time departureTime; // gio khoi hanh
    private Time arrivalTime;// gio den
    private String gate; // cong
    private Flight flight;//thông tin về máy bay
    private int numberOfTickets; // tổng số lượng vé
    private int numberOfTicketsRemaining; //số lượng vé còn lại

    FlightInstance() {

    }

    public FlightInstance(int code, Time departureTime, Time arrivalTime, String gate, Flight flight,
            int numberOfTickets, int numberOfTicketsRemaining) {
        this.code = code;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.gate = gate;
        this.flight = flight;
        this.numberOfTickets = numberOfTickets;
        this.numberOfTicketsRemaining = numberOfTicketsRemaining;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getNumberOfTicketsRemaining() {
        return numberOfTicketsRemaining;
    }

    public void setNumberOfTicketsRemaining(int numberOfTicketsRemaining) {
        this.numberOfTicketsRemaining = numberOfTicketsRemaining;
    }

    public boolean Active() {
        return false;
    }

    public boolean cancel() {
        // logic hủy chuyến bay
        return false;
        // logic hủy chuyến bay
    }

    public String Scheduled() {
        return "";
    } // du kien

    public boolean Delayed() {
        return false;
    }



    public boolean Departed() {
        return false;
    } // có cất cánh chưa?

    public boolean Landed() {
        return false;
    } // có hạ cánh chưa?

    public boolean InAir() {
        return false;
    }

    @Override
    public boolean Arrived() {
        return false;
    } //có đến chưa?

    public boolean Canceled() {
        return false;
    }// bị hủy?

    public boolean Diveried() {
        return false;
    }// bị hủy?

}
