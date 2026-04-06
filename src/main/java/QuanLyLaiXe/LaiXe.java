package QuanLyLaiXe;

import java.io.Serializable;

public class LaiXe implements Serializable {
    private static int AUTO_ID = 10000;

    private int maLX;
    private String hoTen, diaChi, sdt, trinhDo;

    public LaiXe(String hoTen, String diaChi, String sdt, String trinhDo) {
        this.maLX = AUTO_ID++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trinhDo = trinhDo;
    }

    public int getMaLX() { return maLX; }
    public String getHoTen() { return hoTen; }

    @Override
    public String toString() {
        return maLX + " | " + hoTen + " | " + trinhDo;
    }
}