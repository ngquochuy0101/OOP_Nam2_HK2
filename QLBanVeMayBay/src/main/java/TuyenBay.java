    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class TuyenBay {

    private static final int MAX_TUYENBAY = 100; // Số lượng tối đa của tuyến bay
    private static TuyenBay[] danhSachTuyenBay = new TuyenBay[MAX_TUYENBAY]; // Mảng động chứa thông tin tuyến bay
    private static int soLuongTuyenBay = 0; // Số lượng tuyến bay hiện tại trong danh sách

    private String matuyenbay;
    private String masanbaycatcanh;
    private String sanbayhacanh;
    private String sanbaycatcanh;
    private String giocatcanh;
    private String giohacanh;

   
     public TuyenBay(String matuyenbay, String sanbaycatcanh, String sanbayhacanh, String giocatcanh, String giohacanh) {
        this.matuyenbay = matuyenbay;
        this.sanbaycatcanh = sanbaycatcanh;
        this.sanbayhacanh = sanbayhacanh;
        this.giocatcanh = giocatcanh;
        this.giohacanh = giohacanh;
    }

    public TuyenBay() {
        // Constructor rỗng để sử dụng khi nhập dữ liệu từ bàn phím
    }

    public String getMaTuyenBay() {
        return matuyenbay;
    }

    public void setMaTuyenBay(String matuyenbay) {
        this.matuyenbay = matuyenbay;
    }

    public String getSanbaycatcanh() {
        return sanbaycatcanh;
    }

    public void setSanbaycatcanh(String sanbaycatcanh) {
        this.sanbaycatcanh = sanbaycatcanh;
    }

    public String getMaSanBayCatCanh() {
        return masanbaycatcanh;
    }

    public void setMaSanBayCatCanh(String masanbaycatcanh) {
        this.masanbaycatcanh = masanbaycatcanh;
    }

    public String getSanBayHaCanh() {
        return sanbayhacanh;
    }

    public void setSanBayHaCanh(String sanbayhacanh) {
        this.sanbayhacanh = sanbayhacanh;
    }

    public String getGioCatCanh() {
        return giocatcanh;
    }

    public void setGioCatCanh(String giocatcanh) {
        this.giocatcanh = giocatcanh;
    }

    public String getGioHaCanh() {
        return giohacanh;
    }

    public void setGioHaCanh(String giohacanh) {
        this.giohacanh = giohacanh;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhapDuLieuTuyenBay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma tuyen bay:");
        this.matuyenbay = scanner.nextLine();
        System.out.println("Nhap ma san bay cat canh:");
        this.sanbaycatcanh = scanner.nextLine();
        System.out.println("Nhap san bay ha canh:");
        this.sanbayhacanh = scanner.nextLine();
        System.out.println("Nhap gio cat canh (dd/MM/yyyy HH:mm):");
        this.giocatcanh = scanner.nextLine();
        System.out.println("Nhap gio ha canh (dd/MM/yyyy HH:mm):");
        this.giohacanh = scanner.nextLine();

    }

    @Override
    public String toString() {
        return "matuyenbay=" + matuyenbay + ", sanbaycatcanh=" + sanbaycatcanh
                + ", sanbayhacanh=" + sanbayhacanh + ", giocatcanh="
                + giocatcanh + ", giohacanh=" + giohacanh;
    }

    // Phương thức xuất dữ liệu ra màn hình
    public void xuatDuLieu() {
        System.out.println(toString());
    }

    // Phương thức lưu dữ liệu vào file
    public void luuDuLieuVaoFile(String tenFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenFile, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            writer.printf("%s,%s,%s,%s,%s%n", matuyenbay, masanbaycatcanh, sanbayhacanh, dateFormat.format(giocatcanh), dateFormat.format(giohacanh));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức đọc dữ liệu từ file vào mảng động
    public static void docDuLieuTuFile(String tenFile) {
        try (Scanner scanner = new Scanner(new File(tenFile))) {
            while (scanner.hasNextLine() && soLuongTuyenBay < MAX_TUYENBAY) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 5) {
                    TuyenBay tuyenBay = new TuyenBay(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    danhSachTuyenBay[soLuongTuyenBay++] = tuyenBay;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Phương thức cập nhật thông tin tuyến bay trong mảng động
    public static void capNhatThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma tuyen bay can cap nhat:");
        String maTuyenBay = scanner.nextLine();

        for (int i = 0; i < soLuongTuyenBay; i++) {
            if (danhSachTuyenBay[i].getMaTuyenBay().equals(maTuyenBay)) {
                System.out.println("Nhap ma san bay ha canh moi:");
                danhSachTuyenBay[i].setSanBayHaCanh(scanner.nextLine());
                System.out.println("Nhap gio cat canh moi (dd/MM/yyyy HH:mm):");
                String gioCatCanhStr = scanner.nextLine();
                System.out.println("Nhap gio ha canh moi (dd/MM/yyyy HH:mm):");
                String gioHaCanhStr = scanner.nextLine();

                danhSachTuyenBay[i].xuatDuLieu();
                break;
            }
        }
    }

    // Phương thức xóa thông tin tuyến bay từ mảng động
    public static void xoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma tuyen bay can xoa:");
        String maTuyenBay = scanner.nextLine();

        for (int i = 0; i < soLuongTuyenBay; i++) {
            if (danhSachTuyenBay[i].getMaTuyenBay().equals(maTuyenBay)) {
                for (int j = i; j < soLuongTuyenBay - 1; j++) {
                    danhSachTuyenBay[j] = danhSachTuyenBay[j + 1];
                }
                soLuongTuyenBay--;
                break;
            }
        }
        System.out.println("Danh sach tuyen bay sau khi xoa");
        hienThiDanhSachTuyenBay();
    }

    // Phương thức thêm thông tin tuyến bay vào mảng động
    public static void themTuyenBay() {
        if (soLuongTuyenBay < MAX_TUYENBAY) {
            TuyenBay tuyenBayMoi = new TuyenBay();
            tuyenBayMoi.nhapDuLieuTuyenBay();
            danhSachTuyenBay[soLuongTuyenBay++] = tuyenBayMoi;
            System.out.println("Danh sach tuyen bay sau khi them");
            hienThiDanhSachTuyenBay();
        } else {
            System.out.println("Danh sach tuyen bay da day. Khong the them tuyen bay moi.");
        }
    }

    // Hiển thị danh sách tuyến bay
    public static void hienThiDanhSachTuyenBay() {
        System.out.printf("| %-12s | %-18s | %-15s | %-21s | %-21s |%n", "matuyenbay", "masanbaycatcanh", "sanbayhacanh", "giocatcanh", "giohacanh");
        System.out.println("|--------------|------------------|-----------------|-----------------|-----------------|");
        for (int i = 0; i < soLuongTuyenBay; i++) {
            danhSachTuyenBay[i].xuatDuLieu();
        }
    }

    public static void main(String[] args) {
        docDuLieuTuFile("TuyenBay.txt");

        // Hiển thị danh sách tuyến bay
        hienThiDanhSachTuyenBay();

        // Thêm một tuyến bay mới
        themTuyenBay();

        // Hiển thị danh sách sau khi thêm
        System.out.println("\nDanh sach sau khi them:");
        hienThiDanhSachTuyenBay();

        // Cập nhật thông tin một tuyến bay
        capNhatThongTin();
        System.out.println("\nDanh sach sau khi cap nhat:");
        hienThiDanhSachTuyenBay();

        // Xóa một tuyến bay
        xoaThongTin();
    }
}
