package QuanLyLaiXe;

import java.io.Serializable;

public class Tuyen implements Serializable {
    private static int AUTO_ID = 100;
    private int maTuyen;
    private double khoangCach;
    private int soDiemDung;

    public Tuyen(double khoangCach, int soDiemDung) {
        if (khoangCach <= 0 || soDiemDung <= 0) {
            throw new IllegalArgumentException("Khoảng cách và số điểm dừng phải > 0");
        }
        this.maTuyen = AUTO_ID++;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public Tuyen(int maTuyen, double khoangCach, int soDiemDung) {
        this.maTuyen = maTuyen;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public int getMaTuyen() { return maTuyen; }
    public double getKhoangCach() { return khoangCach; }
    public int getSoDiemDung() { return soDiemDung; }

    public static void capNhatAutoId(int maxId) {
        if (maxId >= AUTO_ID) AUTO_ID = maxId + 1;
    }

    @Override
    public String toString() {
        return maTuyen + " | " + khoangCach + " km | " + soDiemDung + " điểm dừng";
    }
}