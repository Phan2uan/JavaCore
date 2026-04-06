package QuanLyLaiXe;

import java.io.Serializable;

public class Tuyen implements Serializable {
    private static int AUTO_ID = 100;

    private int maTuyen;
    private double khoangCach;
    private int soDiemDung;

    public Tuyen(double khoangCach, int soDiemDung) {
        this.maTuyen = AUTO_ID++;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public int getMaTuyen() { return maTuyen; }
    public double getKhoangCach() { return khoangCach; }

    @Override
    public String toString() {
        return maTuyen + " | " + khoangCach + " km | " + soDiemDung;
    }
}