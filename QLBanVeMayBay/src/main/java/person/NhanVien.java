package Do_An_OOP_Nam2_HK2.QLBanVeMayBay.src.main.java.person;

class NhanVien extends ConNguoi {
    private int maNV;
    private String[][] dsnv = new String[100][5];
    
    public int getMaNV() {
        return maNV;
    }
    
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    
    public void nhapDS() {
        for (int x = 0; x<100; x++) {
            if (dsnv[x][0] == null) {
                System.out.println("Nhap thong tin nhan vien voi ma so " + x+1 + " hoac Thoat (phim 1): ");
                String answer = sc.nextLine();
                if (answer != "1") {
                    super.nhapTT();
                    dsnv[x][0] = String.valueOf(x);
                    dsnv[x][1] = super.getHoTen();
                    dsnv[x][2] = super.getSDT();
                    dsnv[x][3] = super.getCCCD();
                    dsnv[x][4] = super.getNgaySinh();
                } else break;
            }
        }
    }

    public void xuatTT() {
        System.out.println("Nhap ma so nhan vien: ");
        int x = sc.nextInt();
        if (dsnv[x][0] != null) {
            System.out.println("Ma so nhan vien: " + dsnv[x][0]);
            System.out.println("Ho ten nhan vien: " + dsnv[x][1]);
            System.out.println("So dien thoai nhan vien: " + dsnv[x][2]);
            System.out.println("CCCD nhan vien: " + dsnv[x][3]);
            System.out.println("Ngay sinh nhan vien: " + dsnv[x][4]);
        } else System.out.println("Khong ton tai nhan vien.");
    }
}