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
    public List<PhanCongChiTiet> getDs() { return ds; }

    public boolean them(Tuyen tuyen, int soLuot) {
        // Kiểm tra trùng tuyến
        for (PhanCongChiTiet pc : ds) {
            if (pc.getTuyen().getMaTuyen() == tuyen.getMaTuyen()) {
                System.out.println("❌ Lái xe đã được phân công tuyến này rồi!");
                return false;
            }
        }
        // Tính tổng số lượt hiện tại
        int tongLuot = ds.stream().mapToInt(PhanCongChiTiet::getSoLuot).sum();
        if (tongLuot + soLuot > 15) {
            System.out.println("❌ Tổng số lượt vượt quá 15! (Hiện tại: " + tongLuot + ")");
            return false;
        }
        ds.add(new PhanCongChiTiet(tuyen, soLuot));
        return true;
    }

    public int soTuyen() {
        return ds.size();
    }

    public double tongKm() {
        return ds.stream().mapToDouble(pc -> pc.getTuyen().getKhoangCach() * pc.getSoLuot()).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(laiXe.getHoTen()).append(" (Mã: ").append(laiXe.getMaLX()).append(")\n");
        for (PhanCongChiTiet pc : ds) {
            sb.append("  ").append(pc).append("\n");
        }
        sb.append("  Tổng lượt: ").append(ds.stream().mapToInt(PhanCongChiTiet::getSoLuot).sum())
                .append(", Tổng km: ").append(tongKm());
        return sb.toString();
    }
}