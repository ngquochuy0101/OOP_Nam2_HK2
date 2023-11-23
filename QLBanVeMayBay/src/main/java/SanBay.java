/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.Scanner;

public class SanBay {
    private static final int MAX_SANBAY = 100; // Số lượng tối đa của sân bay
    private static SanBay[] danhSachSanBay = new SanBay[MAX_SANBAY]; // Mảng động chứa thông tin sân bay
    private static int soLuongSanBay = 0; // Số lượng sân bay hiện tại trong danh sách

    private String masanbay;
    private String tensanbay;
    private String tenthanhpho;

    public SanBay(String masanbay, String tensanbay, String tenthanhpho) {
        this.masanbay = masanbay;
        this.tensanbay = tensanbay;
        this.tenthanhpho = tenthanhpho;
    }

    public SanBay() {
        // Constructor rỗng để sử dụng khi nhập dữ liệu từ bàn phím
    }

    public String getMaSanBay() {
        return masanbay;
    }

    public void setMaSanBay(String masanbay) {
        this.masanbay = masanbay;
    }

    public String getTenSanBay() {
        return tensanbay;
    }

    public void setTenSanBay(String tensanbay) {
        this.tensanbay = tensanbay;
    }

    public String getTenThanhPho() {
        return tenthanhpho;
    }

    public void setTenThanhPho(String tenthanhpho) {
        this.tenthanhpho = tenthanhpho;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhapDuLieuSanBay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sân bay:");
        this.masanbay = scanner.nextLine();
        System.out.println("Nhập tên sân bay:");
        this.tensanbay = scanner.nextLine();
        System.out.println("Nhập tên thành phố:");
        this.tenthanhpho = scanner.nextLine();
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-15s | %-15s |", masanbay, tensanbay, tenthanhpho);
    }

    // Phương thức xuất dữ liệu ra màn hình
    public void xuatDuLieu() {
        System.out.println(toString());
    }

    // Phương thức lưu dữ liệu vào file
    public void luuDuLieuVaoFile(String tenFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenFile, true))) {
            writer.printf("%s,%s,%s%n", masanbay, tensanbay, tenthanhpho);
        } catch (IOException e) {
        }
    }

    // Phương thức đọc dữ liệu từ file vào mảng động
    public static void docDuLieuTuFile(String tenFile) {
        try (Scanner scanner = new Scanner(new File(tenFile))) {
            while (scanner.hasNextLine() && soLuongSanBay < MAX_SANBAY) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 3) {
                    SanBay sanBay = new SanBay(parts[0], parts[1], parts[2]);
                    danhSachSanBay[soLuongSanBay++] = sanBay;
                }
            }
        } catch (FileNotFoundException e) {
        }
    }

    // Phương thức cập nhật thông tin sân bay trong mảng động
    public static void capNhatThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sân bay cần cập nhật:");
        String maSanBay = scanner.nextLine();

        for (int i = 0; i < soLuongSanBay; i++) {
            if (danhSachSanBay[i].getMaSanBay().equals(maSanBay)) {
                System.out.println("Nhập tên sân bay mới:");
                danhSachSanBay[i].setTenSanBay(scanner.nextLine());
                System.out.println("Nhập tên thành phố mới:");
                danhSachSanBay[i].setTenThanhPho(scanner.nextLine());
                break;
            }
        }
        // Hiển thị danh sách sau khi cập nhập
        System.out.println("\nDanh sách sau khi cập nhật :");
        hienThiDanhSachSanBay();
    }

    // Phương thức xóa thông tin sân bay từ mảng động
    public static void xoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sân bay cần xóa:");
        String maSanBay = scanner.nextLine();

        for (int i = 0; i < soLuongSanBay; i++) {
            if (danhSachSanBay[i].getMaSanBay().equals(maSanBay)) {
                for (int j = i; j < soLuongSanBay - 1; j++) {
                    danhSachSanBay[j] = danhSachSanBay[j + 1];
                }
                soLuongSanBay--;
                break;
            }
        }

        // Hiển thị danh sách sân bay sau khi xóa
        System.out.println("\nDanh sách sau khi xóa:");
        hienThiDanhSachSanBay();
    }

    // Hiển thị danh sách sân bay
    public static void hienThiDanhSachSanBay() {
        System.out.printf("| %-12s | %-15s | %-15s |%n", "masanbay", "tensanbay", "tenthanhpho");
        System.out.println("|--------------|-----------------|-----------------|");
        for (int i = 0; i < soLuongSanBay; i++) {
            danhSachSanBay[i].xuatDuLieu();
        }
    }

    // Phương thức thêm thông tin sân bay vào mảng động
    public static void themSanBay() {
        if (soLuongSanBay < MAX_SANBAY) {
            SanBay sanBayMoi = new SanBay();
            sanBayMoi.nhapDuLieuSanBay();
            danhSachSanBay[soLuongSanBay++] = sanBayMoi;
            
        } else {
            System.out.println("Danh sách sân bay đã đầy. Không thể thêm sân bay");
        }
        // Hiển thị danh sách sau khi thêm
        System.out.println("\nDanh sách sau khi thêm:");
        hienThiDanhSachSanBay();
    }

    public static void main(String[] args) {
        docDuLieuTuFile("SanBay.txt");
    }
}


