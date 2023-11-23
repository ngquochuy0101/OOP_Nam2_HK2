
public interface FlightStatus {

    public boolean Active();

    public String Scheduled(); // du kien

    public boolean Delayed();

    public boolean Departed(); // có cất cánh chưa?

    public boolean Landed(); // có hạ cánh chưa?

    public boolean InAir();

    public boolean Arrived(); //có đến chưa?

    public boolean Canceled();// bị hủy?
    
    public boolean Diveried();// bị hủy?
    

}
