package Do_An_OOP_Nam2_HK2.QLBanVeMayBay.src.main.java.person;
import java.util.*;

class ConNguoi {
    private String hoTen;
    private String CCCD;
    private String ngaySinh;
    private String SDT;
    static Scanner sc = new Scanner(System.in);
    
    public ConNguoi() {
        
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }
    
    public String getCCCD() {
        return CCCD;
    }
    
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getNgaySinh() {
        return ngaySinh;
    }
    
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    public String getSDT() {
        return SDT;
    }
    
    public void nhapTT() {
        System.out.println("Nhap ho ten: ");
        setHoTen(sc.nextLine());
        System.out.println("Nhap so CCCD: ");
        setCCCD(sc.nextLine());
        System.out.println("Nhap ngay sinh (dd/mm/yy): ");
        setNgaySinh(sc.nextLine());
        System.out.println("Nhap so dien thoai: ");
        setSDT(sc.nextLine());
    }
    
    public void xuatTT() {
        System.out.println("Ho ten: " + getHoTen());
        System.out.println("CCCD: " + getCCCD());
        System.out.println("Ngay sinh: " + getNgaySinh());
        System.out.println("So dien thoai: " + getSDT());
    }
}
