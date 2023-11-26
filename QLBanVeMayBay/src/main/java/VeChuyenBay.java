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

public class VeChuyenBay {
    private String maVe;
    private String tinhTrangVe;
    private static final int MAX_VE = 200;
    private static VeChuyenBay[] danhSachVe = new VeChuyenBay[MAX_VE];
    private static int soLuongVe = 0;

    public VeChuyenBay(String maVe, String tinhTrangVe) {
        this.maVe = maVe;
        this.tinhTrangVe = tinhTrangVe;
    }

    public VeChuyenBay() {
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getTinhTrangVe() {
        return tinhTrangVe;
    }

    public void setTinhTrangVe(String tinhTrangVe) {
        this.tinhTrangVe = tinhTrangVe;
    }
    
    public void nhapDuLieuVeMayBay (){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma ve: ");
        setMaVe(sc.nextLine());
        System.out.print("Nhap tinh trang ve: ");
        setTinhTrangVe(sc.nextLine());
    }

    @Override
    public String toString() {
        return  "maVe=" + maVe + ", tinhTrangVe=" + tinhTrangVe ;
    }
    
  
    public void xuatDuLieuVeMayBay () {
        System.out.println(toString());
    }
    
    public void luuDulieuVaoFile(String tenTep) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenTep, true))) {
            writer.println(toString());
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void docDuLieuTuFile(String tenFile, VeChuyenBay[] danhSachVe, int MAX_VE) {
        try (Scanner scanner = new Scanner(new File(tenFile))) {
            while (scanner.hasNextLine() && soLuongVe < MAX_VE) {
                String[] parts = scanner.nextLine().split(",");

                if (parts.length == 2) {
                    String maVe = parts[0].trim();
                    String tinhTrangVe = parts[1].trim();
                
                    VeChuyenBay veMayBay = new VeChuyenBay();
                    veMayBay.setMaVe(maVe);
                    veMayBay.setTinhTrangVe(tinhTrangVe);

                    danhSachVe[soLuongVe++] = veMayBay;
                }
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }  
    }
    
    public void capNhatMaVe(String maVeCanCapNhat) {
        Scanner sc=new Scanner(System.in);
        
        for (int i=0;i<danhSachVe.length;i++) {
            if (danhSachVe[i] !=null && danhSachVe[i].getMaVe().equals(maVeCanCapNhat)) {
                System.out.println("Nhap thong tin moi cho ve may bay: ");
                danhSachVe[i].nhapDuLieuVeMayBay();
                System.out.println("Thong tin ve may bay sau khi cap nhat: ");
                danhSachVe[i].xuatDuLieuVeMayBay();
                return;
            }
        }
        System.out.println("Khong tim thay ve may bay co ma "+ maVeCanCapNhat);
    }
    
   public void capNhatTinhTrangVe(String maVeCanCapNhat, String tinhTrangMoi) {
    boolean timThayVe = false;

    for (int i = 0; i < danhSachVe.length; i++) {
        if (danhSachVe[i] != null && danhSachVe[i].getMaVe().equals(maVeCanCapNhat)) {
            danhSachVe[i].setTinhTrangVe(tinhTrangMoi);
            System.out.println("Tinh trang ve may bay sau khi cap nhat: ");
            danhSachVe[i].xuatDuLieuVeMayBay();
            timThayVe = true;
            break;
        }
    }

    if (!timThayVe) {
        System.out.println("Khong tim thay ve may bay co ma " + maVeCanCapNhat);
    }
    }

    public void xoaVeMayBay(String maVeCanXoa) {
        for (int i = 0; i < danhSachVe.length; i++) {
            if (danhSachVe[i] != null && danhSachVe[i].getMaVe().equals(maVeCanXoa)) {
                System.out.println("Thong tin ve may bay truoc khi xoa:");
                danhSachVe[i].xuatDuLieuVeMayBay();
                
                danhSachVe[i] = null; 

                System.out.println("Da xoa thong tin ve may bay");
                return;
            }
        }
        System.out.println("Khong tim thay ve may bay co ma " + maVeCanXoa);
    }
    
    public void themVeMoi() {
        if (soLuongVe < MAX_VE) {
            VeChuyenBay veMoi = new VeChuyenBay();
            veMoi.nhapDuLieuVeMayBay();

            danhSachVe[soLuongVe++] = veMoi;

            System.out.println("Da them mot ve moi");
        } 
        else {
            System.out.println("Danh sach ve da day, khong the them ve moi");
        }
    }
    
    public void hienThiDanhSachVe() {
        if (soLuongVe == 0) {
            System.out.println("Danh sach ve may bay hien dang trong.");
        } else {
            System.out.println("Danh sach ve may bay:");
            for (int i = 0; i < soLuongVe; i++) {
                System.out.println(danhSachVe[i].toString());
            }
        }
    }
}
