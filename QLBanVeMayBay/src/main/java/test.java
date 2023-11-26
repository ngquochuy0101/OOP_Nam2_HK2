
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {

    public static void main(String[] args) {
        String filePath = "D:\\DO_AN\\OOP\\QLBanVeMayBay\\chuyenBay.txt";
        String[] lines = new String[5]; // Kích thước ban đầu của mảng

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                if (index == lines.length) {
                    // Mở rộng mảng khi cần thiết
                    String[] newLines = new String[lines.length * 2];
                    System.arraycopy(lines, 0, newLines, 0, lines.length);
                    lines = newLines;
                }
                lines[index] = line;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // In ra màn hình
        for (String line : lines) {
            if (line != null) {
                String keyToFind = "giohacanh";

                String giohacanhValue = getValueByKey(line, keyToFind);

                if (giohacanhValue != null) {
                    System.out.println("Giá trị của " + keyToFind + ": " + giohacanhValue);
                } else {
                    System.out.println("Không tìm thấy giá trị cho " + keyToFind);
                }
            }
        }

    }

    public static String getValueByKey(String inputString, String key) {
        String[] parts = inputString.split(",");

        for (String part : parts) {
            String[] keyValue = part.split("=");

            if (keyValue.length > 1) {
                String currentKey = keyValue[0].trim();
                String currentValue = keyValue[1].trim();

                if (currentKey.equals(key)) {
                    return currentValue;
                }
            }
        }

        return null; // Trả về null nếu không tìm thấy key trong chuỗi
    }
}
