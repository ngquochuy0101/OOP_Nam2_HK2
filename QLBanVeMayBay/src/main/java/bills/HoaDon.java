package Do_An_OOP_Nam2_HK2.QLBanVeMayBay.src.main.java.bills;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class HoaDon {
    public static Scanner sc = new Scanner(System.in);
    public LocalDateTime myDateObj = LocalDateTime.now();
    public DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String ngayLapHoaDon = myDateObj.format(myFormatObj);
    private int maHoaDon;
    DonGia thanhTien = new DonGia();
    public String[][] dsHoaDon = new String[1000][3];
    
    public HoaDon() {
    
    }
    
    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    
    public int getMaHoaDon() {
        return maHoaDon;
    }
    
    public void setNgayLapHoaDon(String ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }
    
    public String getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }
    
    public void taoHoaDon() {
        for (int n = 0; n<1000; n++) {
            if (dsHoaDon[n][0] == null) {
                dsHoaDon[n][0] = String.valueOf(n);
                dsHoaDon[n][1] = getNgayLapHoaDon();
                thanhTien.addDonGia();
                dsHoaDon[n][2] = thanhTien.getDonGia();
                break;
            }
        }
    }
    
    public void getHoaDon() {
        System.out.println("Nhap so hoa don: ");
        setMaHoaDon(sc.nextInt());
        if (dsHoaDon[getMaHoaDon()][0] != null) {
            System.out.println("Ma hoa don: " + String.valueOf(getMaHoaDon()));
            System.out.println("Ngay lap hoa don: " + dsHoaDon[getMaHoaDon()][1]);
            System.out.println("Thanh tien: " + dsHoaDon[getMaHoaDon()][2]);
        } else System.out.println("Hoa don khong ton tai.");
    }
}
