
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {

    public static void main(String[] args) throws IOException {
     updateValue("A", "slPhoThong", "2");
    }

    public static void updateValue(String maChuyenBay, String key, String value) throws IOException {
        Path filePath = Paths.get("D:\\DO_AN\\OOP\\QLBanVeMayBay\\chuyenBay.txt");

        // Đọc tất cả các dòng trong tệp
        String content = Files.readString(filePath);
        // Tách các cặp key=value thành một mảng các cặp
        String[] pairs = content.split(",");
        for (int i = 0; i < pairs.length; i++) {
            String[] keyValue = pairs[i].split("=");
            if (keyValue.length == 2 && keyValue[0].equals(key) && keyValue[1].equals(maChuyenBay)) {
                // Tìm thấy cặp key=value phù hợp, thay đổi giá trị
                pairs[i] = key + "=" + value;
                break;
            }
        }
        // Ghi lại nội dung đã được cập nhật vào tệp
        String updatedContent = String.join(",", pairs);
        Files.write(filePath, updatedContent.getBytes());
    }

}
