/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_do_an;

import java.io.*;
import java.util.Scanner;

public class HangMayBay {

    private static final int MAX_HANGMAYBAY = 100; // Số lượng tối đa của hãng máy bay
    private static HangMayBay[] danhSachHangMayBay = new HangMayBay[MAX_HANGMAYBAY]; // Mảng động chứa thông tin hãng máy bay
    private static int soLuongHangMayBay = 0; // Số lượng hãng máy bay hiện tại trong danh sách

    private String mahang;
    private String tenhang;

    public HangMayBay() {
        // Constructor rỗng để sử dụng khi nhập dữ liệu từ bàn phím
    }

    public HangMayBay(String mahang, String tenhang) {
        this.mahang = mahang;
        this.tenhang = tenhang;
    }

    public String getMaHang() {
        return mahang;
    }

    public void setMaHang(String mahang) {
        this.mahang = mahang;
    }

    public String getTenHang() {
        return tenhang;
    }

    public void setTenHang(String tenhang) {
        this.tenhang = tenhang;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhapDuLieuHangMayBay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma hang may bay");
        this.mahang = scanner.nextLine();
        System.out.println("Nhap ten hang may bay:");
        this.tenhang = scanner.nextLine();
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-15s |", mahang, tenhang);
    }

    // Phương thức xuất dữ liệu ra màn hình
    public void xuatDuLieu() {
        System.out.println(toString());
    }

    // Phương thức lưu dữ liệu vào file
    public void luuDuLieuVaoFile(String tenFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenFile, true))) {
            writer.printf("%s,%s%n", mahang, tenhang);
        } catch (IOException e) {
        }
    }

    // Phương thức đọc dữ liệu từ file vào mảng động
    public static void docDuLieuTuFile(String tenFile) {
        try (Scanner scanner = new Scanner(new File(tenFile))) {
            while (scanner.hasNextLine() && soLuongHangMayBay < MAX_HANGMAYBAY) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 2) {
                    HangMayBay hangMayBay = new HangMayBay(parts[0], parts[1]);
                    danhSachHangMayBay[soLuongHangMayBay++] = hangMayBay;
                }
            }
        } catch (FileNotFoundException e) {
        }
    }

    // Phương thức cập nhật thông tin hãng máy bay trong mảng động
    public static void capNhatThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma hang may bay can cap nhat:");
        String maHang = scanner.nextLine();

        for (int i = 0; i < soLuongHangMayBay; i++) {
            if (danhSachHangMayBay[i].getMaHang().equals(maHang)) {
                System.out.println("Nhap ten hang may bay moi:");
                danhSachHangMayBay[i].setTenHang(scanner.nextLine());
                danhSachHangMayBay[i].xuatDuLieu();
                break;
            }
        }
        hienThiDanhSachHangMayBay();
    }

    // Phương thức xóa thông tin hãng máy bay từ mảng động
    public static void xoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma hang may bay can xoa:");
        String maHang = scanner.nextLine();

        for (int i = 0; i < soLuongHangMayBay; i++) {
            if (danhSachHangMayBay[i].getMaHang().equals(maHang)) {
                for (int j = i; j < soLuongHangMayBay - 1; j++) {
                    danhSachHangMayBay[j] = danhSachHangMayBay[j + 1];
                }
                soLuongHangMayBay--;
                break;
            }
        }
        System.out.println("Danh sach hang may bay sau khi xoa");
        hienThiDanhSachHangMayBay();
    }

    // Phương thức thêm thông tin hãng máy bay vào mảng động
    public static void themHangMayBay() {
        if (soLuongHangMayBay < MAX_HANGMAYBAY) {
            HangMayBay hangMayBayMoi = new HangMayBay();
            hangMayBayMoi.nhapDuLieu();
            danhSachHangMayBay[soLuongHangMayBay++] = hangMayBayMoi;
        } else {
            System.out.println("Danh sach hang may bay da day. Khong the them hang may bay moi.");
        }
        hienThiDanhSachHangMayBay();
    }

    // Hiển thị danh sách hãng máy bay
    public static void hienThiDanhSachHangMayBay() {
        System.out.printf("| %-12s | %-15s |%n", "mahang", "tenhang");
        System.out.println("|--------------|-----------------|");
        for (int i = 0; i < soLuongHangMayBay; i++) {
            danhSachHangMayBay[i].xuatDuLieu();
        }
    }

    public static void main(String[] args) {
        docDuLieuTuFile("HangMayBay.txt");
    }
}

