/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_do_an;
import java.io.*;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TuyenBay {

    private static final int MAX_TUYENBAY = 100; // Số lượng tối đa của tuyến bay
    private static TuyenBay[] danhSachTuyenBay = new TuyenBay[MAX_TUYENBAY]; // Mảng động chứa thông tin tuyến bay
    private static int soLuongTuyenBay = 0; // Số lượng tuyến bay hiện tại trong danh sách

    private String matuyenbay;
    private String masanbaycatcanh;
    private String sanbayhacanh;
    private Date giocatcanh;
    private Date giohacanh;

    public TuyenBay(String matuyenbay, String masanbaycatcanh, String sanbayhacanh, Date giocatcanh, Date giohacanh) {
        this.matuyenbay = matuyenbay;
        this.masanbaycatcanh = masanbaycatcanh;
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

    public Date getGioCatCanh() {
        return giocatcanh;
    }

    public void setGioCatCanh(Date giocatcanh) {
        this.giocatcanh = giocatcanh;
    }

    public Date getGioHaCanh() {
        return giohacanh;
    }

    public void setGioHaCanh(Date giohacanh) {
        this.giohacanh = giohacanh;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhapDuLieuTuyenBay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã tuyến bay:");
        this.matuyenbay = scanner.nextLine();
        System.out.println("Nhập mã sân bay cất cánh:");
        this.masanbaycatcanh = scanner.nextLine();
        System.out.println("Nhập sân bay hạ cánh:");
        this.sanbayhacanh = scanner.nextLine();
        System.out.println("Nhập giờ cất cánh (dd/MM/yyyy HH:mm):");
        String gioCatCanhStr = scanner.nextLine();
        System.out.println("Nhập giờ hạ cánh (dd/MM/yyyy HH:mm):");
        String gioHaCanhStr = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            this.giocatcanh = dateFormat.parse(gioCatCanhStr);
            this.giohacanh = dateFormat.parse(gioHaCanhStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return String.format("| %-12s | %-18s | %-15s | %-21s | %-21s |", matuyenbay, masanbaycatcanh, sanbayhacanh, dateFormat.format(giocatcanh), dateFormat.format(giohacanh));
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
                    TuyenBay tuyenBay = new TuyenBay(parts[0], parts[1], parts[2], new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parts[3]), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parts[4]));
                    danhSachTuyenBay[soLuongTuyenBay++] = tuyenBay;
                }
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }

    // Phương thức cập nhật thông tin tuyến bay trong mảng động
    public static void capNhatThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã tuyến bay cần cập nhật:");
        String maTuyenBay = scanner.nextLine();

        for (int i = 0; i < soLuongTuyenBay; i++) {
            if (danhSachTuyenBay[i].getMaTuyenBay().equals(maTuyenBay)) {
                System.out.println("Nhập mã sân bay hạ cánh mới:");
                danhSachTuyenBay[i].setSanBayHaCanh(scanner.nextLine());
                System.out.println("Nhập giờ cất cánh mới (dd/MM/yyyy HH:mm):");
                String gioCatCanhStr = scanner.nextLine();
                System.out.println("Nhập giờ hạ cánh mới (dd/MM/yyyy HH:mm):");
                String gioHaCanhStr = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                try {
                    danhSachTuyenBay[i].setGioCatCanh(dateFormat.parse(gioCatCanhStr));
                    danhSachTuyenBay[i].setGioHaCanh(dateFormat.parse(gioHaCanhStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                danhSachTuyenBay[i].xuatDuLieu();
                break;
            }
        }
    }

    // Phương thức xóa thông tin tuyến bay từ mảng động
    public static void xoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã tuyến bay cần xóa:");
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
        System.out.println("Danh Sách Tuyến Bay Sau Khi Xóa");
        hienThiDanhSachTuyenBay();
    }

    // Phương thức thêm thông tin tuyến bay vào mảng động
    public static void themTuyenBay() {
        if (soLuongTuyenBay < MAX_TUYENBAY) {
            TuyenBay tuyenBayMoi = new TuyenBay();
            tuyenBayMoi.nhapDuLieu();
            danhSachTuyenBay[soLuongTuyenBay++] = tuyenBayMoi;
            System.out.println("Danh Sách Tuyến Bay Sau Khi Thêm");
            hienThiDanhSachTuyenBay();
        } else {
            System.out.println("Danh sách tuyến bay đã đầy. Không thể thêm tuyến bay mới.");
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
        System.out.println("\nDanh sách sau khi thêm:");
        hienThiDanhSachTuyenBay();

        // Cập nhật thông tin một tuyến bay
        capNhatThongTin();
        System.out.println("\nDanh sách sau khi cập nhật:");
        hienThiDanhSachTuyenBay();

        // Xóa một tuyến bay
        xoaThongTin();
    }
}



