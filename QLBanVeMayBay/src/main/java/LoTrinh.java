/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.Scanner;

public class LoTrinh {

    private static final int MAX_LOTRINH = 100; // Số lượng tối đa của lộ trình
    private static LoTrinh[] danhSachLoTrinh = new LoTrinh[MAX_LOTRINH]; // Mảng động chứa thông tin lộ trình
    private static int soLuongLoTrinh = 0; // Số lượng lộ trình hiện tại trong danh sách

    private String malotrinh;
    private String tenlotrinh;
    private String noiden;
    private String noidi;

    public LoTrinh(String malotrinh, String tenlotrinh, String noiden, String noidi) {
        this.malotrinh = malotrinh;
        this.tenlotrinh = tenlotrinh;
        this.noiden = noiden;
        this.noidi = noidi;
    }

    public LoTrinh() {
        // Constructor rỗng để sử dụng khi nhập dữ liệu từ bàn phím
    }

    public String getMaLoTrinh() {
        return malotrinh;
    }

    public void setMaLoTrinh(String malotrinh) {
        this.malotrinh = malotrinh;
    }

    public String getTenLoTrinh() {
        return tenlotrinh;
    }

    public void setTenLoTrinh(String tenlotrinh) {
        this.tenlotrinh = tenlotrinh;
    }

    public String getNoiDen() {
        return noiden;
    }

    public void setNoiDen(String noiden) {
        this.noiden = noiden;
    }

    public String getNoiDi() {
        return noidi;
    }

    public void setNoiDi(String noidi) {
        this.noidi = noidi;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhapDuLieuLoTrinh() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma lo trinh:");
        this.malotrinh = scanner.nextLine();
        System.out.println("Nhap ten lo trinh:");
        this.tenlotrinh = scanner.nextLine();
        System.out.println("Nhap noi den:");
        this.noiden = scanner.nextLine();
        System.out.println("Nhap noi di:");
        this.noidi = scanner.nextLine();
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-15s | %-15s | %-15s |", malotrinh, tenlotrinh, noiden, noidi);
    }

    // Phương thức xuất dữ liệu ra màn hình
    public void xuatDuLieu() {
        System.out.println(toString());
    }

    // Phương thức lưu dữ liệu vào file
    public void luuDuLieuVaoFile(String tenFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenFile, true))) {
            writer.printf("%s,%s,%s,%s%n", malotrinh, tenlotrinh, noiden, noidi);
        } catch (IOException e) {
        }
    }

    // Phương thức đọc dữ liệu từ file vào mảng động
    public static void docDuLieuTuFile(String tenFile) {
        try (Scanner scanner = new Scanner(new File(tenFile))) {
            while (scanner.hasNextLine() && soLuongLoTrinh < MAX_LOTRINH) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 4) {
                    LoTrinh loTrinh = new LoTrinh(parts[0], parts[1], parts[2], parts[3]);
                    danhSachLoTrinh[soLuongLoTrinh++] = loTrinh;
                }
            }
        } catch (FileNotFoundException e) {
        }
    }

    // Phương thức cập nhật thông tin lộ trình trong mảng động
    public static void capNhatThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma lo trinh can cap nhat:");
        String maLoTrinh = scanner.nextLine();

        for (int i = 0; i < soLuongLoTrinh; i++) {
            if (danhSachLoTrinh[i].getMaLoTrinh().equals(maLoTrinh)) {
                System.out.println("Nhap ten lo trinh moi:");
                danhSachLoTrinh[i].setTenLoTrinh(scanner.nextLine());
                System.out.println("Nhap noi den moi:");
                danhSachLoTrinh[i].setNoiDen(scanner.nextLine());
                System.out.println("Nhap noi di moi:");
                danhSachLoTrinh[i].setNoiDi(scanner.nextLine());
                break;
            }
        }
        //hiện thị danh sách dau khi cập nhật
        hienThiDanhSachLoTrinh();
    }

    // Phương thức xóa thông tin lộ trình từ mảng động
    public static void xoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma lo trinh can xoa:");
        String maLoTrinh = scanner.nextLine();

        for (int i = 0; i < soLuongLoTrinh; i++) {
            if (danhSachLoTrinh[i].getMaLoTrinh().equals(maLoTrinh)) {
                for (int j = i; j < soLuongLoTrinh - 1; j++) {
                    danhSachLoTrinh[j] = danhSachLoTrinh[j + 1];
                }
                soLuongLoTrinh--;
                break;
            }
            System.out.println("Danh sach lo trinh sau khi xoa");
            
        }
        //hiện thị danh sách sau khi xóa
        hienThiDanhSachLoTrinh();
    }

    // Phương thức thêm thông tin lộ trình vào mảng động
    public static void themLoTrinh() {
        if (soLuongLoTrinh < MAX_LOTRINH) {
            LoTrinh loTrinhMoi = new LoTrinh();
            loTrinhMoi.nhapDuLieuLoTrinh();
            danhSachLoTrinh[soLuongLoTrinh++] = loTrinhMoi;
           
        } else {
            System.out.println("Danh sach lo trinh da day. Khong the them lo trinh moi.");
        }
        //Hiện thị danh sách sau khi thêm mới
        hienThiDanhSachLoTrinh();
    }

    // Hiển thị danh sách lộ trình
    public static void hienThiDanhSachLoTrinh() {
        System.out.printf("| %-12s | %-15s | %-15s | %-15s |%n", "malotrinh", "tenlotrinh", "noiden", "noidi");
        System.out.println("|--------------|-----------------|-----------------|-----------------|");
        for (int i = 0; i < soLuongLoTrinh; i++) {
            danhSachLoTrinh[i].xuatDuLieu();
        }
    }
}
