/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.Scanner;

public class MayBay {

    private static final int MAX_MAYBAY = 100; // Số lượng tối đa của máy bay
    private static MayBay[] danhSachMayBay = new MayBay[MAX_MAYBAY]; // Mảng động chứa thông tin máy bay
    private static int soLuongMayBay = 0; // Số lượng máy bay hiện tại trong danh sách

    private String mamaybay;
    private String loaimaybay;
    private String mota;

    public MayBay() {
        // Constructor rỗng để sử dụng khi nhập dữ liệu từ bàn phím
    }

    public MayBay(String mamaybay, String loaimaybay, String mota) {
        this.mamaybay = mamaybay;
        this.loaimaybay = loaimaybay;
        this.mota = mota;
    }

    public String getMaMayBay() {
        return mamaybay;
    }

    public void setMaMayBay(String mamaybay) {
        this.mamaybay = mamaybay;
    }

    public String getLoaiMayBay() {
        return loaimaybay;
    }

    public void setLoaiMayBay(String loaimaybay) {
        this.loaimaybay = loaimaybay;
    }

    public String getMoTa() {
        return mota;
    }

    public void setMoTa(String mota) {
        this.mota = mota;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhapDuLieuMayBay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã máy bay:");
        this.mamaybay = scanner.nextLine();
        System.out.println("Nhập loại máy bay:");
        this.loaimaybay = scanner.nextLine();
        System.out.println("Nhập mô tả máy bay:");
        this.mota = scanner.nextLine();
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-15s | %-15s |", mamaybay, loaimaybay, mota);
    }

    // Phương thức xuất dữ liệu ra màn hình
    public void xuatDuLieu() {
        System.out.println(toString());
    }

    // Phương thức lưu dữ liệu vào file
    public void luuDuLieuVaoFile(String tenFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenFile, true))) {
            writer.printf("%s,%s,%s%n", mamaybay, loaimaybay, mota);
        } catch (IOException e) {
        }
    }

    // Phương thức đọc dữ liệu từ file vào mảng động
    public static void docDuLieuTuFile(String tenFile) {
        try (Scanner scanner = new Scanner(new File(tenFile))) {
            while (scanner.hasNextLine() && soLuongMayBay < MAX_MAYBAY) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 3) {
                    MayBay mayBay = new MayBay(parts[0], parts[1], parts[2]);
                    danhSachMayBay[soLuongMayBay++] = mayBay;
                }
            }
        } catch (FileNotFoundException e) {
        }
    }

    // Phương thức cập nhật thông tin máy bay trong mảng động
    public static void capNhatThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã máy bay cần cập nhật:");
        String maMayBay = scanner.nextLine();

        for (int i = 0; i < soLuongMayBay; i++) {
            if (danhSachMayBay[i].getMaMayBay().equals(maMayBay)) {
                System.out.println("Nhập loại máy bay mới:");
                danhSachMayBay[i].setLoaiMayBay(scanner.nextLine());
                System.out.println("Nhập mô tả máy bay mới:");
                danhSachMayBay[i].setMoTa(scanner.nextLine());
                danhSachMayBay[i].xuatDuLieu();
                break;
            }
        }
        hienThiDanhSachMayBay();
    }

    // Phương thức xóa thông tin máy bay từ mảng động
    public static void xoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã máy bay cần xóa:");
        String maMayBay = scanner.nextLine();

        for (int i = 0; i < soLuongMayBay; i++) {
            if (danhSachMayBay[i].getMaMayBay().equals(maMayBay)) {
                for (int j = i; j < soLuongMayBay - 1; j++) {
                    danhSachMayBay[j] = danhSachMayBay[j + 1];
                }
                soLuongMayBay--;
                break;
            }
        }
        System.out.println("Danh Sách Máy Bay Sau Khi Xóa");
        hienThiDanhSachMayBay();
    }

    // Phương thức thêm thông tin máy bay vào mảng động
    public static void themMayBay() {
        if (soLuongMayBay < MAX_MAYBAY) {
            MayBay mayBayMoi = new MayBay();
            mayBayMoi.nhapDuLieuMayBay();
            danhSachMayBay[soLuongMayBay++] = mayBayMoi;
            System.out.println("Danh Sách Máy Bay Sau Khi Thêm");
        } else {
            System.out.println("Danh sách máy bay đã đầy. Không thể thêm máy bay mới.");
        }
        //hiện thị danh sách sau khi thêm mới
        hienThiDanhSachMayBay();
        
    }

    // Hiển thị danh sách máy bay
    public static void hienThiDanhSachMayBay() {
        System.out.printf("| %-12s | %-15s | %-15s |%n", "mamaybay", "loaimaybay", "mota");
        System.out.println("|--------------|------------------|-----------------|");
        for (int i = 0; i < soLuongMayBay; i++) {
            danhSachMayBay[i].xuatDuLieu();
        }
    }

    public static void main(String[] args) {
        docDuLieuTuFile("MayBay.txt");
    }
}

