
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Quoc Huy
 */
public class Bill {
   private int maHoaDon, soLuongVe,tongTien;
   private Date ngayLapHoaDon;

    public Bill(int maHoaDon, int soLuongVe, int tongTien, Date ngayLapHoaDon) {
        this.maHoaDon = maHoaDon;
        this.soLuongVe = soLuongVe;
        this.tongTien = tongTien;
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public Bill() {
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }
   
}
