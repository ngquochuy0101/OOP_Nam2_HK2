
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

    public ConNguoi(String hoTen, String CCCD, String ngaySinh, String SDT) {
        this.hoTen = hoTen;
        this.CCCD = CCCD;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
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

    public String kiemTraNgaySinh(String ngaySinh) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(ngaySinh);
            return outputFormat.format(date);
        } catch (ParseException e) {
            return null;
        }
    }
    
    public void nhapTT() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Nhap ho ten: ");
            String hoTen = sc.nextLine();

            if (hoTen.matches("[a-zA-Z ]+")&&hoTen.length()>=8) {
                setHoTen(hoTen);
                break;
            } else {
                System.out.println("Ho ten chi duoc phep nhap chu cai va so ky tu phai lon hon 8. Vui long nhap lai.");
            }
        }

        while (true) {
            System.out.println("Nhap so CCCD: ");
            String cccd = sc.nextLine();

            if (cccd.matches("\\d{12}")) {
                setCCCD(cccd);
                break;
            } else {
                System.out.println("So CCCD phai co 12 chu so. Vui long nhap lai.");
            }
        }

        while (true) {
            System.out.println("Nhap ngay sinh (dd/mm/yyyy): ");
            String ngaySinh = sc.nextLine();
            String check = kiemTraNgaySinh(ngaySinh);

            if (check != null) {
                setNgaySinh(check);
                break;
            } else {
                System.out.println("Ngay sinh khong hop le. Vui long nhap lai theo dinh dang dd/mm/yyyy.");
            }
        }

        while (true) {
            System.out.println("Nhap so dien thoai: ");
            String sdt = sc.nextLine();

            if (sdt.matches("0\\d{9}")) {
                setSDT(sdt);
                break;
            } else {
                System.out.println("So dien thoai phai bat dau bang so 0 va co 10 chu so. Vui long nhap lai.");
            }
        }
    }

    public void xuatTT() {
        System.out.println("Ho ten: " + getHoTen());
        System.out.println("CCCD: " + getCCCD());
        System.out.println("Ngay sinh: " + getNgaySinh());
        System.out.println("So dien thoai: " + getSDT());
    }
    public static void main(String[] args) {
        ConNguoi cn=new ConNguoi();
        cn.nhapTT();
        cn.xuatTT();
    }
}
