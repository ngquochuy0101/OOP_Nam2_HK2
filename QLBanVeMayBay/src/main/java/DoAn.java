/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doan;

import java.util.Scanner;

/**
 *
 * @author GIA NGHI TRINH
 */
public class DoAn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        VeMayBay veMayBay = new VeMayBay();
        int choice;

        do {
            System.out.println("\n===== Quan Ly Ve May Bay =====");
            System.out.println("1. Them ve moi");
            System.out.println("2. Cap nhat thong tin ve");
            System.out.println("3. Xoa thong tin ve");
            System.out.println("4. Cap nhat tinh trang ve");
            System.out.println("5. Hien thi danh sach ve");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    veMayBay.themVeMoi();
                    break;
                case 2:
                    System.out.print("Nhap ma ve can cap nhat: ");
                    String maVeCanCapNhat = sc.nextLine();
                    veMayBay.capNhatMaVe(maVeCanCapNhat);
                    break;
                case 3:
                    System.out.print("Nhap ma ve can xoa: ");
                    String maVeCanXoa = sc.nextLine();
                    veMayBay.xoaVeMayBay(maVeCanXoa);
                    break;
                case 4:
                    System.out.print("Nhap ma ve can cap nhat tinh trang: ");
                    String maVeCanCapNhatTinhTrang = sc.nextLine();
                    System.out.print("Nhap tinh trang moi: ");
                    String tinhTrangMoi = sc.nextLine();
                    veMayBay.capNhatTinhTrangVe(maVeCanCapNhatTinhTrang, tinhTrangMoi);
                    break;
                case 5:
                    veMayBay.hienThiDanhSachVe();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai");
                    break;
            }

        } while (choice != 0);
        
        sc.close(); */
        
        /*---------------------------------------------------------------------------*/
        /*
        PhanHangVe phanHangVe = new PhanHangVe();
        
        int choice;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Hien thi danh sach ve");
            System.out.println("2. Them ve moi");
            System.out.println("3. Cap nhat thong tin ve");
            System.out.println("4. Xoa ve");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    phanHangVe.hienThiDanhSachVe();
                    break;
                case 2:
                    phanHangVe.themVeMoi();
                    break;
                case 3:
                    System.out.print("Nhap ma ve can cap nhat: ");
                    String maVeCanCapNhat = sc.nextLine();
                    phanHangVe.capNhatThongTinVe(maVeCanCapNhat, "");
                    break;
                case 4:
                    System.out.print("Nhap ma ve can xoa: ");
                    String maVeCanXoa = sc.nextLine();
                    phanHangVe.xoaHangVe(maVeCanXoa);
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }

        } while (choice != 5);
        
        sc.close();
        }*/
        
        /*---------------------------------------------------------------------------*/
        
        PhieuDatVe phieuDatVe= new PhieuDatVe();
        boolean exit = false;

        do {
            System.out.println("\n====== Quan Ly Dat Ve ======");
            System.out.println("1. Them Phieu Dat Ve Moi");
            System.out.println("2. Cap Nhat Thong Tin Ve");
            System.out.println("3. Xoa Phieu Dat Ve");
            System.out.println("4. Hien Thi Danh Sach Ve");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            int choice = sc.nextInt(); 

            switch (choice) {
                case 1:
                    phieuDatVe.themPhieuDatVeMoi();
                    break;
                case 2:
                    System.out.print("Nhap ma phieu dat ve can cap nhat: ");
                    String maPhieuDatCanCapNhat = sc.next(); 
                    System.out.print("Nhap ngay dat ve moi: ");
                    String ngayDatMoi = sc.next();
                    phieuDatVe.capNhatThongTinVe(maPhieuDatCanCapNhat, ngayDatMoi);
                    break;
                case 3:
                    System.out.print("Nhap ma phieu dat ve can xoa: ");
                    String maVeCanXoa = sc.next();
                    phieuDatVe.xoaPhieuDatVe(maVeCanXoa);
                    break;
                case 4:
                    phieuDatVe.hienThiDanhSachVe();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Cam on da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        } while (!exit);

        sc.close(); 
    }
}


