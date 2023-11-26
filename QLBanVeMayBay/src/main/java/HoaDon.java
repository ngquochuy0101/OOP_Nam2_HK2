
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoaDon {

    public static Scanner sc = new Scanner(System.in);
    public LocalDateTime myDateObj = LocalDateTime.now();
    public DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String ngayLapHoaDon = myDateObj.format(myFormatObj);
    private int maHoaDon;

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

}
