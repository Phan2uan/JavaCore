package QuanLyLaiXe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BangPhanCong implements Serializable {
    private LaiXe laiXe;
    private List<PhanCongChiTiet> ds = new ArrayList<>();

    public BangPhanCong(LaiXe laiXe) {
        this.laiXe = laiXe;
    }

    public LaiXe getLaiXe() { return laiXe; }

    public void them(Tuyen tuyen, int soLuot) {
        // ❌ Không trùng tuyến
        for (PhanCongChiTiet pc : ds) {
            if (pc.getTuyen().getMaTuyen() == tuyen.getMaTuyen()) {
                System.out.println("Trùng tuyến!");
                return;
            }
        }

        // ❌ Tổng lượt <= 15
        int tong = ds.stream()
                .mapToInt(PhanCongChiTiet::getSoLuot)
                .sum();

        if (tong + soLuot > 15) {
            System.out.println("Quá 15 lượt!");
            return;
        }

        ds.add(new PhanCongChiTiet(tuyen, soLuot));
    }

    public int soTuyen() {
        return ds.size();
    }

    public double tongKm() {
        return ds.stream()
                .mapToDouble(x -> x.getTuyen().getKhoangCach() * x.getSoLuot())
                .sum();
    }

    @Override
    public String toString() {
        return laiXe.getHoTen() + " | Số tuyến: " + soTuyen();
    }

    public List<PhanCongChiTiet> getDs() {
        return ds;
    }
}