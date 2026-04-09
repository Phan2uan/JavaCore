package QuanLyDiem;

import java.io.*;
import java.util.Scanner;

abstract class Nguoi {
    protected String hoTen;
    protected String diaChi;
    protected String soDT;
    public Nguoi(String hoTen, String diaChi, String soDT) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }
    public abstract void hienThi();
}

class SinhVien extends Nguoi {
    private static int AUTO_ID = 10000;
    private int maSV;
    private String lop;
    public SinhVien(String hoTen, String diaChi, String soDT, String lop) {
        super(hoTen, diaChi, soDT);
        this.maSV = AUTO_ID++;
        this.lop = lop;
    }
    public SinhVien(int maSV, String hoTen, String diaChi, String soDT, String lop) {
        super(hoTen, diaChi, soDT);
        this.maSV = maSV;
        this.lop = lop;
    }
    public int getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public String getLop() { return lop; }
    public static void capNhatAutoId(int maxId) { if (maxId >= AUTO_ID) AUTO_ID = maxId + 1; }
    @Override
    public void hienThi() {
        System.out.println(maSV + " | " + hoTen + " | " + diaChi + " | " + soDT + " | " + lop);
    }
}

enum LoaiMon { DAI_CUONG, CO_SO_NGANH, CHUYEN_NGANH }

class MonHoc {
    private static int AUTO_ID = 100;
    private int maMon;
    private String tenMon;
    private int soTinChi;
    LoaiMon loai;
    public MonHoc(String tenMon, int soTinChi, LoaiMon loai) {
        this.maMon = AUTO_ID++;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.loai = loai;
    }
    public MonHoc(int maMon, String tenMon, int soTinChi, LoaiMon loai) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.loai = loai;
    }
    public int getMaMon() { return maMon; }
    public String getTenMon() { return tenMon; }
    public int getSoTinChi() { return soTinChi; }
    public static void capNhatAutoId(int maxId) { if (maxId >= AUTO_ID) AUTO_ID = maxId + 1; }
    public void hienThi() {
        System.out.println(maMon + " | " + tenMon + " | TC: " + soTinChi + " | " + loai);
    }
}

class BangDiem {
    private SinhVien sv;
    private MonHoc mon;
    private double diem;
    public BangDiem(SinhVien sv, MonHoc mon, double diem) {
        this.sv = sv;
        this.mon = mon;
        this.diem = diem;
    }
    public SinhVien getSv() { return sv; }
    public MonHoc getMon() { return mon; }
    public double getDiem() { return diem; }
    public void hienThi() {
        System.out.println(sv.getHoTen() + " | " + mon.getTenMon() + " | " + diem);
    }
}

public class QuanLyDiemSinhVien {
    static Scanner sc = new Scanner(System.in);
    static SinhVien[] dsSV = new SinhVien[10];
    static MonHoc[] dsMH = new MonHoc[10];
    static BangDiem[] dsBD = new BangDiem[10];
    static int nSV = 0, nMH = 0, nBD = 0;

    public static void main(String[] args) {
        docFile();
        while (true) {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Nhập sinh viên");
            System.out.println("2. Nhập môn học");
            System.out.println("3. Nhập bảng điểm (nhiều lần)");
            System.out.println("4. Sắp xếp bảng điểm");
            System.out.println("5. Tính điểm trung bình");
            System.out.println("6. Ghi file");
            System.out.println("7. Đọc file (tải lại từ đĩa)");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int chon = nhapSo();
            switch (chon) {
                case 1: nhapSV(); break;
                case 2: nhapMH(); break;
                case 3: nhapBD(); break;
                case 4: sapXep(); break;
                case 5: tinhTB(); break;
                case 6: ghiFile(); break;
                case 7: docFile(); break;
                case 0:
                    System.out.println("Tạm biệt!");
                    return;
                default: System.out.println("Chọn số từ 0 đến 7!");
            }
        }
    }

    static int nhapSo() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Nhập lại số: ");
            }
        }
    }

    static void moRongMang(Object[] arr, int size) {
        if (size >= arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            if (arr instanceof SinhVien[]) dsSV = (SinhVien[]) newArr;
            else if (arr instanceof MonHoc[]) dsMH = (MonHoc[]) newArr;
            else if (arr instanceof BangDiem[]) dsBD = (BangDiem[]) newArr;
        }
    }

    static void nhapSV() {
        System.out.print("Số lượng sinh viên cần nhập: ");
        int n = nhapSo();
        for (int i = 0; i < n; i++) {
            System.out.println("\nSinh viên thứ " + (i + 1));
            System.out.print("Họ tên: "); String ten = sc.nextLine();
            System.out.print("Địa chỉ: "); String dc = sc.nextLine();
            System.out.print("SĐT: "); String sdt = sc.nextLine();
            System.out.print("Lớp: "); String lop = sc.nextLine();
            moRongMang(dsSV, nSV + 1);
            dsSV[nSV++] = new SinhVien(ten, dc, sdt, lop);
        }
        System.out.println("\nDanh sách sinh viên hiện tại:");
        for (int i = 0; i < nSV; i++) dsSV[i].hienThi();
    }

    static void nhapMH() {
        System.out.print("Số lượng môn học cần nhập: ");
        int n = nhapSo();
        for (int i = 0; i < n; i++) {
            System.out.println("\nMôn thứ " + (i + 1));
            System.out.print("Tên môn: "); String ten = sc.nextLine();
            System.out.print("Số tín chỉ: "); int tc = nhapSo();
            System.out.println("Loại môn: 1.Đại cương  2.Cơ sở ngành  3.Chuyên ngành");
            int chon = nhapSo();
            while (chon < 1 || chon > 3) { System.out.print("Chọn 1-3: "); chon = nhapSo(); }
            LoaiMon loai = LoaiMon.values()[chon - 1];
            moRongMang(dsMH, nMH + 1);
            dsMH[nMH++] = new MonHoc(ten, tc, loai);
        }
        System.out.println("\nDanh sách môn học hiện tại:");
        for (int i = 0; i < nMH; i++) dsMH[i].hienThi();
    }

    static void nhapBD() {
        if (nSV == 0 || nMH == 0) {
            System.out.println("Chưa có sinh viên hoặc môn học, không thể nhập điểm!");
            return;
        }
        while (true) {
            System.out.println("\n--- NHẬP ĐIỂM ---");
            System.out.println("Chọn sinh viên (nhập mã SV) hoặc 0 để thoát:");
            for (int i = 0; i < nSV; i++) {
                System.out.println(dsSV[i].getMaSV() + " - " + dsSV[i].getHoTen());
            }
            int maSV = nhapSo();
            if (maSV == 0) { System.out.println("Kết thúc nhập bảng điểm."); break; }
            SinhVien sv = null;
            for (int i = 0; i < nSV; i++) if (dsSV[i].getMaSV() == maSV) { sv = dsSV[i]; break; }
            if (sv == null) { System.out.println("Mã SV không tồn tại!"); continue; }

            System.out.println("Chọn môn học (nhập mã môn):");
            for (int i = 0; i < nMH; i++) {
                System.out.println(dsMH[i].getMaMon() + " - " + dsMH[i].getTenMon());
            }
            int maMon = nhapSo();
            MonHoc mon = null;
            for (int i = 0; i < nMH; i++) if (dsMH[i].getMaMon() == maMon) { mon = dsMH[i]; break; }
            if (mon == null) { System.out.println("Mã môn không tồn tại!"); continue; }

            // Kiểm tra trùng
            boolean found = false;
            for (int i = 0; i < nBD; i++) {
                if (dsBD[i].getSv() == sv && dsBD[i].getMon() == mon) {
                    System.out.println("Điểm đã tồn tại. Cập nhật? (1: Có, 0: Không)");
                    int upd = nhapSo();
                    if (upd == 1) {
                        System.out.print("Nhập điểm mới: ");
                        double newDiem = Double.parseDouble(sc.nextLine());
                        dsBD[i] = new BangDiem(sv, mon, newDiem);
                        System.out.println("Đã cập nhật.");
                    }
                    found = true;
                    break;
                }
            }
            if (found) continue;

            System.out.print("Nhập điểm (0-10): ");
            double d;
            while (true) {
                try {
                    d = Double.parseDouble(sc.nextLine());
                    if (d >= 0 && d <= 10) break;
                } catch (Exception e) {}
                System.out.print("Điểm không hợp lệ, nhập lại (0-10): ");
            }
            moRongMang(dsBD, nBD + 1);
            dsBD[nBD++] = new BangDiem(sv, mon, d);
            System.out.println("Đã thêm điểm thành công!");

            System.out.print("Tiếp tục nhập điểm? (1: Có, 0: Không): ");
            int tiep = nhapSo();
            if (tiep == 0) break;
        }
    }

    static void sapXep() {
        if (nBD == 0) { System.out.println("Chưa có bảng điểm!"); return; }
        System.out.println("Chọn cách sắp xếp:");
        System.out.println("1. Theo họ tên sinh viên");
        System.out.println("2. Theo tên môn học");
        int chon = nhapSo();
        for (int i = 0; i < nBD - 1; i++) {
            for (int j = i + 1; j < nBD; j++) {
                boolean canSwap = false;
                if (chon == 1) canSwap = dsBD[i].getSv().getHoTen().compareTo(dsBD[j].getSv().getHoTen()) > 0;
                else if (chon == 2) canSwap = dsBD[i].getMon().getTenMon().compareTo(dsBD[j].getMon().getTenMon()) > 0;
                if (canSwap) { BangDiem t = dsBD[i]; dsBD[i] = dsBD[j]; dsBD[j] = t; }
            }
        }
        System.out.println("Bảng điểm sau khi sắp xếp:");
        for (int i = 0; i < nBD; i++) dsBD[i].hienThi();
    }

    static void tinhTB() {
        if (nSV == 0) { System.out.println("Chưa có sinh viên!"); return; }
        System.out.println("Điểm trung bình (có trọng số tín chỉ):");
        for (int i = 0; i < nSV; i++) {
            double tongDiem = 0, tongTC = 0;
            for (int j = 0; j < nBD; j++) {
                if (dsBD[j].getSv() == dsSV[i]) {
                    tongDiem += dsBD[j].getDiem() * dsBD[j].getMon().getSoTinChi();
                    tongTC += dsBD[j].getMon().getSoTinChi();
                }
            }
            if (tongTC > 0) System.out.printf("%d - %s: %.2f\n", dsSV[i].getMaSV(), dsSV[i].getHoTen(), tongDiem / tongTC);
            else System.out.printf("%d - %s: Chưa có điểm\n", dsSV[i].getMaSV(), dsSV[i].getHoTen());
        }
    }

    static void ghiFile() {
        System.out.print("Ghi file sẽ ghi đè dữ liệu cũ. Tiếp tục? (1: Có, 0: Không): ");
        int ok = nhapSo();
        if (ok != 1) return;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"))) {
            bw.write("#SinhVien\n");
            for (int i = 0; i < nSV; i++)
                bw.write(dsSV[i].getMaSV() + "," + dsSV[i].getHoTen() + "," + dsSV[i].diaChi + "," + dsSV[i].soDT + "," + dsSV[i].getLop() + "\n");
            bw.write("#MonHoc\n");
            for (int i = 0; i < nMH; i++)
                bw.write(dsMH[i].getMaMon() + "," + dsMH[i].getTenMon() + "," + dsMH[i].getSoTinChi() + "," + dsMH[i].loai.name() + "\n");
            bw.write("#BangDiem\n");
            for (int i = 0; i < nBD; i++)
                bw.write(dsBD[i].getSv().getMaSV() + "," + dsBD[i].getMon().getMaMon() + "," + dsBD[i].getDiem() + "\n");
            System.out.println("Đã ghi file data.txt");
        } catch (IOException e) { System.out.println("Lỗi ghi file: " + e.getMessage()); }
    }

    static void docFile() {
        File f = new File("data.txt");
        if (!f.exists()) { System.out.println("Chưa có file dữ liệu, bắt đầu mới."); return; }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            dsSV = new SinhVien[10]; dsMH = new MonHoc[10]; dsBD = new BangDiem[10];
            nSV = nMH = nBD = 0;
            String line, section = "";
            int maxIdSV = 10000, maxIdMH = 100;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) { section = line; continue; }
                String[] parts = line.split(",");
                if (section.equals("#SinhVien") && parts.length == 5) {
                    int ma = Integer.parseInt(parts[0]);
                    moRongMang(dsSV, nSV + 1);
                    dsSV[nSV++] = new SinhVien(ma, parts[1], parts[2], parts[3], parts[4]);
                    if (ma > maxIdSV) maxIdSV = ma;
                } else if (section.equals("#MonHoc") && parts.length == 4) {
                    int ma = Integer.parseInt(parts[0]);
                    moRongMang(dsMH, nMH + 1);
                    dsMH[nMH++] = new MonHoc(ma, parts[1], Integer.parseInt(parts[2]), LoaiMon.valueOf(parts[3]));
                    if (ma > maxIdMH) maxIdMH = ma;
                } else if (section.equals("#BangDiem") && parts.length == 3) {
                    int maSV_ = Integer.parseInt(parts[0]), maMon_ = Integer.parseInt(parts[1]);
                    double diem = Double.parseDouble(parts[2]);
                    SinhVien sv = null; MonHoc mh = null;
                    for (int i = 0; i < nSV; i++) if (dsSV[i].getMaSV() == maSV_) { sv = dsSV[i]; break; }
                    for (int i = 0; i < nMH; i++) if (dsMH[i].getMaMon() == maMon_) { mh = dsMH[i]; break; }
                    if (sv != null && mh != null) {
                        moRongMang(dsBD, nBD + 1);
                        dsBD[nBD++] = new BangDiem(sv, mh, diem);
                    }
                }
            }
            SinhVien.capNhatAutoId(maxIdSV);
            MonHoc.capNhatAutoId(maxIdMH);
            System.out.println("Đã đọc file: " + nSV + " SV, " + nMH + " môn, " + nBD + " điểm.");
        } catch (Exception e) { System.out.println("Lỗi đọc file: " + e.getMessage()); }
    }
}