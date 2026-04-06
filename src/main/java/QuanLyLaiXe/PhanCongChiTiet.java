package QuanLyLaiXe;

import java.io.Serializable;

public class PhanCongChiTiet implements Serializable {
    private Tuyen tuyen;
    private int soLuot;

    public PhanCongChiTiet(Tuyen tuyen, int soLuot) {
        this.tuyen = tuyen;
        this.soLuot = soLuot;
    }

    public Tuyen getTuyen() { return tuyen; }
    public int getSoLuot() { return soLuot; }
}