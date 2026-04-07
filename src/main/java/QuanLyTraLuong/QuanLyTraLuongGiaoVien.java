package QuanLyTraLuong;

import java.util.Scanner;

/*
 * ============================
 * CLASS TRỪU TƯỢNG (ABSTRACT)
 * ============================
 * Dùng để thể hiện tính trừu tượng + đa hình
 */
abstract class Nguoi {
    protected String hoTen;
    protected String diaChi;
    protected String soDT;

    public Nguoi(String hoTen, String diaChi, String soDT) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    // phương thức trừu tượng (đa hình)
    public abstract void hienThi();
}

/*
 * ============================
 * ENUM TRÌNH ĐỘ
 * ============================
 */
enum TrinhDo {
    GS_TS, PGS_TS, GIANG_VIEN_CHINH, THAC_SI
}

/*
 * ============================
 * CLASS GIẢNG VIÊN
 * Kế thừa từ Nguoi
 * ============================
 */
class GiangVien extends Nguoi {
    private static int AUTO_ID = 100; // tự tăng ID

    // NOTE (đối chiếu đề bài): Mã GV yêu cầu là số nguyên có 3 chữ số, tự động tăng.
    // - AUTO_ID=100 và maGV=AUTO_ID++ => mã đầu tiên là 100 (đúng 3 chữ số).
    // - Nếu đề yêu cầu bắt đầu từ 101 hoặc 001 thì cần chỉnh.
    // - Nếu có lưu/đọc file thì cần đồng bộ AUTO_ID theo mã lớn nhất đã tồn tại để tránh trùng khi chạy lại.

    private int maGV;
    private TrinhDo trinhDo;

    public GiangVien(String hoTen, String diaChi, String soDT, TrinhDo trinhDo) {
        super(hoTen, diaChi, soDT); // gọi constructor cha
        this.maGV = AUTO_ID++;
        this.trinhDo = trinhDo;
    }

    public int getMaGV() {
        return maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    // override (đa hình)
    @Override
    public void hienThi() {
        System.out.println(maGV + " | " + hoTen + " | " + diaChi + " | " + soDT + " | " + trinhDo);
    }
}

/*
 * ============================
 * CLASS MÔN HỌC
 * ============================
 */
class MonHoc {
    private static int AUTO_ID = 100;

    // NOTE (đối chiếu đề bài): Mã môn học yêu cầu là số nguyên có 3 chữ số, tự động tăng.
    // AUTO_ID=100 và maMon=AUTO_ID++ => mã đầu tiên là 100 (đúng 3 chữ số).
    // Tương tự, nếu có lưu/đọc file thì cần đồng bộ AUTO_ID.

    private int maMon;
    private String tenMon;
    private int tongTiet;
    private int tietLyThuyet;
    private double kinhPhi;

    public MonHoc(String tenMon, int tongTiet, int tietLyThuyet, double kinhPhi) {
        this.maMon = AUTO_ID++;
        this.tenMon = tenMon;
        this.tongTiet = tongTiet;
        this.tietLyThuyet = tietLyThuyet;
        this.kinhPhi = kinhPhi;
    }

    public String getTenMon() {
        return tenMon;
    }

    public int getTongTiet() {
        return tongTiet;
    }

    public int getTietLyThuyet() {
        return tietLyThuyet;
    }

    public double getKinhPhi() {
        return kinhPhi;
    }

    // số tiết thực hành = tổng - lý thuyết
    public int getTietThucHanh() {
        return tongTiet - tietLyThuyet;
    }

    public void hienThi() {
        System.out.println(maMon + " | " + tenMon + " | " + tongTiet + " tiết");
    }
}

/*
 * ============================
 * CLASS BẢNG KÊ KHAI
 * ============================
 */
class BangKeKhai {
    private GiangVien gv;
    private MonHoc mon;
    private int soLop;

    public BangKeKhai(GiangVien gv, MonHoc mon, int soLop) {
        this.gv = gv;
        this.mon = mon;
        this.soLop = soLop;
    }

    public GiangVien getGv() {
        return gv;
    }

    public MonHoc getMon() {
        return mon;
    }

    public int getSoLop() {
        return soLop;
    }

    // tổng tiết = số tiết môn * số lớp
    public int getTongTiet() {
        return mon.getTongTiet() * soLop;
    }

    // tính tiền
    public double getTien() {
        // NOTE (đối chiếu đề bài): mức kinh phí là trả cho 1 tiết LÝ THUYẾT,
        // tiết THỰC HÀNH được trả 70% tiết lý thuyết.
        // Công thức bạn đang dùng phù hợp nếu:
        // - mon.getKinhPhi() là tiền/1 tiết LÝ THUYẾT,
        // - tietLyThuyet + tietThucHanh = tongTiet.
        // Thiếu validate: tietLyThuyet không được > tongTiet (nếu nhập sai sẽ ra số âm tiết thực hành).
        double tienLT = mon.getTietLyThuyet() * mon.getKinhPhi();
        double tienTH = mon.getTietThucHanh() * mon.getKinhPhi() * 0.7;
        return (tienLT + tienTH) * soLop;
    }

    public void hienThi() {
        System.out.println(gv.getHoTen() + " | " + mon.getTenMon() + " | lớp: " + soLop);
    }
}

/*
 * ============================
 * CLASS MAIN
 * ============================
 */
public class QuanLyTraLuongGiaoVien {

    static Scanner sc = new Scanner(System.in);

    // dùng MẢNG (đúng yêu cầu đề)
    static GiangVien[] dsGV = new GiangVien[100];
    static MonHoc[] dsMH = new MonHoc[100];
    static BangKeKhai[] dsBK = new BangKeKhai[100];

    // NOTE: Mảng đang fix cứng 100 phần tử.
    // - Nếu nhập vượt quá 100 GV/MH/BK sẽ dễ lỗi ArrayIndexOutOfBoundsException.
    // - Theo yêu cầu "không dùng Collection" vẫn có thể xử lý bằng cách kiểm tra trước khi thêm
    //   hoặc tự tăng kích thước mảng (copy sang mảng mới lớn hơn).

    static int nGV = 0, nMH = 0, nBK = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập môn học");
            System.out.println("2. Nhập giảng viên");
            System.out.println("3. Kê khai giảng dạy");
            System.out.println("4. Sắp xếp theo tên GV");
            System.out.println("5. Tính tiền");
            System.out.println("0. Thoát");

            // NOTE (đối chiếu đề bài): Mục (4) yêu cầu sắp xếp bảng kê khai theo:
            // a) Họ tên giảng viên
            // b) Số tiết giảng dạy mỗi môn (giảm dần)
            // Menu hiện tại mới có 1 lựa chọn sắp xếp theo tên GV, chưa có lựa chọn (4b).

            int chon = sc.nextInt();

            switch (chon) {
                case 1: nhapMonHoc(); break;
                case 2: nhapGiangVien(); break;
                case 3: keKhai(); break;
                case 4: sapXep(); break;
                case 5: tinhTien(); break;
                case 0: return;
            }
        }
    }

    /*
     * ============================
     * NHẬP MÔN HỌC
     * ============================
     */
    static void nhapMonHoc() {
        System.out.print("Số môn: ");
        int n = sc.nextInt(); sc.nextLine();

        // NOTE: Chưa kiểm tra nMH + n có vượt quá kích thước mảng dsMH hay không.
        // NOTE (exception): Dùng nextInt/nextDouble trực tiếp => nếu nhập sai kiểu sẽ InputMismatchException.
        // Bài trước có làm hàm nhập có try/catch (như nhapSo), ở đây chưa có.

        for (int i = 0; i < n; i++) {
            System.out.print("Tên môn: ");
            String ten = sc.nextLine();

            System.out.print("Tổng tiết: ");
            int tong = sc.nextInt();

            System.out.print("Tiết LT: ");
            int lt = sc.nextInt();

            // NOTE (đối chiếu đề): cần validate 0 <= lt <= tong, nếu lt > tong thì tiết thực hành sẽ âm.

            System.out.print("Kinh phí: ");
            double kp = sc.nextDouble(); sc.nextLine();

            dsMH[nMH++] = new MonHoc(ten, tong, lt, kp);
        }

        // in ra
        for (int i = 0; i < nMH; i++) {
            dsMH[i].hienThi();
        }
    }

    /*
     * ============================
     * NHẬP GIẢNG VIÊN
     * ============================
     */
    static void nhapGiangVien() {
        System.out.print("Số GV: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Tên: ");
            String ten = sc.nextLine();

            System.out.print("Địa chỉ: ");
            String dc = sc.nextLine();

            System.out.print("SĐT: ");
            String sdt = sc.nextLine();

            System.out.println("1.GS_TS 2.PGS_TS 3.GVC 4.ThS");
            int chon = sc.nextInt(); sc.nextLine();

            // NOTE: Chưa validate chon thuộc 1..4.
            // Nếu nhập khác 1..4 sẽ văng ArrayIndexOutOfBoundsException.
            TrinhDo td = TrinhDo.values()[chon - 1];

            dsGV[nGV++] = new GiangVien(ten, dc, sdt, td);
        }

        for (int i = 0; i < nGV; i++) {
            dsGV[i].hienThi();
        }
    }

    /*
     * ============================
     * KÊ KHAI
     * ============================
     */
    static void keKhai() {
        // NOTE (đối chiếu đề bài): Đề yêu cầu "lập bảng kê khai giảng dạy cho mỗi giảng viên" theo kiểu:
        // giảng viên khai báo dạy MÔN NÀO và BAO NHIÊU LỚP (mỗi môn có thể nhiều lớp).
        // Ở đây bạn đang duyệt toàn bộ nMH môn và bắt nhập số lớp cho từng môn => ép GV khai báo cho TẤT CẢ môn.
        // Cách đúng sát đề thường là: chọn 1 GV -> nhập số môn muốn kê khai -> chọn từng môn + số lớp.

        // NOTE: dsBK có kích thước 100, nhưng nBK tăng theo nGV * nMH.
        // Nếu có nhiều GV và nhiều môn, rất dễ tràn mảng dsBK.
        for (int i = 0; i < nGV; i++) {
            int tongTiet = 0;

            for (int j = 0; j < nMH; j++) {
                System.out.print(dsGV[i].getHoTen() + " dạy " +
                        dsMH[j].getTenMon() + " bao nhiêu lớp: ");

                int lop = sc.nextInt();

                // NOTE (đối chiếu đề): số lớp là số nguyên dương và không lớn hơn 3.
                // Hiện tại nếu lop <= 0 hoặc lop > 3 thì bạn đang "im lặng bỏ qua" (không báo lỗi, không nhập lại).

                // kiểm tra điều kiện đề bài
                if (lop > 0 && lop <= 3) {
                    int tiet = dsMH[j].getTongTiet() * lop;

                    if (tongTiet + tiet <= 200) {
                        dsBK[nBK++] = new BangKeKhai(dsGV[i], dsMH[j], lop);
                        tongTiet += tiet;
                    }

                    // NOTE (đối chiếu đề): tổng số tiết giảng dạy của 1 GV không > 200.
                    // Nếu vượt 200, code hiện tại chỉ bỏ qua (không tạo bản ghi) và không thông báo lý do.
                    // Nên in cảnh báo/cho nhập lại để người dùng biết bị vượt giới hạn.
                }
            }
        }

        // NOTE (đối chiếu yêu cầu 3): Sau khi lập bảng kê khai cần "in danh sách ra màn hình".
        // Hiện tại hàm keKhai() chưa in dsBK => Thiếu.
    }

    /*
     * ============================
     * SẮP XẾP THEO TÊN GV
     * ============================
     */
    static void sapXep() {
        // NOTE: Đây mới là sort theo họ tên giảng viên (đáp ứng 4a).
        // Thiếu 4b: sort theo số tiết giảng dạy mỗi môn (giảm dần).
        for (int i = 0; i < nBK - 1; i++) {
            for (int j = i + 1; j < nBK; j++) {

                if (dsBK[i].getGv().getHoTen()
                        .compareTo(dsBK[j].getGv().getHoTen()) > 0) {

                    BangKeKhai temp = dsBK[i];
                    dsBK[i] = dsBK[j];
                    dsBK[j] = temp;
                }
            }
        }

        for (int i = 0; i < nBK; i++) {
            dsBK[i].hienThi();
        }
    }

    /*
     * ============================
     * TÍNH TIỀN
     * ============================
     */
    static void tinhTien() {
        // NOTE (đối chiếu yêu cầu 5): Đề yêu cầu "tính toán và lập bảng tính tiền công cho mỗi giảng viên".
        // Hiện tại bạn chỉ in tổng tiền theo tên GV.
        // Thường cần in chi tiết theo từng môn (môn, số lớp, số tiết LT/TH, thành tiền) rồi tổng cộng.
        for (int i = 0; i < nGV; i++) {
            double tong = 0;

            for (int j = 0; j < nBK; j++) {
                if (dsBK[j].getGv() == dsGV[i]) {
                    tong += dsBK[j].getTien();
                }
            }

            System.out.println(dsGV[i].getHoTen() + " -> " + tong);
        }
    }
}