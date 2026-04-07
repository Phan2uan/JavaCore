package QuanLyLaiXe;

import java.io.Serializable;

public class Tuyen implements Serializable {
    private static int AUTO_ID = 100;

    // NOTE (đối chiếu đề bài): mã tuyến là số nguyên có 3 chữ số, tự động tăng.
    // AUTO_ID=100 và maTuyen=AUTO_ID++ => mã đầu tiên là 100 (đúng 3 chữ số).
    // Nếu có lưu/đọc file thì cần đồng bộ AUTO_ID theo mã tuyến lớn nhất để tránh trùng.

    private int maTuyen;
    private double khoangCach;
    private int soDiemDung;

    // NOTE (đối chiếu đề bài): khoảng cách và số điểm dừng nên được validate (>0).
    // Hiện tại constructor không kiểm tra dữ liệu đầu vào.

    public Tuyen(double khoangCach, int soDiemDung) {
        this.maTuyen = AUTO_ID++;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public int getMaTuyen() { return maTuyen; }
    public double getKhoangCach() { return khoangCach; }

    @Override
    public String toString() {
        // NOTE: toString đã in đủ mã tuyến + khoảng cách + số điểm dừng (phù hợp để hiển thị danh sách tuyến).
        return maTuyen + " | " + khoangCach + " km | " + soDiemDung;
    }
}