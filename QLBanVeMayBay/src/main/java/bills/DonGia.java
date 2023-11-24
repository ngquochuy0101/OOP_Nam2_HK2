package Do_An_OOP_Nam2_HK2.QLBanVeMayBay.src.main.java.bills;
import java.util.Scanner;

class DonGia {
    public static Scanner sc = new Scanner(System.in);
    private double VND;
    private double USD;
    private double gia;

    public DonGia() {
        
    }
    
    public DonGia(double VND, double USD) {
        this.VND = VND;
        this.USD = USD;
    }
    
    public double getUSD() {
        return VND;
    }
    
    public void setUSD(double USD) {
        this.USD = USD;
    }
    
    public double getVND() {
        return VND;
    }
    
    public void setVND(double VND) {
        this.VND = VND;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    public void addDonGia() {
        System.out.println("Nhap gia: ");
        setGia(sc.nextDouble());
        System.out.println("Chon don vi (1 = VND hoac 2 = USD): ");
        int choose = sc.nextInt();
        switch(choose) {
            case 1: {
                USD = getGia()/24200;
                VND = getGia();
                break;
            }
            case 2: {
                VND = getGia()*24.2;
                USD = getGia();
                break;
            }
        }
    }
    
    public String getDonGia() {
        return "Gia: " + VND + " VND | " + (float)USD + " USD.";
    }
}