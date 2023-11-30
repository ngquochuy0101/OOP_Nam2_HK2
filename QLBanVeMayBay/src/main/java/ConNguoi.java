import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class ConNguoi {

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner aSc) {
        sc = aSc;
    }
    private String hoTen;
    private String CCCD;
    private String ngaySinh;
    private String SDT;
    private static Scanner sc = new Scanner(System.in);
    
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

    private String kiemTraNgaySinh(String ngaySinh) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(ngaySinh);
            return outputFormat.format(date);
        } 
        catch (ParseException e) {
            System.out.println("Ngay sinh khong hop le, vui long su dung dinh dang dd/MM/yyyy.");
            return null;
        }
    }
    
    
    public void nhapTT() {
        System.out.println("Nhap ho ten: ");
        setHoTen(sc.nextLine());
        System.out.println("Nhap so CCCD: ");
        setCCCD(sc.nextLine());
        System.out.println("Nhap ngay sinh (dd/mm/yyyy): ");
        setNgaySinh(sc.nextLine());
        String check = kiemTraNgaySinh(getNgaySinh());

        if (check!= null) {
            setNgaySinh(check);
        }

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
