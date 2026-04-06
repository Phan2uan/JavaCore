package QuanLyLaiXe;

import java.util.*;

public class QuanLyPhanCongLaiXeBuyt {

    static List<LaiXe> dsLX = new ArrayList<>();
    static List<Tuyen> dsTuyen = new ArrayList<>();
    static List<BangPhanCong> dsPC = new ArrayList<>();

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

        System.out.println("\n===== SAU SẮP XẾP =====");
        dsPC.forEach(System.out::println);
    }

    // ===== Thống kê =====
    static void thongKe() {
        System.out.println("\n===== THỐNG KÊ TỔNG KM =====");

        dsPC.forEach(x ->
                System.out.println(
                        "Lái xe: " + x.getLaiXe().getHoTen() +
                                " | Tổng km: " + x.tongKm()
                )
        );
    }
}