/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HangVe {

    private String maVe;
    private String hangVe;
    private String gia;

    private int phoThong;
    private int thuongGia;

    public HangVe(String maVe, String hangVe, String gia, int phoThong, int thuongGia) {
        this.maVe = maVe;
        this.hangVe = hangVe;
        this.gia = gia;
        this.phoThong = phoThong;
        this.thuongGia = thuongGia;
    }
     public HangVe( int phoThong, int thuongGia) {
        this.phoThong = phoThong;
        this.thuongGia = thuongGia;
    }


    private static final int MAX_VE = 200;
    private static HangVe[] danhSachHangVe = new HangVe[MAX_VE];
    private static int soLuongVe = 0;
    public Scanner sc = new Scanner(System.in);

    public HangVe() {
    }

    public HangVe(String maVe, String hangVe) {
        this.maVe = maVe;
        this.hangVe = hangVe;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getHangVe() {
        return hangVe;
    }

    public void setHangVe(String hangVe) {
        this.hangVe = hangVe;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public static HangVe[] getDanhSachHangVe() {
        return danhSachHangVe;
    }

    public static void setDanhSachHangVe(HangVe[] danhSachHangVe) {
        HangVe.danhSachHangVe = danhSachHangVe;
    }

    public static int getSoLuongVe() {
        return soLuongVe;
    }

    public static void setSoLuongVe(int soLuongVe) {
        HangVe.soLuongVe = soLuongVe;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getPhoThong() {
        return phoThong;
    }

    public void setPhoThong(int phoThong) {
        this.phoThong = phoThong;
    }

    public int getThuongGia() {
        return thuongGia;
    }

    public void setThuongGia(int thuongGia) {
        this.thuongGia = thuongGia;
    }

    public void nhapDuLieuHangVe() {
        System.out.print("Nhap gia ve cho hang ve pho thong : ");
         setPhoThong(sc.nextInt());
        System.out.print("Nhap gia ve cho hang ve thuong gia: ");
        setThuongGia(sc.nextInt());
    }

    @Override
    public String toString() {
        return "phoThong=" + phoThong + ", thuongGia=" + thuongGia;
    }

    public void xuatDuLieuPhanHangVe() {
        System.out.println(toString());
    }

    public void luuDulieuVaoFile(String tenTep) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenTep, true))) {
            writer.println(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void docDuLieuTuFile(String tenFile, HangVe[] danhSachHangVe, int MAX_VE) {
        try (Scanner sc = new Scanner(new File(tenFile))) {
            while (sc.hasNextLine() && soLuongVe < MAX_VE) {
                String[] parts = sc.nextLine().split("\\|");

                if (parts.length == 2) {
                    String maVe = parts[0].trim();
                    String hangVe = parts[1].trim();

                    if ("Thuong gia".equalsIgnoreCase(hangVe) || "Pho thong".equalsIgnoreCase(hangVe)) {
                        HangVe phanHangVe = new HangVe(maVe, hangVe);
                        danhSachHangVe[soLuongVe++] = phanHangVe;
                    } else {
                        System.out.println("Hang ve khong hop le - " + hangVe);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void capNhatThongTinVe(String maVeCanCapNhat, String hangVeMoi) {

        for (int i = 0; i < danhSachHangVe.length; i++) {
            if (danhSachHangVe[i] != null && danhSachHangVe[i].getMaVe().equals(maVeCanCapNhat)) {
                System.out.println("Nhap thong tin moi cho ve may bay: ");
                danhSachHangVe[i].nhapDuLieuHangVe();

                System.out.println("Nhap hang ve moi: ");
                hangVeMoi = sc.nextLine();
                danhSachHangVe[i].setHangVe(hangVeMoi);

                System.out.println("Thong tin ve may bay sau khi cap nhat: ");
                danhSachHangVe[i].xuatDuLieuPhanHangVe();
                return;
            }
        }
        System.out.println("Khong tim thay ve may bay co ma " + maVeCanCapNhat);
    }

    public void xoaHangVe(String maVeCanXoa) {
        for (int i = 0; i < danhSachHangVe.length; i++) {
            if (danhSachHangVe[i] != null && danhSachHangVe[i].getMaVe().equals(maVeCanXoa)) {
                System.out.println("Thong tin ve truoc khi xoa:");
                danhSachHangVe[i].xuatDuLieuPhanHangVe();

                danhSachHangVe[i] = null;

                System.out.println("Da xoa thong tin ve");
                return;
            }
        }
        System.out.println("Khong tim thay ve co ma " + maVeCanXoa);
    }

    public void themVeMoi() {
        if (soLuongVe < MAX_VE) {
            HangVe veMoi = new HangVe();
            veMoi.nhapDuLieuHangVe();

            String maVe = veMoi.getMaVe();
            String hangVe = veMoi.getHangVe();

            // Kiểm tra hợp lệ của hạng vé trước khi thêm vào danh sách
            if ("Thuong gia".equalsIgnoreCase(hangVe) || "Pho thong".equalsIgnoreCase(hangVe)) {
                danhSachHangVe[soLuongVe++] = veMoi;
                System.out.println("Da them mot ve moi");
            } else {
                System.out.println("Hang ve khong hop le ");
            }
        } else {
            System.out.println("Danh sach ve da day, khong the them ve moi");
        }
    }

    public void hienThiDanhSachVe() {
        if (soLuongVe == 0) {
            System.out.println("Danh sach ve hien dang trong.");
        } else {
            System.out.println("Danh sach ve va hang ve:");
            for (int i = 0; i < soLuongVe; i++) {
                System.out.println(danhSachHangVe[i].toString());
            }
        }
    }
}
