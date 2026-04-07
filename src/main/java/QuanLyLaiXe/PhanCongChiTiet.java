package QuanLyLaiXe;

import java.io.Serializable;

public class PhanCongChiTiet implements Serializable {
    private Tuyen tuyen;
    private int soLuot;

    // NOTE (đối chiếu đề bài): Với mỗi tuyến cần biết lái xe đó lái bao nhiêu lượt.
    // soLuot phải là số nguyên dương; việc validate hiện đang làm ở tầng nhập liệu (QuanLyPhanCongLaiXeBuyt).

    public PhanCongChiTiet(Tuyen tuyen, int soLuot) {
        this.tuyen = tuyen;
        this.soLuot = soLuot;
    }

    public Tuyen getTuyen() { return tuyen; }
    public int getSoLuot() { return soLuot; }

    // NOTE: Lớp này chưa override toString(), nên khi debug/in danh sách thường phải tự format ở nơi khác.
    // Có thể bổ sung toString() để in: mã tuyến | số lượt.
}