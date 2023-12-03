
import java.io.FileNotFoundException;
import java.io.IOException;

public interface ChuyenBayInterface {

    String getMaChuyenBay();

    void setMaChuyenBay();

    boolean isTrangThai();

    void setTrangThai();

    MayBay getMaBay();

    void setMayBay();

    LichBay getLichBay();

    void setLichBay();

    TuyenBay getTuyenBay();

    void setTuyenBay();

    SanBay getSanBay();

    void setSanBay();

    HangMayBay getHangMayBay();

    void setHangMayBay();

    LoTrinh getLoTrinh();

    void setLoTrinh();

    VeChuyenBay getVeChuyenBay();

    void setVeChuyenBay();

    PhieuDatVe getPhieuDatVe();

    void setPhieuDatVe();

    MayBay getMayBay();

    HoaDon getHoaDon();

    void setHoaDon();

    HangVe getHangVe();

    void setHangVe();

    int getSlChoNgoi();

    String getUser();

    void setUser(String user);

    void setSlChoNgoi();

    int getSlKhach();

    void setSlKhach(int slKhach);

    int getSlPhoThong();

    void setSlPhoThong(int slPhoThong);

    int getSlThuongGia();

    void setSlThuongGia(int slThuongGia);

    boolean isSubstringPresent(String string1, String string2);

    String getValueAfterEqualSign(String input);

    String generateRandomString(int length);

    boolean updateFlightInfo(String flightCodeToEdit, String key, String info) throws FileNotFoundException;

    boolean soSanhThoiGian(String dateTimeString2);

    boolean isALargerThanB(int a, int b);

    void setChuyenBayUser() throws FileNotFoundException;

    void savetoFile(String content, String filePath);

    void deleteFileContent(String filePath);

    String getValueByKey(String inputString, String key);

    void setChuyenBayAdmin();

    public String[][] readDataFromFile2Aray(String filePath) throws IOException;

    String getValueAfterEqualSign2Aray(String input);

    void dataChuyenBay();

    void printChuyenBay();

    void xoaThongTinChuyenBay();

    void QuanLive() throws IOException;
}
