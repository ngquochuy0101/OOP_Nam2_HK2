
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private static String[] chuyenBayArr = new String[5];

    public ChuyenBay() {

    }

    public ChuyenBay(String maChuyenBay, boolean trangThai) {
        this.maChuyenBay = maChuyenBay;
        this.trangThai = trangThai;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay() {
        System.out.println("Vui long nhap Ma chuyen bay: ");
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

    public void setChuyenBayUser() throws FileNotFoundException {
        String thongTinVe = "";

        readDataFromFile(chuyenBayFILE);
        System.out.println("------Moi nhap thong tin chuyen bay------");

        System.out.println("Nhap san bay cat canh:");
        sc.nextLine();
        String sanbaycatcanh = sc.nextLine();
        System.out.println("Nhap san bay ha canh:");
        String sanbayhacanh = sc.nextLine();
        System.out.println("Nhap gio cat canh (dd/MM/yyyy HH:mm):");
        String gioCatCanh = sc.nextLine();
        System.out.println("Nhap gio ha canh (dd/MM/yyyy HH:mm):");
        String gioHaCanh = sc.nextLine();

        System.out.printf("%-8s %-20s %-10s %-10s%n", "Ma", "Ten hang", "Thuong gia", "Pho thong");
        boolean found = false;
        for (String row : chuyenBayArr) {

            String sanbayCatCanhFile = getValueByKey(row, "sanbaycatcanh");
            String sanbayHaCanhFile = getValueByKey(row, "sanbayhacanh");
            String gioCatCanhFile = getValueByKey(row, "giocatcanh");
            String gioHaCanhFile = getValueByKey(row, "giohacanh");
//            System.out.println(gioHaCanh);
//            System.out.println(gioHaCanhFile);
//            System.out.println(gioCatCanh);
//            System.out.println(gioCatCanhFile);
//            System.out.println(sanbayhacanh);
//            System.out.println(sanbayHaCanhFile);
//            System.out.println(sanbaycatcanh);
//            System.out.println(sanbayCatCanhFile);

            if ((sanbaycatcanh.equalsIgnoreCase(sanbayCatCanhFile)
                    && sanbayhacanh.equalsIgnoreCase(sanbayHaCanhFile)
                    && gioCatCanh.equalsIgnoreCase(gioCatCanhFile)
                    && gioHaCanh.equalsIgnoreCase(gioHaCanhFile))) {
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

    public void savetoFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi luu du lieu.");
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

    @Override
    public String toString() {
        return "maChuyenBay=" + maChuyenBay + "," + hangMayBay.toString() + "," + loTrinh.toString()
                + "," + sanBay.toString()
                + "," + mayBay.toString()
                + "," + lichBay.toString() + ","
                + tuyenBay.toString() + "," + hangVe.toString();

    }

    public static void main(String[] args) throws FileNotFoundException {
        // ChuyenBay cbAdmin = new ChuyenBay();
        // cbAdmin.setChuyenBayAdmin();

        ChuyenBay cbUser = new ChuyenBay();
        cbUser.menuSetChuyenBayUser();
    }

}
