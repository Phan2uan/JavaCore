package QuanLyLaiXe;

import java.util.*;

public class QuanLyPhanCongLaiXeBuyt {

    static List<LaiXe> dsLX = new ArrayList<>();
    static List<Tuyen> dsTuyen = new ArrayList<>();
    static List<BangPhanCong> dsPC = new ArrayList<>();

    // NOTE (đối chiếu yêu cầu kỹ thuật): Đề bài bài này CHO PHÉP dùng Collection và Java 8.
    // Dùng List/ArrayList + lambda/stream (ở BangPhanCong) => phù hợp.
    // Tuy nhiên đề cũng yêu cầu "dữ liệu được lưu vào file" và "xử lý exception" ở mức chương trình tổng thể,
    // hiện tại menu chưa có chức năng ghi/đọc file, nên chưa đáp ứng phần này.

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Nhập lái xe");
            System.out.println("2. Nhập tuyến");
            System.out.println("3. Phân công");
            System.out.println("4. Sắp xếp");
            System.out.println("5. Thống kê");
            System.out.println("0. Thoát");

            int chon = sc.nextInt();

            // NOTE (exception): Ở đây dùng nextInt() trực tiếp, nếu người dùng nhập sai kiểu sẽ InputMismatchException
            // và chương trình có thể dừng. Ở các chỗ khác bạn có try/catch, nên nên đồng bộ cách nhập.

            switch (chon) {
                case 1: nhapLX(); break;
                case 2: nhapTuyen(); break;
                case 3: phanCong(); break;
                case 4: sapXep(); break;
                case 5: thongKe(); break;
                case 0: return;
            }
        }
    }

    // ===== Nhập lái xe =====
    static void nhapLX() {
        System.out.print("Nhập số lượng lái xe: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập lái xe thứ " + (i + 1) + " ---");

            System.out.print("Họ tên: ");
            String ten = sc.nextLine();

            System.out.print("Địa chỉ: ");
            String dc = sc.nextLine();

            System.out.print("SĐT: ");
            String sdt = sc.nextLine();

            System.out.print("Trình độ (A-F): ");
            String td = sc.nextLine();

            // NOTE (đối chiếu đề bài): Trình độ lái xe được chọn trong Loại A..Loại F.
            // Hiện tại bạn nhận String tự do và không validate (A/B/C/D/E/F).
            // Nên validate hoặc dùng enum để tránh nhập sai.

            dsLX.add(new LaiXe(ten, dc, sdt, td));
        }

        System.out.println("\n===== DANH SÁCH LÁI XE =====");
        dsLX.forEach(System.out::println);
    }

    // ===== Nhập tuyến =====
    static void nhapTuyen() {
        System.out.print("Nhập số lượng tuyến: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập tuyến thứ " + (i + 1) + " ---");

            System.out.print("Khoảng cách (km): ");
            double kc = sc.nextDouble();

            System.out.print("Số điểm dừng: ");
            int d = sc.nextInt();

            dsTuyen.add(new Tuyen(kc, d));
        }

        System.out.println("\n===== DANH SÁCH TUYẾN =====");
        dsTuyen.forEach(System.out::println);
    }
    // ===== Phân công =====
    static void phanCong() {
        if (dsLX.isEmpty() || dsTuyen.isEmpty()) {
            System.out.println("⚠️ Cần nhập lái xe và tuyến trước!");
            return;
        }

        // NOTE (đối chiếu yêu cầu 3): Đề yêu cầu "nhập danh sách phân công cho mỗi lái xe".
        // Hiện tại hàm này mỗi lần chạy sẽ duyệt TẤT CẢ lái xe và tạo mới BangPhanCong cho từng người,
        // sau đó dsPC.add(b).
        // => Nếu gọi menu phân công nhiều lần, dsPC sẽ có NHIỀU bảng phân công trùng cho cùng 1 lái xe
        // (không kiểm tra đã tồn tại hay chưa), dễ lệch ý nghĩa "trong một ngày".
        // Thông thường nên: chọn 1 lái xe -> phân công cho lái xe đó, và/hoặc update bảng đã có.
        for (LaiXe lx : dsLX) {
            System.out.println("\n=================================");
            System.out.println("👉 Phân công cho lái xe: " + lx.getHoTen());

            BangPhanCong b = new BangPhanCong(lx);

            while (true) {
                // ===== In danh sách tuyến =====
                System.out.println("\n--- Danh sách tuyến ---");
                for (int i = 0; i < dsTuyen.size(); i++) {
                    System.out.println((i + 1) + ". " + dsTuyen.get(i));
                }

                // ===== Chọn tuyến =====
                System.out.print("Chọn tuyến (1-" + dsTuyen.size() + ", -1 để dừng): ");

                int chon;
                try {
                    chon = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("❌ Phải nhập số!");
                    sc.nextLine();
                    continue;
                }

                if (chon == -1) break;

                if (chon < 1 || chon > dsTuyen.size()) {
                    System.out.println("❌ Lựa chọn không hợp lệ!");
                    continue;
                }

                Tuyen t = dsTuyen.get(chon - 1);

                // ===== Nhập số lượt =====
                System.out.print("Nhập số lượt: ");
                int luot;

                try {
                    luot = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("❌ Phải nhập số!");
                    sc.nextLine();
                    continue;
                }

                if (luot <= 0) {
                    System.out.println("❌ Số lượt phải > 0!");
                    continue;
                }

                // ===== Thêm phân công =====
                b.them(t, luot);
            }

            dsPC.add(b);
        }

        // ===== In kết quả =====
        System.out.println("\n===== DANH SÁCH PHÂN CÔNG =====");
        for (BangPhanCong b : dsPC) {
            System.out.println("Lái xe: " + b.getLaiXe().getHoTen());

            for (PhanCongChiTiet pc : b.getDs()) {
                System.out.println("  Tuyến " + pc.getTuyen().getMaTuyen()
                        + " | Lượt: " + pc.getSoLuot());
            }
        }
    }
    // ===== Sắp xếp =====
    static void sapXep() {
        System.out.println("\n1. Theo tên lái xe");
        System.out.println("2. Theo số tuyến giảm dần");
        System.out.print("Chọn: ");

        int chon = sc.nextInt();

        if (chon == 1) {
            dsPC.sort(Comparator.comparing(x -> x.getLaiXe().getHoTen()));
        } else {
            dsPC.sort((a, b) -> b.soTuyen() - a.soTuyen());
        }

        // NOTE (đối chiếu đề bài mục 4):
        // - 4a Theo Họ tên lái xe: làm đúng.
        // - 4b Theo số lượng tuyến đảm nhận (giảm dần): làm đúng.
        // Gợi ý: nên validate người dùng chọn 1/2, hiện tại nhập khác 1 sẽ tự rơi vào nhánh else.

        System.out.println("\n===== SAU SẮP XẾP =====");
        dsPC.forEach(System.out::println);
    }

    // ===== Thống kê =====
    static void thongKe() {
        System.out.println("\n===== THỐNG KÊ TỔNG KM =====");

        // NOTE (đối chiếu đề bài mục 5): "kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe".
        // tongKm() đang tính tổng (khoảng cách tuyến * số lượt) theo từng bảng phân công => đúng ý.
        // Tuy nhiên nếu dsPC có nhiều bảng cho cùng 1 lái xe (do phân công nhiều lần), thống kê sẽ bị tách dòng
        // thay vì gộp theo lái xe.

        dsPC.forEach(x ->
                System.out.println(
                        "Lái xe: " + x.getLaiXe().getHoTen() +
                                " | Tổng km: " + x.tongKm()
                )
        );
    }
}