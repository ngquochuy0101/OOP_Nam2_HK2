
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DangKyVaDangNhap {

    private static final String USER_FILE = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\users.txt";
    private static Scanner scanner = new Scanner(System.in);
    private static ChuyenBay cb = new ChuyenBay();

    public static void dangKy() {

        System.out.println("----- Dang ky -----");
        System.out.print("Nhap ten tai khoan: ");
        scanner.nextLine();
        String username = scanner.nextLine();
        if (username.length() >= 6 && username.length() <= 12) {

            if (tenDangNhapCoTonTai(username)) {
                System.out.println("Ten tai khoan da ton tai. Vui long chon ten tai khoan khac.");
                return;
            }

            System.out.print("Nhap mat khau: ");
            String password = scanner.nextLine();
            if (password.length() >= 6 && password.length() <= 12) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
                    writer.write(username + "," + password);
                    writer.newLine();
                    System.out.println("Dang ky thanh cong.");
                } catch (IOException e) {
                    System.out.println("Da xay ra loi khi luu du lieu.");
                }
            } else {
                System.out.println("Mat khau phai luong hon 6 va be hon 12");
                return;
            }

        } else {
            System.out.println("Ten tai khoan phai luong hon 6 va be hon 12");
            return;
        }

    }

    public static boolean tenDangNhapCoTonTai(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(username)) {
                    return true; // Tim thay ten tai khoan trong tep tin
                }
            }
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi doc du lieu.");
        }
        return false; // Khong tim thay ten tai khoan trong tep tin
    }

    public static void dangNhap() {
        System.out.println("----- Dang nhap -----");
        System.out.print("Nhap ten tai khoan: ");
        scanner.nextLine();
        String username = scanner.nextLine();

        if (!tenDangNhapCoTonTai(username)) {
            System.out.println("Ten tai khoan khong ton tai.");
            System.out.println("Vui long nhap lai!");
            return;
        }

        System.out.print("Nhap mat khau: ");
        String password = scanner.nextLine();

        // thêm điều kiện để vào trang admin
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            boolean isAuthenticated = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    System.out.println("Dang nhap thanh cong.");
                    System.out.println("Xin chao!");
                    isAuthenticated = true;
                    cb.setUser(username);
                    cb.menuSetChuyenBayUser();
                    break;
                }
            }
            if (!isAuthenticated) {
                System.out.println("Mat khau khong dung.");
            }
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi doc du lieu.");
        }
    }

    public void RunDangKyDangNhap() {
        while (true) {
            System.out.println("----- MENU -----");
            System.out.println("1. Dang ky");
            System.out.println("2. Dang nhap");
            System.out.println("0. Thoat");
            System.out.print("Chon mot tu chon: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dangKy();
                    break;
                case 2:
                    dangNhap();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    System.out.println("Da thoat khoi chuong trinh.");
                    return;
                default:
                    System.out.println("Tu chon khong hop le. Vui long chon lai.");
            }
        }

    }

}
