import java.io.FileNotFoundException;
import java.io.IOException;

public interface DangKyVaDangNhapInterface {

    void  dangKy() throws IOException;
    boolean tenDangNhapCoTonTai(String username) throws IOException;
    void dangNhap() throws IOException;
    void layLaiMatKhau() throws FileNotFoundException;
    String findPassword(String username, String securityQuestion) throws FileNotFoundException;
    void thayDoiMatKhau() throws IOException;
    boolean kiemTraMatKhau(String username, String password) throws FileNotFoundException;
    boolean changePassword(String username, String currentPassword, String newPassword) throws IOException;
    
}