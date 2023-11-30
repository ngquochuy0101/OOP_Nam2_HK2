/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author GIA NGHI TRINH
 */
public class PhieuDatVe {
    private static final String USER_FILE = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\users.txt";

    private String maPhieuDat;
    private String ngayDat;
    private static final int MAX_PHIEU = 200;
    private static PhieuDatVe[] danhSachPhieuDatVe = new PhieuDatVe[MAX_PHIEU];
    private static int soLuongPhieuDatVe = 0;
    public Scanner sc= new Scanner(System.in);
    private static ChuyenBay cb = new ChuyenBay();
    private static ConNguoi tt = new ConNguoi();



    public PhieuDatVe() {
    }

    public PhieuDatVe(String maPhieuDat, String ngayDat) {
        this.maPhieuDat = maPhieuDat;
        this.ngayDat = ngayDat;
    }

    public String getMaPhieuDat() {
        return maPhieuDat;
    }

    public void setMaPhieuDat(String maPhieuDat) {
        this.maPhieuDat = maPhieuDat;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }
    
    public void nhapDuLieuPhieuDatVe() {
        System.out.print("Nhap ma dat ve: ");
        setMaPhieuDat(sc.nextLine());
        System.out.print("Nhap ngay dat ve: ");
        setNgayDat(sc.nextLine());
    }

    @Override
    public String toString() {
        return   "maPhieuDat=" + maPhieuDat + ", ngayDat=" + ngayDat ;
    }
    
   
    
    public void xuatDuLieuPhieuDatVe() {

        System.out.println(toString());
        System.out.println("Thong tin nguoi dat ve: ");
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(cb.getUser())) {
                    tt.setHoTen(parts[2]);
                    tt.setCCCD(parts[3]);
                    tt.setNgaySinh(parts[4]);
                    tt.setSDT(parts[5]);
                    tt.xuatTT(); // Tim thay ten tai khoan trong tep tin
                }
            }
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi doc du lieu.");
        }

    }
    
    private String kiemTraNgayDat(String ngayDat) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(ngayDat);
            return outputFormat.format(date);
        } 
        catch (ParseException e) {
            System.out.println("Ngay dat khong hop le, vui long su dung dinh dang dd/MM/yyyy.");
            return null;
        }
    }
    
    public void luuDulieuVaoFile(String tenTep) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenTep, true))) {
            writer.println(toString());
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void docDuLieuTuFile(String tenFile, PhieuDatVe[] danhSachPhieuDatVe, int MAX_PHIEUDATVE) {
    int soLuongPhieuDatVe = 0;

    try (Scanner sc = new Scanner(new File(tenFile))) {
        while (sc.hasNextLine() && soLuongPhieuDatVe < MAX_PHIEUDATVE) {
            String[] parts = sc.nextLine().split("\\|");

            if (parts.length == 2) {
                String maPhieuDat = parts[0].trim();
                String ngayDat = parts[1].trim();

                PhieuDatVe phieuDatVe = new PhieuDatVe(maPhieuDat, ngayDat);
                danhSachPhieuDatVe[soLuongPhieuDatVe++] = phieuDatVe;
            }
        }
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    } 
    
    public void capNhatThongTinVe(String maPhieuDatCanCapNhat, String ngayDatMoi) {
        for (int i = 0; i < danhSachPhieuDatVe.length; i++) {
            if (danhSachPhieuDatVe[i] != null && danhSachPhieuDatVe[i].getMaPhieuDat().equals(maPhieuDatCanCapNhat)) {
                System.out.println("Nhap thong tin moi cho phieu dat ve: ");
                danhSachPhieuDatVe[i].nhapDuLieuPhieuDatVe();

                System.out.println("Nhap ngay dat ve moi: ");
                ngayDatMoi = sc.nextLine();
                String check = kiemTraNgayDat(ngayDatMoi);

                if (check!= null) {
                    danhSachPhieuDatVe[i].setNgayDat(check);
                }

                System.out.println("Thong tin phieu dat ve sau khi cap nhat: ");
                danhSachPhieuDatVe[i].xuatDuLieuPhieuDatVe();
                return;
            }
        }
    System.out.println("Khong tim thay phieu dat ve co ma " + maPhieuDatCanCapNhat);
    }
    
    public void xoaPhieuDatVe(String maVeCanXoa) {
        for (int i = 0; i < danhSachPhieuDatVe.length; i++) {
            if (danhSachPhieuDatVe[i] != null && danhSachPhieuDatVe[i].getMaPhieuDat().equals(maVeCanXoa)) {
                System.out.println("Thong tin ve truoc khi xoa:");
                danhSachPhieuDatVe[i].xuatDuLieuPhieuDatVe();
                
                danhSachPhieuDatVe[i] = null; 

                System.out.println("Da xoa thong tin ve");
                return;
            }
        }
        System.out.println("Khong tim thay ve co ma " + maVeCanXoa);
    }
    
    public void themPhieuDatVeMoi() {
        if (soLuongPhieuDatVe < MAX_PHIEU) {
            PhieuDatVe phieuDatVeMoi = new PhieuDatVe();
            phieuDatVeMoi.nhapDuLieuPhieuDatVe();

            String maPhieuDat = phieuDatVeMoi.getMaPhieuDat();
            String ngayDat = phieuDatVeMoi.getNgayDat();

            if (maPhieuDat != null && ngayDat != null) {
                String check = kiemTraNgayDat(ngayDat);

                if (check != null) {
                    phieuDatVeMoi.setNgayDat(check);
                    danhSachPhieuDatVe[soLuongPhieuDatVe++] = phieuDatVeMoi;
                    System.out.println("Da them mot phieu dat ve moi");
                } 
                else {
                    System.out.println("Thong tin ngay dat ve khong hop le");
            }
            } 
            else {
                System.out.println("Thong tin phieu dat ve khong hop le");
            }
        } 
        else {
            System.out.println("Danh sach phieu dat ve da day, khong the them phieu moi");
        }
    }   
    
    public void hienThiDanhSachVe() {
        if (soLuongPhieuDatVe == 0) {
            System.out.println("Danh sach phieu dat ve hien dang trong");
        } else {
            System.out.println("Danh sach phieu dat ve:");
            for (int i = 0; i < soLuongPhieuDatVe; i++) {
                System.out.println(danhSachPhieuDatVe[i].toString());
            }
        }
    }
}
