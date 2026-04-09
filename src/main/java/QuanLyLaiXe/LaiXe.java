package QuanLyLaiXe;

import java.io.Serializable;

public class LaiXe implements Serializable {
    private static int AUTO_ID = 10000;
    private int maLX;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String trinhDo; // A, B, C, D, E, F

    public LaiXe(String hoTen, String diaChi, String sdt, String trinhDo) {
        this.maLX = AUTO_ID++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trinhDo = trinhDo;
    }

    // Constructor dùng khi đọc file
    public LaiXe(int maLX, String hoTen, String diaChi, String sdt, String trinhDo) {
        this.maLX = maLX;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trinhDo = trinhDo;
    }

    public int getMaLX() { return maLX; }
    public String getHoTen() { return hoTen; }
    public String getTrinhDo() { return trinhDo; }

    public static void capNhatAutoId(int maxId) {
        if (maxId >= AUTO_ID) AUTO_ID = maxId + 1;
    }

    @Override
    public String toString() {
        return maLX + " | " + hoTen + " | " + diaChi + " | " + sdt + " | " + trinhDo;
    }
}