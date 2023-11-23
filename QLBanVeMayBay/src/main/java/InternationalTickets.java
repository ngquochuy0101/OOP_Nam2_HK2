/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Quoc Huy
 */
public class InternationalTickets extends Ticket {
    private String quocGiaDen;
    private int maPassport;

    public InternationalTickets() {
    }

    public InternationalTickets(String quocGiaDen, int maPassport) {
        this.quocGiaDen = quocGiaDen;
        this.maPassport = maPassport;
    }

    public String getQuocGiaDen() {
        return quocGiaDen;
    }

    public void setQuocGiaDen(String quocGiaDen) {
        this.quocGiaDen = quocGiaDen;
    }

    public int getMaPassport() {
        return maPassport;
    }

    public void setMaPassport(int maPassport) {
        this.maPassport = maPassport;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
}
