import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class NhanVien extends ConNguoi {
    private int maNV;
    private Date ngayBatDau;
    private int soNgayLam;
    private int soNgayNghi;
    private int tienThuong;
    

    public NhanVien() {

    }

    public int getMaNV() {
        return maNV;
    }
    
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }
    
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }
    
    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }
    
    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public int getTienThuong() {
        return tienThuong;
    }
    
    public void setTienThuong(int tienThuong) {
        this.tienThuong = tienThuong;
    }
    
    private String checkNgayBatDau(String date) {
        try {
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    setNgayBatDau(inputFormat.parse(date));
                    return outputFormat.format(getNgayBatDau());
                } 
                catch (ParseException e) {
                    System.out.println("Ngay bat dau khong hop le, vui long su dung dinh dang dd/MM/yyyy.");
                    return null;
                }
    }

    public abstract void tinhTienCong();


}

    class PhiCong extends NhanVien {

          @Override
          public void tinhTienCong() {

          }

    }

    class TiepVien extends NhanVien {

          @Override
          public void tinhTienCong() {
            
          }
          
    }