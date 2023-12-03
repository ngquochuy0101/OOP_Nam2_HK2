
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class ChuyenBay implements ChuyenBayInterface {

    private static final String chuyenBayFILE = "chuyenBay.txt";
    private String maChuyenBay;
    private int slChoNgoi;
    private int slKhach;
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
    private int slPhoThong;
    private int slThuongGia;
    private ConNguoi conNguoi = new ConNguoi();
    protected static Scanner sc = new Scanner(System.in);
    private String user;
    private ChuyenBay[] dsChuyenBay = new ChuyenBay[20];
    private QuanLiVe qlv = new QuanLiVe();
    private ThongKe tk = new ThongKe();

    public ChuyenBay() {
        trangThai = true;
    }

    public ChuyenBay(String maChuyenBay, boolean trangThai, int slChoNgoi) {
        this.maChuyenBay = maChuyenBay;
        this.trangThai = trangThai;
        this.slChoNgoi = slChoNgoi;
    }

    @Override
    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    @Override

    public void setMaChuyenBay() {
        System.out.println("Nhap Ma chuyen bay: ");
        maChuyenBay = sc.nextLine();

    }

    @Override
    public boolean isTrangThai() {
        return trangThai;
    }

    @Override
    public void setTrangThai() {
        System.out.println("Vui long nhap trang thai: ");
        trangThai = sc.nextBoolean();
    }

    public MayBay getMaBay() {
        return mayBay;
    }

    @Override
    public void setMayBay() {
        System.out.println("Vui long nhap Thong tin may bay: ");
        mayBay.nhapDuLieuMayBay();
    }

    @Override
    public LichBay getLichBay() {
        return lichBay;
    }

    @Override
    public void setLichBay() {
        System.out.println("Vui long nhap Thong tin lich bay: ");
        lichBay.nhapDuLieuLichBay();
    }

    @Override
    public TuyenBay getTuyenBay() {
        return tuyenBay;
    }

    /**
     *
     */
    @Override
    public void setTuyenBay() {
        System.out.println("Vui long nhap Thong tin tuyen bay: ");
        tuyenBay.nhapDuLieuTuyenBay();
    }

    @Override
    public SanBay getSanBay() {
        return sanBay;
    }

    @Override
    public void setSanBay() {
        System.out.println("Vui long nhap Thong tin san bay ");
        sanBay.nhapDuLieuSanBay();
    }

    @Override

    public HangMayBay getHangMayBay() {
        return hangMayBay;
    }

    @Override

    public void setHangMayBay() {
        System.out.println("Vui long nhap Thong tin hang may bay: ");
        hangMayBay.nhapDuLieuHangMayBay();
    }

    @Override
    public LoTrinh getLoTrinh() {
        return loTrinh;
    }

    @Override
    public void setLoTrinh() {
        System.out.println("Vui long nhap Thong tin lo trinh bay: ");
        loTrinh.nhapDuLieuLoTrinh();
    }

    public VeChuyenBay getVeChuyenBay() {
        return veChuyenBay;
    }

    @Override
    public void setVeChuyenBay() {
        System.out.println("Vui long nhap Thong tin ve: ");
        veChuyenBay.nhapDuLieuVeMayBay();
    }

    @Override
    public PhieuDatVe getPhieuDatVe() {
        return phieuDatVe;
    }

    @Override
    public void setPhieuDatVe() {
        System.out.println("Vui long nhap Thong tin phieu dat ve: ");
        phieuDatVe.nhapDuLieuPhieuDatVe();
    }

    @Override
    public MayBay getMayBay() {
        return mayBay;
    }

    @Override

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    @Override
    public void setHoaDon() {
        this.hoaDon = hoaDon;
    }

    @Override
    public HangVe getHangVe() {
        return hangVe;
    }

    @Override
    public void setHangVe() {
        System.out.println("Vui long nhap Thong tin hang ve: ");
        hangVe.nhapDuLieuHangVe();
    }

    @Override

    public int getSlChoNgoi() {
        return slChoNgoi;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void setSlChoNgoi() {
        System.out.println("Nhap so luong cho ngoi: ");
        slChoNgoi = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public int getSlKhach() {
        return slKhach;
    }

    public void setSlKhach(int slKhach) {
        this.slKhach = slKhach;
    }

    @Override

    public int getSlPhoThong() {
        return slPhoThong;
    }

    @Override
    public void setSlPhoThong(int slPhoThong) {
        this.slPhoThong = slPhoThong;
    }

    @Override

    public int getSlThuongGia() {
        return slThuongGia;
    }

    @Override
    public void setSlThuongGia(int slThuongGia) {
        this.slThuongGia = slThuongGia;
    }

    @Override

    public boolean isSubstringPresent(String string1, String string2) {
        String lowercaseString1 = string1.toLowerCase(); // Chuyển chuỗi thứ nhất về chữ thường
        String lowercaseString2 = string2.toLowerCase(); // Chuyển chuỗi thứ hai về chữ thường

        return lowercaseString2.contains(lowercaseString1);
    }

    @Override
    public String getValueAfterEqualSign(String input) {
        int equalSignIndex = input.indexOf("=");
        if (equalSignIndex != -1 && equalSignIndex < input.length() - 1) {
            return input.substring(equalSignIndex + 1).trim();
        }
        return input;
    }

    @Override
    public String generateRandomString(int length) {
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

    @Override
    //chinh sua sl khach da dat ve
    public boolean updateFlightInfo(String flightCodeToEdit, String key, String info) {
        try {
            File file = new File(chuyenBayFILE);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String[] lines = new String[(int) file.length()];
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lines[lineNumber] = line;
                lineNumber++;
            }

            int lineToEdit = -1;
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].startsWith("maChuyenBay=" + flightCodeToEdit)) {
                    lineToEdit = i;
                    break;
                }
            }

            if (lineToEdit != -1) {
                String lineToEditStr = lines[lineToEdit];
                String[] parts = lineToEditStr.split(",");
                parts[2] = key + info;
                String updatedLine = String.join(",", parts);

                lines[lineToEdit] = updatedLine;

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (String updatedLineToWrite : lines) {
                    writer.write(updatedLineToWrite);
                    writer.newLine();
                }
                writer.close();

                return true;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
// so sanh thoi gian hien tai voi thoi gian het hieu luc trong file    
    public boolean soSanhThoiGian(String dateTimeString2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDateTime dateTime2 = LocalDateTime.parse(dateTimeString2, formatter);

        return dateTime1.compareTo(dateTime2) < 0;
    }

    @Override
    public boolean isALargerThanB(int a, int b) {
        return a > b;
    }

    @Override
    public void setChuyenBayUser() throws FileNotFoundException {

        System.out.println("------Moi nhap thong tin chuyen bay------");
        System.out.println("Nhap san bay cat canh:");
        sc.nextLine();
        String sanbaycatcanh = "Tan Son Nhat";
        System.out.println("Nhap san bay ha canh:");
        String sanbayhacanh = "Noi Bai";

        System.out.printf("%-8s %-20s %-10s %-10s %-20s %-20s %n", "Ma", "Ten hang", "Pho thong",
                "Thuong gia", "Thoi gian cat canh", "Thoi gian ha canh");
        boolean found = false;
        for (ChuyenBay cb : dsChuyenBay) {
            if (cb != null) {
//
//                System.out.println("-- -- -- -- --");
////                System.out.println(cb.tuyenBay.getSanbaycatcanh());
////                System.out.println(cb.tuyenBay.getSanBayHaCanh());   
//                System.out.println(cb.tuyenBay.getSanBayHaCanh().equals(sanbayhacanh));
//                System.out.println(cb.tuyenBay.getSanbaycatcanh().equals(sanbaycatcanh));
//
//                System.out.println(soSanhThoiGian(cb.lichBay.getNgayHetHieuLuc()));
//                System.out.println(!isALargerThanB(Integer.parseInt(cb.slKhach), Integer.parseInt(cb.slChoNgoi)));
//
//                System.out.println(cb.slChoNgoi);
//                System.out.println(cb.slKhach);
//                

                if (cb.tuyenBay.getSanBayHaCanh().equalsIgnoreCase(sanbayhacanh)
                        && cb.tuyenBay.getSanbaycatcanh().equalsIgnoreCase(sanbaycatcanh)
                        && !isALargerThanB(cb.slKhach, cb.slChoNgoi)
                        && soSanhThoiGian(cb.lichBay.getNgayHetHieuLuc())
                        && cb.trangThai) {
                    found = true;

                    System.out.printf("%-8s %-20s %-10s %-10s %-20s %-20s %n",
                            cb.maChuyenBay,
                            cb.hangMayBay.getTenHang(),
                            cb.hangVe.getPhoThong(),
                            cb.hangVe.getThuongGia(),
                            cb.tuyenBay.getGioCatCanh(),
                            cb.tuyenBay.getGioHaCanh());
                }

            }
        }

        if (found) {
            int slVe = 0;
            System.out.println("Moi ban chon chuyen bay:");
            String ma_chon = sc.nextLine();
            boolean f = false;
            int slpt = 0;
            int sltg = 0;

            for (ChuyenBay cb : dsChuyenBay) {
                if (cb != null) {
                    if (ma_chon.equalsIgnoreCase(cb.maChuyenBay)) {
                        f = true;
                        System.out.println("Moi ban chon so luong ve:");
                        slVe = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < slVe; i++) {
                            System.out.println("Moi nhap thong tin ve thu " + i + ":");
                            String thongTinVe = "username:" + user + ", ";
                            System.out.println("Moi ban chon loai ve:");
                            String loaiVe = sc.nextLine();
                            int length = 6;
                            String maVe = generateRandomString(length);

                            if (loaiVe.equalsIgnoreCase("Pho thong")) {
                                slpt++;
                                thongTinVe += "Ma ve: " + maVe + ", "
                                        + "San bay cat canh: " + cb.tuyenBay.getSanbaycatcanh()
                                        + ", San bay ha canh: " + cb.tuyenBay.getSanBayHaCanh()
                                        + ", Ma chuyen bay: " + cb.maChuyenBay
                                        + ", Ten hang: " + cb.hangMayBay.getTenHang()
                                        + ", Tong gia tien: " + cb.hangVe.getPhoThong();
                            } else {
                                sltg++;
                                thongTinVe += "Ma ve: " + maVe + ", "
                                        + "San bay cat canh: " + cb.tuyenBay.getSanbaycatcanh()
                                        + ", San bay ha canh: " + cb.tuyenBay.getSanBayHaCanh()
                                        + ", Ma chuyen bay: " + cb.maChuyenBay
                                        + ", Ten hang: " + cb.hangMayBay.getTenHang()
                                        + ", Tong gia tien: " + cb.hangVe.getThuongGia();
                            }
                            System.out.println("Moi nhap thong tin khach hang: ");
                            ConNguoi cn = new ConNguoi();
                            cn.nhapTT();
                            thongTinVe
                                    += ", Ho ten: " + cn.getHoTen()
                                    + ", CCCD: " + cn.getCCCD()
                                    + ", Ngay sinh: " + cn.getNgaySinh()
                                    + ", So dien thoai: " + cn.getSDT() + cb.hangVe.getTrangThai();
                            String path = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\veChuyenBay.txt";
                            savetoFile(thongTinVe, path);

                        }

                        System.out.println("Ve cua quy khach:");
                        System.out.println("San bay cat canh: " + cb.tuyenBay.getSanbaycatcanh());
                        System.out.println("San bay ha canh: " + cb.tuyenBay.getSanBayHaCanh());
                        System.out.println("Ma chuyen bay: " + cb.maChuyenBay);
                        System.out.println("Ten hang: " + cb.hangMayBay.getTenHang());
                        int tong = (cb.hangVe.getPhoThong() * slpt
                                + cb.hangVe.getThuongGia() * sltg);
                        System.out.println("Tong gia tien: " + tong);

                        // Nếu tìm thấy mã chuyến bay cần sửa
                        System.out.println(slpt);
                        System.out.println(sltg);
                        cb.slKhach += slVe;
                        cb.slPhoThong += slpt;
                        cb.slThuongGia += sltg;
                        String s = "";
                        deleteFileContent(chuyenBayFILE);
                        for (ChuyenBay CB : dsChuyenBay) {
                            if (CB != null) {
                                s += CB.toString() + "\n";

                            }
                        }
                        savetoFile(s, chuyenBayFILE);
                        System.out.println("Ve cua quy khach da duoc luu vao co so du lieu!");
                        System.out.println("Quy khach da tro ve trang Dat ve!");
                        return;

                    }
                }
            }

            if (f = false) {
                System.out.println("Khong tim thay Ma chuyen bay!");
            }

            System.out.println("Quy khach da tro ve trang Dat ve!");

            return;

        } else {
            System.out.println("Chuyen bay quy khach tim khong co!");
            System.out.println("Quy khach da tro ve trang Dat ve!");
            return;
        }

    }

    @Override
    public void savetoFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi luu du lieu.");
        }
    }

    @Override
    public void deleteFileContent(String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(""); // Ghi một chuỗi rỗng để xóa dữ liệu
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi xoa du lieu " + e.getMessage());
        }
    }

    @Override
    public String getValueByKey(String inputString, String key) {
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
        sc.nextLine();
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

    @Override
    public String[][] readDataFromFile2Aray(String filePath) throws IOException {
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

    public String getValueAfterEqualSign2Aray(String input) {
        int equalSignIndex = input.indexOf("=");
        if (equalSignIndex != -1 && equalSignIndex < input.length() - 1) {
            return input.substring(equalSignIndex + 1).trim();
        }
        return input;
    }

    @Override
    public void dataChuyenBay() {
        try {
            String[][] data = readDataFromFile2Aray(chuyenBayFILE);
            int i = 0;

            for (String[] row : data) {
                if (row.length >= 25) {
                    ChuyenBay cb = new ChuyenBay();
                    cb.maChuyenBay = getValueAfterEqualSign(row[0]);
                    cb.slChoNgoi = Integer.parseInt(getValueAfterEqualSign(row[1]));
                    cb.slKhach = Integer.parseInt(getValueAfterEqualSign(row[2]));
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
                        cb.slPhoThong = Integer.parseInt(getValueAfterEqualSign(row[25]));
                        cb.slThuongGia = Integer.parseInt(getValueAfterEqualSign(row[26]));
                        cb.trangThai = Boolean.parseBoolean(getValueAfterEqualSign(row[27]));
//                        System.out.println(cb.trangThai);
                    }

                    dsChuyenBay[i] = cb;
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printChuyenBay() {
        dataChuyenBay();

        if (dsChuyenBay == null) {
            System.out.println("Danh sach chuyen bay rong!");
            return;
        }

        System.out.printf("%-10s %-20s %-10s %-10s\n", "Ma",
                "So luong cho ngoi", "Pho thong", "Thuong gia");
        for (ChuyenBay row : dsChuyenBay) {
            if (row != null) {
                if (row.trangThai == true) {
                    String maChuyenBayFile = row.maChuyenBay;
                    int slChoNgoiFile = row.slChoNgoi;

                    int thuongGiaFile = row.hangVe.getThuongGia();
                    int phoThongFile = row.hangVe.getPhoThong();
                    if (maChuyenBayFile != null && slChoNgoiFile != 0) {
                        System.out.printf("%-10s %-20s %-10s %-10s\n", maChuyenBayFile,
                                slChoNgoiFile, thuongGiaFile, phoThongFile);
                    }

                }
            }
        }

    }

    public void suaThongTinChuyenBay() throws IOException {
        dataChuyenBay();

        sc.nextLine();

        if (dsChuyenBay == null) {
            return;
        }
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
                                cb.slChoNgoi = Integer.parseInt(slChoNgoi);
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

    @Override
    public void xoaThongTinChuyenBay() {
        dataChuyenBay();

        sc.nextLine();
        if (dsChuyenBay == null) {
            return;
        }
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

                    if (chuyenBayCanXoa.getSlKhach() == 0) {
                        dsChuyenBay[index].trangThai = false;
                        deleteFileContent(chuyenBayFILE);
                        String s = "";
                        for (ChuyenBay cb : dsChuyenBay) {
                            if (cb != null) {
                                s += cb.toString() + "\n";
                            }
                        }
                        savetoFile(s, chuyenBayFILE);
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
    public void QuanLive() throws IOException {
        sc.nextLine();
        while (true) {
            for (ChuyenBay cb : dsChuyenBay) {

                QuanLiVe.hienthithongtin(user);
            }
//            QuanLiVe.hienthithongtin("huy111");
            System.out.print("Nhap ma ve de huy ve(0 de thoat): ");
            String huyVe = sc.nextLine();
            if (huyVe.equals("0")) {
                return;
            }
            System.out.println("Ban cho chac huy ve khong(F hoac T):");
            if (sc.nextLine().equals("T")) {
                qlv.huyVe(user, huyVe);
            } else {
                System.out.println("Hoan tac huy ve!");
                System.out.println("Da quay lai menu");
                return;
            }

        }

    }

    public void qlThongTinCaNhan() throws IOException {
        ConNguoi cn = new ConNguoi();
        int index = -1;
        String w = "";
        String password = "";
        String[][] users = readDataFromFile2Aray("users.txt");
//        user = "huy111";
        System.out.println(user);
        for (String[] row : users) {
            index++;
            if (user.equals(row[0])) {

                w = row[2];
                password = row[1];
                cn = new ConNguoi(row[3], row[4], row[5], row[6]);
                break;
            }
        }
        while (true) {
            sc.nextLine();

            cn.xuatTT();
            System.out.println("Cau hoi bao mat: " + w);
            System.out.println("Mat khau: " + password);
            System.out.print("Ban co muon thay doi thong tin(T hoac F): ");
            if (sc.nextLine().equals("T")) {
                System.out.println("Moi ban chon thong tin can thay doi:");

                System.out.println("1. Ten");
                System.out.println("2. Ngay sinh");
                System.out.println("3. CCCD");
                System.out.println("4. So dien thoai");
                System.out.println("5. Cau hoi bao mat");
                System.out.println("6. Mat khau");
                System.out.println("0. Thoat");

                System.out.print("Lua chon cua ban: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:

                        while (true) {
                            System.out.println("Nhap ho ten moi: ");
                            String hoTen = sc.nextLine();

                            if (hoTen.matches("[a-zA-Z ]+") && hoTen.length() >= 8) {
                                users[index][3] = hoTen;
                                System.out.println("Thong tin da duoc cap nhat.");
                                break;
                            } else {
                                System.out.println("Ho ten chi duoc phep nhap chu cai va so ky tu phai lon hon 8. Vui long nhap lai.");
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.println("Nhap ngay sinh moi(dd/mm/yyyy): ");
                            String ngaySinh = sc.nextLine();
                            String check = cn.kiemTraNgaySinh(ngaySinh);

                            if (check != null) {
                                users[index][5] = check;
                                System.out.println("Thong tin da duoc cap nhat.");
                                break;
                            } else {
                                System.out.println("Ngay sinh khong hop le. Vui long nhap lai theo dinh dang dd/mm/yyyy.");
                            }
                        }
                    case 3:
                        while (true) {
                            System.out.println("Nhap so CCCD moi: ");
                            String cccd = sc.nextLine();

                            if (cccd.matches("\\d{12}")) {
                                users[index][4] = cccd;
                                System.out.println("Thong tin da duoc cap nhat.");
                                break;
                            } else {
                                System.out.println("So CCCD phai co 12 chu so. Vui long nhap lai.");
                            }
                        }

                    case 4:
                        while (true) {
                            System.out.println("Nhap so dien thoai moi: ");
                            String sdt = sc.nextLine();

                            if (sdt.matches("0\\d{9}")) {
                                users[index][6] = sdt;
                                System.out.println("Thong tin da duoc cap nhat.");
                                break;
                            } else {
                                System.out.println("So dien thoai phai bat dau bang so 0 va co 10 chu so. Vui long nhap lai.");
                            }
                        }

                    case 5:
                        System.out.print("Cau hoi: 'Ban hoc truong nao?' ");
                        System.out.print("Nhap cau tra loi moi: ");
                        while (true) {
                            String cauHoiBaoMat = sc.nextLine();
                            if (cauHoiBaoMat.length() >= 3 && cauHoiBaoMat.matches("^[a-zA-Z\\s]+$")) {
                                w = cauHoiBaoMat;
                                System.out.println("Thong tin da duoc cap nhat.");
                                break;
                            } else {
                                System.out.println("Cau tra loi phai lon hon 3");
                                System.out.println("Cau tra khong duoc chua ky tu dac biet. Vui long nhap lai.");
                                continue;
                            }
                        }
                    case 6:
                        System.out.print("Nhap mat khau moi: ");
                        String newPassword = sc.nextLine();
                        if (newPassword.length() >= 6 && newPassword.length() <= 12) {
                            System.out.print("Nhap lai mat khau: ");
                            String passwordB = sc.nextLine();
                            if (newPassword.equals(passwordB)) {

                                System.out.println("Da thay doi mat khau thanh cong.");
                                break;

                            } else {
                                System.out.println("Mat khau khong khop, vui long nhap lai!");
                                continue;
                            }
                        } else {
                            System.out.println("Mat khau phai lon hon 6 va be hon 12, vui long nhap lai!");
                            continue;
                        }

                    case 0:
                        return; // Thoát khỏi vòng lặp
                    default:
                        System.out.println("Lua chon khong hop le.");
                        break;
                }

            } else {
                break; // Thoát khỏi vòng lặp
            }
            deleteFileContent("users.txt");
            String s = "";
            for (int i = 0; i < users.length; i++) {
                for (int j = 0; j < 7; j++) {
                    if (users[i].length > 3) {
                        s += users[i][j];
                        if (j < 6) {
                            s += ",";
                        }
                    }
                }
                if (users.length - 1 < i) {
                    s += "\n";
                }
            }
            savetoFile(s, "users.txt");
            System.out.println("Da sua thanh cong!");
            break;
        }

    }

    public void menuSetChuyenBayUser() throws FileNotFoundException, IOException {
        dataChuyenBay();

        while (true) {
            System.out.println("------MENU Dat ve------");

            System.out.println("Chon 1: Mua ve");
            System.out.println("Chon 2: Quan ly ve");
            System.out.println("Chon 3: Quan ly thong tin ca nhan");
            System.out.println("Chon 0: Thoat");
            System.out.print("Moi ban chon: ");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    setChuyenBayUser();
                    break;
                case 2:
                    QuanLive();
                    break;
                case 3:
                    qlThongTinCaNhan();
                    break;

                case 0:
                    System.out.println("Da thoat khoi Dat ve.");
                    return;

                default:
                    System.out.println("Tu chon khong hop le. Vui long chon lai.");
            }
        }

    }

    public void menuSetChuyenBayAdmin() throws FileNotFoundException, IOException {
        dataChuyenBay();

        while (true) {
            System.out.println("------MENU------");

            System.out.println("Chon 1: Them chuyen bay");
            System.out.println("Chon 2: Sua chuyen bay");
            System.out.println("Chon 3: Xoa chuyen bay");

            System.out.println("Chon 4: Xem chuyen bay");
            System.out.println("Chon 5: Thong ke doanh thu chuyen bay");

            System.out.print("Moi ban chon: ");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    setChuyenBayAdmin();
                    break;
                case 2:
                    suaThongTinChuyenBay();
                    break;
                case 3:
                    xoaThongTinChuyenBay();
                    break;
                case 4:
                    printChuyenBay();
                    break;
                case 5:
                    tk.thongKe();
                    break;
                case 0:
                    System.out.println("Da thoat khoi Dat ve.");
                    return;

                default:
                    System.out.println("Tu chon khong hop le. Vui long chon lai.");
            }
        }

    }

    @Override
    public String toString() {
        return "maChuyenBay=" + maChuyenBay
                + "," + "slChoNgoi=" + slChoNgoi
                + "," + "slKhach=" + slKhach
                + ", " + hangMayBay.toString()
                + "," + loTrinh.toString()
                + ", " + sanBay.toString()
                + ", " + mayBay.toString()
                + ", " + lichBay.toString() + ", "
                + tuyenBay.toString() + ", " + hangVe.toString() + ", "
                + "slPhoThong=" + slPhoThong + ", "
                + "slThuongGia=" + slThuongGia + ", "
                + "trangThai=" + trangThai;

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        ChuyenBay cbAdmin = new ChuyenBay();
//        cbAdmin.setChuyenBayAdmin();
//        ChuyenBay cbUser = new ChuyenBay();
//        cbUser.menuSetChuyenBayUser();
//        suaThongTinChuyenBay();
//        printChuyenBay();
//        xoaThongTinChuyenBay();
        ChuyenBay cbAdmin = new ChuyenBay();
        cbAdmin.dataChuyenBay();
        cbAdmin.qlThongTinCaNhan();

    }

}
