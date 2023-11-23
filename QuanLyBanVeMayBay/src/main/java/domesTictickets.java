/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Quoc Huy
 */
public class DomesTictickets extends Ticket {
    private String tinhThanhDem;

    public DomesTictickets() {
    }

    public DomesTictickets(String tinhThanhDem) {
        this.tinhThanhDem = tinhThanhDem;
    }

    public String getTinhThanhDem() {
        return tinhThanhDem;
    }

    public void setTinhThanhDem(String tinhThanhDem) {
        this.tinhThanhDem = tinhThanhDem;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
}
