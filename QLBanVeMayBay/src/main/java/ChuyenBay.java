
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalQueries;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Arrays;
import java.util.Random;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nguyen Quoc Huy
 */
public class ChuyenBay {

    private static final String chuyenBayFILE = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\chuyenBay.txt";
    private String maChuyenBay;
    private String slChoNgoi;
    private String slKhach;
    private boolean trangThai = true;
    private MayBay mayBay = new MayBay();
    private LichBay lichBay = new LichBay();
    private TuyenBay tuyenBay = new TuyenBay();
    private SanBay sanBay = new SanBay();
    private HangMayBay hangMayBay = new HangMayBay();
    private LoTrinh loTrinh = new LoTrinh();
    private VeChuyenBay veChuyenBay = new VeChuyenBay();
    private PhieuDatVe phieuDatVe = new PhieuDatVe();
    private HoaDon hoaDon = new HoaDon();
    private HangVe hangVe = new HangVe();
    private ConNguoi conNguoi = new ConNguoi();
    protected static Scanner sc = new Scanner(System.in);
    private String user;
    private static String[] chuyenBayArr = new String[3];
    private static ChuyenBay[] dsChuyenBay = new ChuyenBay[20];

    public ChuyenBay() {
        slKhach = "0";
    }

    public ChuyenBay(String maChuyenBay, boolean trangThai, String slChoNgoi) {
        this.maChuyenBay = maChuyenBay;
        this.trangThai = trangThai;
        this.slChoNgoi = slChoNgoi;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay() {
        System.out.println("Nhap Ma chuyen bay: ");
        maChuyenBay = sc.nextLine();

    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai() {
        System.out.println("Vui long nhap trang thai: ");
        trangThai = sc.nextBoolean();
    }

    public MayBay getMaBay() {
        return mayBay;
    }

    public void setMayBay() {
        System.out.println("Vui long nhap Thong tin may bay: ");
        mayBay.nhapDuLieuMayBay();
    }

    public LichBay getLichBay() {
        return lichBay;
    }

    public void setLichBay() {
        System.out.println("Vui long nhap Thong tin lich bay: ");
        lichBay.nhapDuLieuLichBay();
    }

    public TuyenBay getTuyenBay() {
        return tuyenBay;
    }

    public void setTuyenBay() {
        System.out.println("Vui long nhap Thong tin tuyen bay: ");
        tuyenBay.nhapDuLieuTuyenBay();
    }

    public SanBay getSanBay() {
        return sanBay;
    }

    public void setSanBay() {
        System.out.println("Vui long nhap Thong tin san bay ");
        sanBay.nhapDuLieuSanBay();
    }

    public HangMayBay getHangMayBay() {
        return hangMayBay;
    }

    public void setHangMayBay() {
        System.out.println("Vui long nhap Thong tin hang may bay: ");
        hangMayBay.nhapDuLieuHangMayBay();
    }

    public LoTrinh getLoTrinh() {
        return loTrinh;
    }

    public void setLoTrinh() {
        System.out.println("Vui long nhap Thong tin lo trinh bay: ");
        loTrinh.nhapDuLieuLoTrinh();
    }

    public VeChuyenBay getVeChuyenBay() {
        return veChuyenBay;
    }

    public void setVeChuyenBay() {
        System.out.println("Vui long nhap Thong tin ve: ");
        veChuyenBay.nhapDuLieuVeMayBay();
    }

    public PhieuDatVe getPhieuDatVe() {
        return phieuDatVe;
    }

    public void setPhieuDatVe() {
        System.out.println("Vui long nhap Thong tin phieu dat ve: ");
        phieuDatVe.nhapDuLieuPhieuDatVe();
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon() {
        this.hoaDon = hoaDon;
    }

    public HangVe getHangVe() {
        return hangVe;
    }

    public void setHangVe() {
        System.out.println("Vui long nhap Thong tin hang ve: ");
        hangVe.nhapDuLieuHangVe();
    }

    public String getSlChoNgoi() {
        return slChoNgoi;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setSlChoNgoi() {
        System.out.println("Nhap so luong cho ngoi: ");
        slChoNgoi = sc.nextLine();
    }

    public String getSlKhach() {
        return slKhach;
    }

    public void setSlKhach(String slKhach) {
        this.slKhach = slKhach;
    }

    public static boolean isSubstringPresent(String string1, String string2) {
        String lowercaseString1 = string1.toLowerCase(); // Chuyển chuỗi thứ nhất về chữ thường
        String lowercaseString2 = string2.toLowerCase(); // Chuyển chuỗi thứ hai về chữ thường

        return lowercaseString2.contains(lowercaseString1);
    }

    public void menuSetChuyenBayUser() throws FileNotFoundException {
        while (true) {
            System.out.println("------MENU Dat ve------");

            System.out.println("Chon 1: Mua ve");
            System.out.println("Chon 0: Thoat");
            System.out.print("Moi ban chon: ");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    setChuyenBayUser();
                    break;
                case 0:
                    System.out.println("Da thoat khoi Dat ve.");
                    return;

                default:
                    System.out.println("Tu chon khong hop le. Vui long chon lai.");
            }
        }

    }

    public static String getValueAfterEqualSign(String input) {
        int equalSignIndex = input.indexOf("=");
        if (equalSignIndex != -1 && equalSignIndex < input.length() - 1) {
            return input.substring(equalSignIndex + 1).trim();
        }
        return input;
    }

    public static void readDataFromFile(String filePath) {
        chuyenBayArr = new String[1]; // Kích thước ban đầu của mảng

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                if (index == chuyenBayArr.length) {
                    // Mở rộng mảng khi cần thiết
                    String[] newLines = new String[chuyenBayArr.length * 2];
                    System.arraycopy(chuyenBayArr, 0, newLines, 0, chuyenBayArr.length);
                    chuyenBayArr = newLines;
                }
                chuyenBayArr[index] = line;
                index++;
            }

        } catch (IOException e) {
        }

    }

    public static String generateRandomString(int length) {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static boolean compareDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");

        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDateTime dateTime2 = LocalDateTime.parse(dateString, formatter);

        return dateTime1.isBefore(dateTime2) || dateTime1.isEqual(dateTime2);
    }

    public void setChuyenBayUser() throws FileNotFoundException {
        String thongTinVe = user + ", ";

        readDataFromFile(chuyenBayFILE);
        System.out.println("------Moi nhap thong tin chuyen bay------");

        System.out.println("Nhap san bay cat canh:");
        sc.nextLine();
        String sanbaycatcanh = "tan son nhat";
        System.out.println("Nhap san bay ha canh:");
        String sanbayhacanh = "noi bai";
        System.out.println("Nhap gio cat canh (dd/MM/yyyy HH:mm):");
        String gioCatCanh = "1/1/2023 12:00";
        System.out.println("Nhap gio ha canh (dd/MM/yyyy HH:mm):");
        String gioHaCanh = "1/1/2023 13:00";

        System.out.printf("%-8s %-20s %-10s %-10s%n", "Ma", "Ten hang", "Thuong gia", "Pho thong");
        boolean found = false;
        for (String row : chuyenBayArr) {

            String sanbayCatCanhFile = getValueByKey(row, "sanbaycatcanh");
            String sanbayHaCanhFile = getValueByKey(row, "sanbayhacanh");
            String gioCatCanhFile = getValueByKey(row, "giocatcanh");
            String gioHaCanhFile = getValueByKey(row, "giohacanh");
            String ngayhieulucFile = getValueByKey(row, "ngayhieuluc");
            String slChoNgoiFile = getValueByKey(row, "slChoNgoi");
            String slKhachFile = getValueByKey(row, "slKhach");
            if (sanbaycatcanh.equalsIgnoreCase(sanbayCatCanhFile)
                    && sanbayhacanh.equalsIgnoreCase(sanbayHaCanhFile)
                    && gioCatCanh.equalsIgnoreCase(gioCatCanhFile)
                    && gioHaCanh.equalsIgnoreCase(gioHaCanhFile)) {
                found = true;
                String maFile = getValueByKey(row, "maChuyenBay");
                String tenHang = getValueByKey(row, "tenhang");
                String thuongGia = getValueByKey(row, "thuongGia");
                String phoThong = getValueByKey(row, "phoThong");
                System.out.printf("%-8s %-20s %-10s %-10s%n",
                        maFile, tenHang, thuongGia, phoThong);
            }

        }

        if (found) {
            int slVe = 0;
            System.out.println("Moi ban chon chuyen bay:");
            String ma_chon = sc.nextLine();
            boolean f = false;

            for (String row : chuyenBayArr) {

                String maFile = getValueByKey(row, "maChuyenBay");
                String tenHang = getValueByKey(row, "tenhang");
                String thuongGia = getValueByKey(row, "thuongGia");
                String phoThong = getValueByKey(row, "phoThong");
                String sanbayCatCanhFile = getValueByKey(row, "sanbaycatcanh");
                String sanbayHaCanhFile = getValueByKey(row, "sanbayhacanh");
                if (ma_chon.equalsIgnoreCase(maFile)) {
                    f = true;
                    System.out.println("Moi ban chon loai ve:");
                    String loaiVe = sc.nextLine();
                    System.out.println("Moi ban chon so luong ve:");
                    slVe = sc.nextInt();
                    int length = 6;
                    String maVe = generateRandomString(length);

                    if (isSubstringPresent(loaiVe, phoThong)) {
                        thongTinVe += "San bay cat canh " + sanbayCatCanhFile
                                + ", San bay ha canh " + sanbayHaCanhFile
                                + ", Ma chuyen bay: " + maFile
                                + ", Ten hang: " + tenHang
                                + ", Tong gia tien: " + Integer.parseInt(phoThong) * slVe;
                    } else {
                        thongTinVe += "San bay cat canh " + sanbayCatCanhFile
                                + ", San bay ha canh " + sanbayHaCanhFile
                                + ", Ma chuyen bay: " + maFile
                                + ", Ten hang: " + tenHang
                                + " Tong gia tien: " + Integer.parseInt(thuongGia) * slVe;
                    }
                    ConNguoi[] dsConNguoi = new ConNguoi[slVe];
                    for (int j = 1; j <= slVe; j++) {
                        System.out.println("Moi nhap thong tin khach hang thu " + j + ": ");
                        ConNguoi cn = new ConNguoi();
                        cn.nhapTT();
                        maVe = generateRandomString(length);
                        thongTinVe += ", Thong tin hanh khach thu " + j
                                + ": " + "Ma ve " + maVe
                                + ", Ho ten: " + cn.getHoTen()
                                + ", CCCD: " + cn.getCCCD()
                                + ", Ngay sinh: " + cn.getNgaySinh()
                                + ", So dien thoai: " + cn.getSDT() + "";
                    }
                    if (isSubstringPresent(loaiVe, phoThong)) {

                        System.out.println("Ve cua quy khach:");
                        System.out.println("Ma ve " + maVe + "\n"
                                + "San bay cat canh " + sanbayCatCanhFile);
                        System.out.println("San bay ha canh " + sanbayHaCanhFile);
                        System.out.println("Ma chuyen bay: " + maFile);
                        System.out.println("Ten hang: " + tenHang);
                        System.out.println("Tong gia tien: " + Integer.parseInt(phoThong) * slVe);

                    } else {
                        System.out.println("Ve cua quy khach:");
                        System.out.println("San bay cat canh " + sanbayCatCanhFile);
                        System.out.println("San bay ha canh " + sanbayHaCanhFile);
                        System.out.println("Ma chuyen bay: " + maFile);
                        System.out.println("Ten hang: " + tenHang);
                        System.out.println("Tong gia tien: " + Integer.parseInt(thuongGia) * slVe);

                    }
                    System.out.println("Ve cua quy khach da duoc luu vao co so du lieu!");
                    System.out.println("Quy khach da tro ve trang Dat ve!");
                    String path = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\veChuyenBay.txt";
                    savetoFile(thongTinVe, path);
                    return;
                }
            }
            if (f = false) {
                System.out.println("Khong tim thay Ma chuyen bay!");
            }

            System.out.println(
                    "Quy khach da tro ve trang Dat ve!");

            return;

        } else {
            System.out.println("Chuyen bay quy khach tim khong co!");
            System.out.println("Quy khach da tro ve trang Dat ve!");
            return;
        }
    }

    public static void savetoFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi luu du lieu.");
        }
    }

    public static void deleteFileContent(String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(""); // Ghi một chuỗi rỗng để xóa dữ liệu
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi xoa du lieu " + e.getMessage());
        }
    }

    public static String getValueByKey(String inputString, String key) {
        if (inputString != null) {
            String[] parts = inputString.split(",");

            for (String part : parts) {
                String[] keyValue = part.split("=");

                if (keyValue.length > 1) {
                    String currentKey = keyValue[0].trim();
                    String currentValue = keyValue[1].trim();

                    if (currentKey.equals(key)) {
                        return currentValue;
                    }
                }
            }
        }

        return null; // Trả về null nếu không tìm thấy key trong chuỗi hoặc chuỗi là null
    }

    public void setChuyenBayAdmin() {
        setMaChuyenBay();
        setHangMayBay();
        setSlChoNgoi();
        setLoTrinh();
        setSanBay();
        setMayBay();
        setLichBay();
        setTuyenBay();
        setHangVe();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(chuyenBayFILE, true))) {
            String string = toString();
            writer.write(string);
            writer.newLine();
            System.out.println("Tao chuyen bay thanh cong");
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi luu du lieu.");
        }

    }

    public static String[][] readDataFromFile2Aray(String filePath) throws IOException {
        // Đọc nội dung của tệp tin
        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        // Tách các dòng dữ liệu bằng ký tự xuống dòng "\n"
        String[] lines = content.split("\n");

        // Tạo mảng hai chiều để lưu trữ dữ liệu
        String[][] data = new String[lines.length][];

        // Duyệt qua từng dòng dữ liệu
        for (int i = 0; i < lines.length; i++) {
            // Tách các giá trị trong dòng bằng dấu phẩy ","
            String[] values = lines[i].split(",");

            // Lưu trữ dữ liệu vào mảng hai chiều
            data[i] = values;
        }

        return data;
    }

    public static String getValueAfterEqualSign2Aray(String input) {
        int equalSignIndex = input.indexOf("=");
        if (equalSignIndex != -1 && equalSignIndex < input.length() - 1) {
            return input.substring(equalSignIndex + 1).trim();
        }
        return input;
    }

    public static void dataChuyenBay() {
        try {
            String[][] data = readDataFromFile2Aray(chuyenBayFILE);
            int i = 0;

            for (String[] row : data) {
                if (row.length >= 25) {
                    ChuyenBay cb = new ChuyenBay();
                    cb.maChuyenBay = getValueAfterEqualSign(row[0]);
                    cb.slChoNgoi = getValueAfterEqualSign(row[1]);
                    cb.slKhach = getValueAfterEqualSign(row[2]);
                    cb.hangMayBay = new HangMayBay(getValueAfterEqualSign(row[3]), getValueAfterEqualSign(row[4]));

                    // Check the lengths of remaining elements before accessing them
                    if (row.length >= 25) {
                        cb.loTrinh = new LoTrinh(getValueAfterEqualSign(row[5]), getValueAfterEqualSign(row[6]),
                                getValueAfterEqualSign(row[7]), getValueAfterEqualSign(row[8]));
                        cb.sanBay = new SanBay(getValueAfterEqualSign(row[9]), getValueAfterEqualSign(row[10]),
                                getValueAfterEqualSign(row[11]));
                        cb.mayBay = new MayBay(getValueAfterEqualSign(row[12]), "cho khach", "cho khach");
                        cb.lichBay = new LichBay(getValueAfterEqualSign(row[15]), getValueAfterEqualSign(row[16]),
                                getValueAfterEqualSign(row[17]));
                        cb.tuyenBay = new TuyenBay(getValueAfterEqualSign(row[18]), getValueAfterEqualSign(row[19]),
                                getValueAfterEqualSign(row[20]), getValueAfterEqualSign(row[21]),
                                getValueAfterEqualSign(row[22]));
                        cb.hangVe = new HangVe(Integer.parseInt(getValueAfterEqualSign(row[23])),
                                Integer.parseInt(getValueAfterEqualSign(row[24])));
                    }

                    dsChuyenBay[i] = cb;
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printChuyenBay() {

        System.out.printf("%-10s %-20s %-10s %-10s\n", "Ma",
                "So luong cho ngoi", "Pho thong", "Thuong gia");
        for (ChuyenBay row : dsChuyenBay) {
            if (row != null) {
                String maChuyenBayFile = row.maChuyenBay;
                String slChoNgoiFile = row.slChoNgoi;

                int thuongGiaFile = row.hangVe.getThuongGia();
                int phoThongFile = row.hangVe.getPhoThong();
                if (maChuyenBayFile != null && slChoNgoiFile != null) {
                    System.out.printf("%-10s %-20s %-10s %-10s\n", maChuyenBayFile,
                            slChoNgoiFile, thuongGiaFile, phoThongFile);
                }
            }
        }

    }

    public static void suaThongTinChuyenBay() throws IOException {
        String maSua = "";
        while (true) {
            printChuyenBay();
            System.out.println("----------------------------------");
            System.out.println("Nhap ma chuyen bay de sua (0 de thoat): ");
            maSua = sc.nextLine();
            boolean f = false;

            if (maSua.equals("0")) {
                return;
            }
            for (ChuyenBay cb : dsChuyenBay) {
                if (cb != null && cb.getMaChuyenBay() != null && cb.getMaChuyenBay().equals(maSua)) {
                    f = true;
                    break;
                }
            }
            if (f) {

                // Tạo đối tượng BufferedWriter để ghi vào tệp tạm thời
                // Duyệt qua từng dòng trong tệp chuyenBay.txt
                for (ChuyenBay cb : dsChuyenBay) {

                    // Nếu tìm thấy mã chuyến bay cần sửa
                    if (cb != null && cb.getMaChuyenBay() != null && cb.getMaChuyenBay().equals(maSua)) {
                        System.out.println("Ban muon sua thong tin nao?");
                        System.out.println("1. So luong cho ngoi");
                        System.out.println("2. Gia pho thong");
                        System.out.println("3. Gia thuong gia");
                        System.out.println("0. Thoat");

                        // Đọc lựa chọn của người dùng
                        int choice = sc.nextInt();
                        sc.nextLine(); // Đọc ký tự xuống dòng sau khi đọc số nguyên

                        // Thực hiện thay đổi thông tin tương ứng với lựa chọn
                        switch (choice) {
                            case 1 -> {
                                System.out.print("Nhap so luong cho ngoi moi: ");
                                String slChoNgoi = sc.nextLine();
                                cb.slChoNgoi = slChoNgoi;
                            }

                            case 2 -> {
                                System.out.print("Nhap gia pho thong moi: ");
                                String giaPhoThong = sc.nextLine();
                                cb.hangVe.setPhoThong(Integer.parseInt(giaPhoThong));
                            }

                            case 3 -> {
                                System.out.print("Nhap gia thuong gia moi: ");
                                String giaThuongGia = sc.nextLine();
                                cb.hangVe.setThuongGia(Integer.parseInt(giaThuongGia));
                            }

                            case 0 -> {
                                // Thoát khỏi vòng lặp và không ghi lại dòng này
                                System.out.println("Da huy sua thong tin chuyen bay.");
                                return;
                            }

                            default -> {
                                System.out.println("Lua chon khong hop le. Vui long chon lai!");
                                continue;
                            }
                        }
                    }
                }
                deleteFileContent(chuyenBayFILE);
                String s = "";
                for (ChuyenBay cb : dsChuyenBay) {
                    if (cb != null) {
                        s += cb.toString() + "\n";
                    }
                }
                savetoFile(s, chuyenBayFILE);
                System.out.println("Da sua thanh cong!");
            } else {
                System.out.println("Khong tim thay ma chuyen bay!");
            }
        }
    }

    public static void xoaThongTinChuyenBay() {
        while (true) {
            String maXoa = "";
            printChuyenBay();
            System.out.println("----------------------------------");
            System.out.println("Nhap ma chuyen bay de xoa (0 de thoat): ");
            maXoa = sc.nextLine();
            boolean f = false;

            if (maXoa.equals("0")) {
                return;
            }
            for (ChuyenBay cb : dsChuyenBay) {
                if (cb != null && cb.getMaChuyenBay() != null && cb.getMaChuyenBay().equals(maXoa)) {
                    f = true;
                    break;
                }
            }
            if (f) {

                int index = -1;
                for (int i = 0; i < dsChuyenBay.length; i++) {
                    if (dsChuyenBay[i] != null && dsChuyenBay[i].getMaChuyenBay().equals(maXoa)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    ChuyenBay chuyenBayCanXoa = dsChuyenBay[index];

                    if (chuyenBayCanXoa.getSlKhach().equals("0")) {
                        dsChuyenBay[index] = null;
                        System.out.println("Da xoa thong tin chuyen bay thanh cong.");
                    } else {
                        System.out.println("Khong the xoa chuyen bay da co khach dat ve.");
                    }
                }
            } else {
                System.out.println("Khong tim thay chuyen bay!");
            }
        }
    }

    @Override
    public String toString() {
        return "maChuyenBay=" + maChuyenBay
                + "," + "slChoNgoi=" + slChoNgoi
                + "," + "slKhach=" + Integer.parseInt(slKhach)
                + ", " + hangMayBay.toString()
                + "," + loTrinh.toString()
                + ", " + sanBay.toString()
                + ", " + mayBay.toString()
                + ", " + lichBay.toString() + ", "
                + tuyenBay.toString() + ", " + hangVe.toString();

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        dataChuyenBay();
//        ChuyenBay cbAdmin = new ChuyenBay();
//        cbAdmin.setChuyenBayAdmin();
//        ChuyenBay cbUser = new ChuyenBay();
//        cbUser.menuSetChuyenBayUser();
//        suaThongTinChuyenBay();
//        printChuyenBay();
        xoaThongTinChuyenBay();
    }

}
