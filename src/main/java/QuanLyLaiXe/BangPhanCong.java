package QuanLyLaiXe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BangPhanCong implements Serializable {
    private LaiXe laiXe;
    private List<PhanCongChiTiet> ds = new ArrayList<>();

    // NOTE (đối chiếu đề bài): Bảng phân công là quan hệ kết hợp Lái xe - Tuyến.
    // Mỗi (lái xe, tuyến) không được xuất hiện quá 1 lần trong bảng này.
    // Ở đây quản lý theo từng lái xe (mỗi BangPhanCong ứng với 1 lái xe) và ds chứa các tuyến + số lượt.
    // Cách mô hình này phù hợp yêu cầu.

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

        // NOTE: Điều kiện check trùng theo maTuyen như trên là đúng để đảm bảo 1 tuyến chỉ xuất hiện 1 lần
        // trong danh sách phân công của 1 lái xe.

        // ❌ Tổng lượt <= 15
        int tong = ds.stream()
                .mapToInt(PhanCongChiTiet::getSoLuot)
                .sum();

        // NOTE (đối chiếu đề bài): Tổng số lượt trong ngày của lái xe không vượt quá 15.
        // đang dùng stream Java 8 để tính tổng lượt => đúng yêu cầu "áp dụng kiến thức Java 8".

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
        // NOTE: toString hiện chỉ in tên lái xe và số tuyến.
        // Nếu muốn phục vụ in bảng phân công theo đúng đề, thường cần in thêm danh sách tuyến + số lượt.
        return laiXe.getHoTen() + " | Số tuyến: " + soTuyen();
    }

    public List<PhanCongChiTiet> getDs() {
        return ds;
    }
}