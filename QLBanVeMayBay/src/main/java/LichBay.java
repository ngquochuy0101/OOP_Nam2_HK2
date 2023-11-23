/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LichBay {

    private static final int MAX_LICHBAY = 100; // Số lượng tối đa của lịch bay
    private static LichBay[] danhSachLichBay = new LichBay[MAX_LICHBAY]; // Mảng động chứa thông tin lịch bay
    private static int soLuongLichBay = 0; // Số lượng lịch bay hiện tại trong danh sách

    private String malichbay;
    private Date ngayhieuluc;
    private Date ngayhethieuluc;

    public LichBay(String malichbay, Date ngayhieuluc, Date ngayhethieuluc) {
        this.malichbay = malichbay;
        this.ngayhieuluc = ngayhieuluc;
        this.ngayhethieuluc = ngayhethieuluc;
    }

    public LichBay() {
        // Constructor rỗng để sử dụng khi nhập dữ liệu từ bàn phím
    }

    public String getMaLichBay() {
        return malichbay;
    }

    public void setMaLichBay(String malichbay) {
        this.malichbay = malichbay;
    }

    public Date getNgayHieuLuc() {
        return ngayhieuluc;
    }

    public void setNgayHieuLuc(Date ngayhieuluc) {
        this.ngayhieuluc = ngayhieuluc;
    }

    public Date getNgayHetHieuLuc() {
        return ngayhethieuluc;
    }

    public void setNgayHetHieuLuc(Date ngayhethieuluc) {
        this.ngayhethieuluc = ngayhethieuluc;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhapDuLieuLichBay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma lich bay:");
        this.malichbay = scanner.nextLine();
        System.out.println("Nhap ngay hieu luc (dd/MM/yyyy HH:mm):");
        String ngayHieuLucStr = scanner.nextLine();
        System.out.println("Nhap ngay het hieu luc (dd/MM/yyyy HH:mm):");
        String ngayHetHieuLucStr = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            this.ngayhieuluc = dateFormat.parse(ngayHieuLucStr);
            this.ngayhethieuluc = dateFormat.parse(ngayHetHieuLucStr);
        } catch (ParseException e) {
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return String.format("| %-12s | %-21s | %-21s |", malichbay, dateFormat.format(ngayhieuluc), dateFormat.format(ngayhethieuluc));
    }

    // Phương thức xuất dữ liệu ra màn hình
    public void xuatDuLieu() {
        System.out.println(toString());
    }

    // Phương thức lưu dữ liệu vào file
    public void luuDuLieuVaoFile(String tenFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenFile, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            writer.printf("%s,%s,%s%n", malichbay, dateFormat.format(ngayhieuluc), dateFormat.format(ngayhethieuluc));
        } catch (IOException e) {
        }
    }

    // Phương thức đọc dữ liệu từ file vào mảng động
    public static void docDuLieuTuFile(String tenFile) {
        try (Scanner scanner = new Scanner(new File(tenFile))) {
            while (scanner.hasNextLine() && soLuongLichBay < MAX_LICHBAY) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 3) {
                    LichBay lichBay = new LichBay(parts[0], new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parts[1]), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parts[2]));
                    danhSachLichBay[soLuongLichBay++] = lichBay;
                }
            }
        } catch (FileNotFoundException | ParseException e) {
        }
    }

    // Phương thức cập nhật thông tin lịch bay trong mảng động
    public static void capNhatThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma lich bay can cap nhat:");
        String maLichBay = scanner.nextLine();

        for (int i = 0; i < soLuongLichBay; i++) {
            if (danhSachLichBay[i].getMaLichBay().equals(maLichBay)) {
                System.out.println("Nhap ngay het hieu luc moi (dd/MM/yyyy HH:mm):");
                String ngayHetHieuLucStr = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                try {
                    danhSachLichBay[i].setNgayHetHieuLuc(dateFormat.parse(ngayHetHieuLucStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        // Hiển thị danh sách sau khi cập nhật
        System.out.println("\nDanh sach sau khi cap nhat:");
        hienThiDanhSachLichBay();
    }

    // Phương thức xóa thông tin lịch bay từ mảng động
    public static void xoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma lich bay can xoa:");
        String maLichBay = scanner.nextLine();

        for (int i = 0; i < soLuongLichBay; i++) {
            if (danhSachLichBay[i].getMaLichBay().equals(maLichBay)) {
                for (int j = i; j < soLuongLichBay - 1; j++) {
                    danhSachLichBay[j] = danhSachLichBay[j + 1];
                }
                soLuongLichBay--;
                break;
            }
        }
        System.out.println("Danh sach lich bay sau khi xoa");
        hienThiDanhSachLichBay();
    }

    // Phương thức thêm thông tin lịch bay vào mảng động
    public static void themLichBay() {
        if (soLuongLichBay < MAX_LICHBAY) {
            LichBay lichBayMoi = new LichBay();
            lichBayMoi.nhapDuLieuLichBay();
            danhSachLichBay[soLuongLichBay++] = lichBayMoi;
        } else {
            System.out.println("Danh sach lich bay da day. Khong the them lich bay moi.");
        }
        // Hiển thị danh sách sau khi thêm
        System.out.println("\nDanh sach sau khi them:");
        hienThiDanhSachLichBay();
    }

    // Hiển thị danh sách lịch bay
    public static void hienThiDanhSachLichBay() {
        System.out.printf("| %-12s | %-21s | %-21s |%n", "malichbay", "ngayhieuluc", "ngayhethieuluc");
        System.out.println("|--------------|----------------------|----------------------|");
        for (int i = 0; i < soLuongLichBay; i++) {
            danhSachLichBay[i].xuatDuLieu();
        }
    }

    public static void main(String[] args) {
        docDuLieuTuFile("LichBay.txt");
    }
}



