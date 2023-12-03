
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**/

public class DangKyVaDangNhap implements DangKyVaDangNhapInterface {

    private static final String USER_FILE = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\users.txt";

    private  Scanner scanner = new Scanner(System.in);
    private  ChuyenBay cb = new ChuyenBay();
    private  ConNguoi tt = new ConNguoi();

<<<<<<< HEAD

    public static void dangKy() {

        System.out.println("----- Dang ky -----");
        System.out.print("Nhap ten tai khoan: ");
        // scanner.nextLine();
        String username = scanner.nextLine();
        if (username.length() >= 6 && username.length() <= 12) {
=======
    @Override
    public  void dangKy() {
        scanner.nextLine();
        System.out.println("----- Dang ky -----");
        String username = "111111";
        while (true) {
            System.out.print("Nhap ten tai khoan: ");
            username = scanner.nextLine();
>>>>>>> d651d05c08ed7122e83f1fcb7d538f78bed6a838

            if (username.matches("^[a-zA-Z0-9]+$") && username.length() >= 6 && username.length() <= 12) {
                if (tenDangNhapCoTonTai(username)) {
                    System.out.println("Ten tai khoan da ton tai. Vui long chon ten tai khoan khac.");
                } else {
                    break; // Thoát khỏi vòng lặp nếu tên tài khoản hợp lệ và chưa tồn tại
                }
            } else {
                System.out.println("Ten tai khoan phai lon hon 6 va be hon 12");
                System.out.println("Ten tai khoan khong duoc chua ky tu dac biet hoac dau cach. Vui long nhap lai.");
                continue; // Yêu cầu người dùng nhập lại tên tài khoản
            }
        }

        while (true) {
            System.out.print("Nhap mat khau: ");
            String password = scanner.nextLine();

            if (password.length() >= 6 && password.length() <= 12) {
                System.out.print("Nhap lai mat khau: ");
                String passwordB = scanner.nextLine();
                if (password.equals(passwordB)) {

                    System.out.println("Cau hoi bao mat:'Ban hoc truong nao?'");
                    while (true) {
                        String cauHoiBaoMat = scanner.nextLine();
                        if (cauHoiBaoMat.length() >= 3 && cauHoiBaoMat.matches("^[a-zA-Z\\s]+$")) {
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
                                tt.nhapTT();
                                writer.write(username + "," + password + "," + cauHoiBaoMat + ", "
                                        + tt.getHoTen() + ", " + tt.getCCCD() + ", " + tt.getNgaySinh() + ", " + tt.getSDT());
                                writer.newLine();
                                System.out.println("Dang ky thanh cong.");
                                return; // Thoát khỏi vòng lặp khi đăng ký thành công
                            } catch (IOException e) {
                                System.out.println("Da xay ra loi khi luu du lieu.");
                                return;
                            }
                        } else {
                            System.out.println("Cau tra loi phai lon hon 3");
                            System.out.println("Cau tra khong duoc chua ky tu dac biet. Vui long nhap lai.");
                            continue;
                        }
                    }

                } else {
                    System.out.println("Mat khau khong khop, vui long nhap lai!");
                }
            } else {
                System.out.println("Mat khau phai lon hon 6 va be hon 12");
            }
        }
    }

    @Override
    public  boolean tenDangNhapCoTonTai(String username) {
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

    @Override
    public  void dangNhap() throws IOException {
        System.out.println("----- Dang nhap -----");
        System.out.print("Nhap ten tai khoan: ");
        scanner.nextLine();
        String username = scanner.nextLine();

        if (!tenDangNhapCoTonTai(username) && !username.equals("ADMIN")) {
            System.out.println("Ten tai khoan khong ton tai.");
            System.out.println("Vui long nhap lai!");
            return;
        }

        System.out.print("Nhap mat khau: ");
        String password = scanner.nextLine();
        if (username.equals("ADMIN") && password.equals("ADMIN")) {
            System.out.println("Dang nhap thanh cong voi quyen Admin");
            System.out.println("Xin chao!");
            cb.menuSetChuyenBayAdmin();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
                String line;
                boolean isAuthenticated = false;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length >= 2 && parts[0].equals(username) && parts[1].equals(password)) {
                        {
                            System.out.println("Dang nhap thanh cong.");
                            System.out.println("Xin chao!");
                            isAuthenticated = true;
                            cb.setUser(username);
                            cb.menuSetChuyenBayUser();
                            break;
                        }
                    }
                }
                if (!isAuthenticated) {
                    System.out.println("Mat khau khong dung.");
                }
            } catch (IOException e) {
                System.out.println("Da xay ra loi khi doc du lieu.");
            }
        }
    }

    @Override
    public  void layLaiMatKhau() throws FileNotFoundException {

        System.out.print("Nhap ten tai khoan: ");
        scanner.nextLine();
        String username = "";
        int i = 0;
        while (true) {
            username = scanner.nextLine();
            if (tenDangNhapCoTonTai(username)) {
                break;
            } else if (i > 4) {
                System.out.println("So lan nhap lon hon 3. Da thoat!");
                return;

            } else {
                i++;
                System.out.println("Ten dang nhap khong ton tai, vui long nhap lai!");
                continue;
            }
        }

        System.out.println("Ban hoc truong nao?");
        int j = 0;
        while (true) {
            System.out.print("Toi hoc truong: ");
            String securityQuestion = scanner.nextLine();

            String password = findPassword(username, securityQuestion);
            if (password != null) {
                System.out.println("Mat khau cua ban la: " + password);
                return;
            } else if (j == 4) {
                System.out.println("So lan nhap lon hon 3. Da thoat!");
                return;

            } else {
                System.out.println("Cau hoi bao mat khong chinh xac.");
                j++;
                continue;
            }

        }
    }
// tim mat khau de lay lai mat khau

    @Override
    public  String findPassword(String username, String securityQuestion) {
        File file = new File("users.txt");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split(", ");

                String storedUsername = userData[0];
                String password = userData[1];
                String storedSecurityQuestion = userData[2];

                if (storedUsername.equals(username) && storedSecurityQuestion.equalsIgnoreCase(securityQuestion)) {
                    scanner.close();
                    return password;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public  void thayDoiMatKhau() {
        scanner.nextLine();
        while (true) {
            System.out.print("Nhap ten tai khoan: ");
            String username = scanner.nextLine();
            if (tenDangNhapCoTonTai(username)) {
                System.out.print("Nhap mat khau hien tai: ");
                String currentPassword = scanner.nextLine();
                if (kiemTraMatKhau(username, currentPassword)) {
                    System.out.print("Nhap mat khau moi: ");
                    String newPassword = scanner.nextLine();
                    if (newPassword.length() >= 6 && newPassword.length() <= 12) {
                        System.out.print("Nhap lai mat khau: ");
                        String passwordB = scanner.nextLine();
                        if (newPassword.equals(passwordB)) {
                            boolean success = changePassword(username, currentPassword, newPassword);
                            if (success) {
                                System.out.println("Da thay doi mat khau thanh cong.");
                                return;
                            } else {
                                System.out.println("Thay doi mat khau that bai. Vui long kiem tra lai thong tin nhap vao.");
                                continue;
                            }
                        } else {
                            System.out.println("Mat khau khong khop, vui long nhap lai!");
                            continue;
                        }
                    } else {
                        System.out.println("Mat khau phai lon hon 6 va be hon 12, vui long nhap lai!");
                        continue;
                    }
                } else {
                    System.out.println("Mat khau hien tai khong chinh xac, vui long nhap lai!");
                    continue;
                }
            } else {
                System.out.println("Ten tai khoan khong ton tai, vui long nhap lai!");
                continue;
            }
        }
    }    // tim mat khau de doi

    @Override
    public  boolean kiemTraMatKhau(String username, String Password) {
        File file = new File("users.txt");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split(", ");

                String storedUsername = userData[0];
                String password = userData[1];

                if (storedUsername.equals(username) && password.equalsIgnoreCase(Password)) {
                    scanner.close();
                    return true;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public  boolean changePassword(String username, String currentPassword, String newPassword) {
        File inputFile = new File("users.txt");
        File tempFile = new File("temp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(", ");

                String storedUsername = userData[0];
                String storedPassword = userData[1];

                if (storedUsername.equals(username) && storedPassword.equals(currentPassword)) {
                    writer.write(storedUsername + ", " + newPassword);
                    for (int i = 2; i < userData.length; i++) {
                        writer.write(", " + userData[i]);
                    }
                    found = true;
                } else {
                    writer.write(line);
                }

                writer.newLine();
            }

            reader.close();
            writer.close();

            if (found) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void RunDangKyDangNhap() throws FileNotFoundException, IOException {
        while (true) {
            System.out.println("---------- MENU ----------");
            System.out.println("1. Dang ky");
            System.out.println("2. Dang nhap");
            System.out.println("3. Lay lai mat khau");
            System.out.println("4. Thay doi mat khau");
            System.out.println("0. Thoat");
            System.out.print("Chon mot lua chon: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dangKy();
                    break;
                case 2:
                    dangNhap();
                    break;
                case 3:
                    layLaiMatKhau();
                    break;
                case 4:
                    thayDoiMatKhau();
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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DangKyVaDangNhap dkvdn = new DangKyVaDangNhap();
        dkvdn.RunDangKyDangNhap();
    }

}
