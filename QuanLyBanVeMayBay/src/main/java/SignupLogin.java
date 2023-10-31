
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class SignupLogin {

    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("1. Dang nhap \n2. Dang ki\n0. Thoat\nMoi ban chon: ");
            int choice = input.nextInt();

            if (choice == 1) {
                login();
            } else if (choice == 2) {
                signup();
            } else if (choice == 0) {
                return;
            }
        }

    }

    public static void login() {
        Scanner input = new Scanner(System.in);

        System.out.print("Ten tai khoan: ");
        String username = input.nextLine();

        System.out.print("Mat khau: ");
        String password = input.nextLine();

        try {
            Scanner fileReader = new Scanner(new File("users.txt"));
            while (fileReader.hasNextLine()) {
                String[] userData = fileReader.nextLine().split(",");
                if (userData[0].equals(username) && userData[1].equals(password)) {
                    System.out.println("Dang nhap thanh!");
                    return;
                }
            }
            System.out.println("Thong tin dang nhap khong hop le!");
        } catch (Exception e) {
            System.out.println("Loi truy cap tep nguoi dung!");
        }
    }

    public static void signup() {
        Scanner input = new Scanner(System.in);

        System.out.print("Ten tai khoan: ");
        String username = input.nextLine();

        System.out.print("Mat khau: ");
        String password = input.nextLine();

        boolean isUsernameExists = false;

        try {
            Scanner fileReader = new Scanner(new File("users.txt"));
            while (fileReader.hasNextLine()) {
                String[] userData = fileReader.nextLine().split(",");
                if (userData[0].equals(username) && userData[1].equals(password)) {
                    isUsernameExists = true;

                    break;
                }
            }
            fileReader.close();

            if (isUsernameExists) {
                System.out.println("Ten nguoi dung da ton tai! Vui long nhap lai:");
         
                signup();
            } else {
                BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
                writer.write(username + "," + password);
                writer.newLine();
                writer.close();
                System.out.println("Tao tai khoan thanh cong!");
            }
        } catch (Exception e) {
            System.out.println("Tao tai khoan that bai!");
        }
    }

}
