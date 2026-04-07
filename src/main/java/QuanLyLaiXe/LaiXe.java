package QuanLyLaiXe;

import java.io.Serializable;

public class LaiXe implements Serializable {
    private static int AUTO_ID = 10000;

    // NOTE (đối chiếu đề bài): mã LX là số nguyên 5 chữ số, tự động tăng.
    // AUTO_ID=10000 và maLX=AUTO_ID++ => mã đầu tiên là 10000.
    // Nếu có lưu/đọc file (ObjectOutputStream) thì khi load dữ liệu cần đồng bộ AUTO_ID theo mã lớn nhất
    // để tránh trùng mã khi chạy lại chương trình.

    private int maLX;
    private String hoTen, diaChi, sdt, trinhDo;

    // NOTE (đối chiếu đề bài): Trình độ lái xe chỉ được chọn trong Loại A..Loại F.
    // Hiện tại đang lưu String => nên validate A/B/C/D/E/F hoặc chuyển sang enum để tránh nhập sai.

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
        // NOTE: toString hiện chưa in địa chỉ, SĐT.
        // Nếu đề yêu cầu in đầy đủ danh sách lái xe (mã, họ tên, địa chỉ, SĐT, trình độ) thì cần bổ sung.
        return maLX + " | " + hoTen + " | " + trinhDo;
    }
}