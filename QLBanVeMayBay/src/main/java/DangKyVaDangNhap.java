import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DangKyVaDangNhap {
    private static final String USER_FILE = "users.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    System.out.println("Da thoat khoi chuong trinh.");
                    return;
                default:
                    System.out.println("Tu chon khong hop le. Vui long chon lai.");
            }
        }
    }

    private static void dangKy() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Dang ky -----");
        System.out.print("Nhap ten tai khoan: ");
        String username = scanner.nextLine();

        if (tenDangNhapCoTonTai(username)) {
            System.out.println("Ten tai khoan da ton tai. Vui long chon ten tai khoan khac.");
            return;
        }

        System.out.print("Nhap mat khau: ");
        String password = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("Dang ky thanh cong.");
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi luu du lieu.");
        }
    }

    private static boolean tenDangNhapCoTonTai(String username) {
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

    private static void dangNhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Dang nhap -----");
        System.out.print("Nhap ten tai khoan: ");
        String username = scanner.nextLine();

        if (!tenDangNhapCoTonTai(username)) {
            System.out.println("Ten tai khoan khong ton tai.");
            System.out.println("Vui long nhap lai!");
            dangNhap();
        }

        System.out.print("Nhap mat khau: ");
        String password = scanner.nextLine();

        
        // them dieu kien de vao trang admin

        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    System.out.println("Dang nhap thanh cong.");
                    return;
                }
            }
            System.out.println("Mat khau khong dung.");
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi doc du lieu.");
        }
    }
}