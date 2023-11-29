
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class test {

    public static void main(String[] args) {
        String filePath = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\chuyenBay.txt"; // Đường dẫn đến tệp tin chuyenBay.txt

        try {
            String[][] data = readDataFromFile(filePath);

            // In ra các giá trị sau dấu bằng trong mảng
            int i=0;
            for (String[] row : data) {
                for (String value : row) {
                    String trimmedValue = getValueAfterEqualSign(value);
                    System.out.print(trimmedValue +" "+ i++ +" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[][] readDataFromFile(String filePath) throws IOException {
        // Đọc nội dung của tệp tin
        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        // Tách các dòng dữ liệu bằng ký tự xuống dòng "\n"
        String[] lines = content.split("\n");

        // Tạo mảng hai chiều để lưu trữ dữ liệu
        String[][] data = new String[lines.length][];

        // Duyệt qua từng dòng dữ liệu
        for (int i = 0; i < lines.length; i++) {
            // Tách các giá trị trong dòng bằng dấu phẩy ","
            String[] values = lines[i].split(",");

            // Lưu trữ dữ liệu vào mảng hai chiều
            data[i] = values;
        }

        return data;
    }

    public static String getValueAfterEqualSign(String input) {
        int equalSignIndex = input.indexOf("=");
        if (equalSignIndex != -1 && equalSignIndex < input.length() - 1) {
            return input.substring(equalSignIndex + 1).trim();
        }
        return input;
    }
}
