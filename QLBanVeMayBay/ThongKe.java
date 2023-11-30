/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.thongke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThongKe {
     public static void main(String[] args) throws IOException {
        // Đọc nội dung của tệp tin
        String content = new String(Files.readAllBytes(Paths.get("test.txt")));

        // Tách các dòng dữ liệu bằng ký tự xuống dòng "\n"
        String[] lines = content.split("\n");
        
        double tongDoanhThu=0.0;
        
        // Duyệt qua từng dòng dữ liệu
        for (int i = 0; i < lines.length; i++) {
            // Tách các giá trị trong dòng bằng dấu phẩy ","
            String[] values = lines[i].split(",");

            // Lấy giá trị của cột maChuyenBay
            String maChuyenBay = values[0];
            
            double doanhThu = tinhDoanhThu(values);
               
            
            // In thông tin của các chuyến bay
            System.out.printf(String.format(" %5s | %5s | %5s | %5s | %5s", maChuyenBay, values[1], values[2], values[25], values[26]));
            
            tongDoanhThu += doanhThu;
            System.out.println("doanh thu: "+ doanhThu);
            System.out.println("tong doanh thu:" + tongDoanhThu);
        }
    }
     
    private static double tinhDoanhThu(String[] values) {
    // Loại bỏ mọi ký tự không phải số từ chuỗi
    String slVePTStr = values[25].replaceAll("[^\\d.]", "");
    String slVeTGStr = values[26].replaceAll("[^\\d.]", "");
    String giaPTStr = values[23].replaceAll("[^\\d.]", "");
    String giaTGStr = values[24].replaceAll("[^\\d.]", "");

    // Chuyển đổi các chuỗi đã loại bỏ ký tự không phải số thành số nguyên
    int slVePT = Integer.parseInt(slVePTStr);
    int slVeTG = Integer.parseInt(slVeTGStr);
    int giaPT = Integer.parseInt(giaPTStr);
    int giaTG = Integer.parseInt(giaTGStr);

    return slVePT * giaPT + slVeTG * giaTG;
}

}
