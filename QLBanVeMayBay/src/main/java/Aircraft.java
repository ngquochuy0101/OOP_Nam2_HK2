/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Quoc Huy
 */
public class Aircraft {

    private String name; // ten may bay
    private String modal; // ten may bay
    private int manufacturingYear; // nam san xuat
    private Airline airline;
  
    public Aircraft(String name, String modal, int manufacturingYear, Airline airline) {
        this.name = name;
        this.modal = modal;
        this.manufacturingYear = manufacturingYear;
        this.airline = airline;
    }
    

    public Aircraft() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

}
