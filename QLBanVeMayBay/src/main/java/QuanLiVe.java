import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class QuanLiVe {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String targetUsername = scanner.nextLine();

        // Gọi hàm hiển thị thông tin
        hienthithongtin(targetUsername);

        // Gọi hàm hủy vé
        System.out.print("Enter ticket code to cancel: ");
        String maVeToCancel = scanner.nextLine();
        huyVe(targetUsername, maVeToCancel);

        // Close the scanner
        scanner.close();
    }

    public static void hienthithongtin(String targetUsername) throws IOException {
        // Sử dụng try-with-resources để tự động đóng tài nguyên
        try {
            // Đọc nội dung của tệp tin
            String content = new String(Files.readAllBytes(Paths.get("veChuyenBay.txt")));

            // Tách các dòng dữ liệu bằng ký tự xuống dòng "\n"
            String[] lines = content.split("\n");

            // Duyệt qua từng dòng dữ liệu
            for (int i = 0; i < lines.length; i++) {
                // Tách các giá trị trong dòng bằng dấu phẩy ","
                String[] values = lines[i].split(",");

                // Check if the username is in the current line
                boolean matchFound = false;
                for (String value : values) {
                    if (value.trim().startsWith("username:" + targetUsername)) {
                        matchFound = true;
                        break;
                    }
                }

                // If the username is found, display the information
                if (matchFound) {
                    // Extract relevant information
                    String maVe = getValue("Ma ve", values);
                    String sanBayCatCanh = getValue("San bay cat canh", values);
                    String sanBayHaCanh = getValue("San bay ha canh", values);
                    String maChuyenBay = getValue("Ma chuyen bay", values);
                    String tenHang = getValue("Ten hang", values);
                    String tongGiaTien = getValue("Tong gia tien", values);

                    // Xuất trạng thái từ dòng hiện tại
                    String status = getStatusFromLine(values);

                    // In thông tin
                    System.out.println("Username: " + targetUsername);
                    System.out.println("Ma ve: " + maVe);
                    System.out.println("San bay cat canh: " + sanBayCatCanh);
                    System.out.println("San bay ha canh: " + sanBayHaCanh);
                    System.out.println("Ma chuyen bay: " + maChuyenBay);
                    System.out.println("Ten hang: " + tenHang);
                    System.out.println("Tong gia tien: " + tongGiaTien);

                    // Display status only if it's found and valid
                    if (!"N/A".equals(status) && ("0".equals(status) || "1".equals(status))) {
                        System.out.println("Trang thai: " + ("1".equals(status) ? "Da mua" : "Da huy ve"));
                    }

                    // Xuống dòng giữa các vé
                    System.out.println();
                }
            }
        } catch (IOException e) {
            // Xử lý IOException nếu có
            e.printStackTrace();
        }
    }

   public static void huyVe(String targetUsername, String maVeToCancel) throws IOException {
    try {
        // Đọc nội dung của tệp tin
        String path = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\veChuyenBay.txt";

        String content = new String(Files.readAllBytes(Paths.get("veChuyenBay.txt")));

        // Tách các dòng dữ liệu bằng ký tự xuống dòng "\n"
        String[] lines = content.split("\n");

        // Tạo một StringBuilder để xây dựng nội dung mới của tệp tin
        StringBuilder newContent = new StringBuilder();

        // Duyệt qua từng dòng dữ liệu
        for (int i = 0; i < lines.length; i++) {
            // Tách các giá trị trong dòng bằng dấu phẩy ","
            String[] values = lines[i].split(",");

            // Check if the username is in the current line
            boolean matchFound = false;
            for (String value : values) {
                if (value.trim().startsWith("username:" + targetUsername)) {
                    matchFound = true;
                    break;
                }
            }

            // If the username is found, display the information
            if (matchFound) {
                // Kiểm tra nếu mã vé trùng khớp với vé cần hủy
                String maVe = getValue("Ma ve", values);
                if (maVe.equals(maVeToCancel)) {
                    System.out.println("Da huy ve co ma " + maVeToCancel);
                    values[values.length - 1] = "status:0"; // Thay đổi trạng thái thành 0
                }
            }

            // Xây dựng lại dòng dữ liệu từ các giá trị đã được cập nhật
            String updatedLine = String.join(",", values);

            // Thêm dòng hiện tại vào newContent
            newContent.append(updatedLine).append("\n");
        }

        // Ghi nội dung mới vào tệp tin
        Files.write(Paths.get("veChuyenBay.txt"), newContent.toString().getBytes(), StandardOpenOption.WRITE);

        // In thông tin vé sau khi hủy
        System.out.println("Thong tin cac ve sau khi huy:");
        hienthithongtin(targetUsername);

        // Xuống dòng giữa các vé
        System.out.println();
    } catch (IOException e) {
        // Xử lý IOException nếu có
        e.printStackTrace();
    }
}
    public static String getStatusFromLine(String[] values) {
        for (String value : values) {
            if (value.trim().startsWith("status:")) {
                return value.trim().substring("status:".length());
            }
        }
        return "N/A";
    }

    public static String getValue(String key, String[] values) {
        for (String value : values) {
            if (value.trim().startsWith(key)) {
                return value.split(":")[1].trim();
            }
        }
        return "N/A";
    }
}
