package QuanLyLaiXe;

import java.util.*;
import java.io.*;

public class QuanLyPhanCongLaiXeBuyt {
    static List<LaiXe> dsLX = new ArrayList<>();
    static List<Tuyen> dsTuyen = new ArrayList<>();
    static List<BangPhanCong> dsPC = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Tự động đọc file khi khởi động
        docFile();
        while (true) {
            System.out.println("\n========== MENU QUẢN LÝ ==========");
            System.out.println("1. Nhập lái xe");
            System.out.println("2. Nhập tuyến");
            System.out.println("3. Phân công (cho từng lái xe)");
            System.out.println("4. Sắp xếp bảng phân công");
            System.out.println("5. Thống kê tổng km mỗi lái xe");
            System.out.println("6. Ghi file");
            System.out.println("7. Đọc file (tải lại từ đĩa)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int chon = nhapSoNguyen();
            switch (chon) {
                case 1: nhapLX(); break;
                case 2: nhapTuyen(); break;
                case 3: phanCong(); break;
                case 4: sapXep(); break;
                case 5: thongKe(); break;
                case 6: ghiFile(); break;
                case 7: docFile(); break;
                case 0:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Chọn từ 0 đến 7!");
            }
        }
    }

    // Nhập số nguyên an toàn
    static int nhapSoNguyen() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Nhập lại số nguyên: ");
            }
        }
    }

    static double nhapSoThuc() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Nhập lại số thực: ");
            }
        }
    }

    // Nhập lái xe
    static void nhapLX() {
        System.out.print("Số lượng lái xe cần nhập: ");
        int n = nhapSoNguyen();
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Lái xe thứ " + (i + 1) + " ---");
            System.out.print("Họ tên: ");
            String ten = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String dc = sc.nextLine();
            System.out.print("SĐT: ");
            String sdt = sc.nextLine();
            String trinhDo;
            while (true) {
                System.out.print("Trình độ (A, B, C, D, E, F): ");
                trinhDo = sc.nextLine().toUpperCase();
                if (trinhDo.matches("[A-F]")) break;
                System.out.println("Chỉ nhập A, B, C, D, E, F!");
            }
            dsLX.add(new LaiXe(ten, dc, sdt, trinhDo));
        }
        System.out.println("\nDanh sách lái xe hiện tại:");
        dsLX.forEach(System.out::println);
    }

    // Nhập tuyến
    static void nhapTuyen() {
        System.out.print("Số lượng tuyến cần nhập: ");
        int n = nhapSoNguyen();
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Tuyến thứ " + (i + 1) + " ---");
            System.out.print("Khoảng cách (km): ");
            double kc = nhapSoThuc();
            while (kc <= 0) {
                System.out.print("Khoảng cách phải > 0, nhập lại: ");
                kc = nhapSoThuc();
            }
            System.out.print("Số điểm dừng: ");
            int diemDung = nhapSoNguyen();
            while (diemDung <= 0) {
                System.out.print("Số điểm dừng phải > 0, nhập lại: ");
                diemDung = nhapSoNguyen();
            }
            dsTuyen.add(new Tuyen(kc, diemDung));
        }
        System.out.println("\nDanh sách tuyến:");
        dsTuyen.forEach(System.out::println);
    }

    // Phân công: mỗi lần chọn 1 lái xe và phân công các tuyến cho người đó
    static void phanCong() {
        if (dsLX.isEmpty() || dsTuyen.isEmpty()) {
            System.out.println("Chưa có dữ liệu lái xe hoặc tuyến!");
            return;
        }
        // Chọn lái xe
        System.out.println("\nChọn lái xe (nhập mã lái xe):");
        dsLX.forEach(lx -> System.out.println(lx.getMaLX() + " - " + lx.getHoTen()));
        int ma = nhapSoNguyen();
        LaiXe lxChon = null;
        for (LaiXe lx : dsLX) {
            if (lx.getMaLX() == ma) {
                lxChon = lx;
                break;
            }
        }
        if (lxChon == null) {
            System.out.println("Không tìm thấy lái xe!");
            return;
        }

        // Tìm bảng phân công của lái xe này đã có chưa
        BangPhanCong bang = null;
        for (BangPhanCong b : dsPC) {
            if (b.getLaiXe().getMaLX() == lxChon.getMaLX()) {
                bang = b;
                break;
            }
        }
        if (bang == null) {
            bang = new BangPhanCong(lxChon);
            dsPC.add(bang);
        }

        System.out.println("Đang phân công cho: " + lxChon.getHoTen());
        while (true) {
            System.out.println("\n--- Danh sách tuyến ---");
            for (int i = 0; i < dsTuyen.size(); i++) {
                System.out.println((i + 1) + ". " + dsTuyen.get(i));
            }
            System.out.print("Chọn tuyến (nhập số thứ tự, 0 để kết thúc): ");
            int idx = nhapSoNguyen();
            if (idx == 0) break;
            if (idx < 1 || idx > dsTuyen.size()) {
                System.out.println("Số thứ tự không hợp lệ!");
                continue;
            }
            Tuyen t = dsTuyen.get(idx - 1);
            System.out.print("Số lượt (1-15): ");
            int luot = nhapSoNguyen();
            if (luot < 1 || luot > 15) {
                System.out.println("Số lượt phải từ 1 đến 15!");
                continue;
            }
            bang.them(t, luot);
        }
        System.out.println("Phân công hoàn tất.");
    }

    // Sắp xếp bảng phân công
    static void sapXep() {
        if (dsPC.isEmpty()) {
            System.out.println("Chưa có bảng phân công!");
            return;
        }
        System.out.println("Chọn cách sắp xếp:");
        System.out.println("1. Theo tên lái xe (tăng dần)");
        System.out.println("2. Theo số tuyến đảm nhận (giảm dần)");
        int chon = nhapSoNguyen();
        if (chon == 1) {
            dsPC.sort(Comparator.comparing(b -> b.getLaiXe().getHoTen()));
        } else if (chon == 2) {
            dsPC.sort((b1, b2) -> Integer.compare(b2.soTuyen(), b1.soTuyen()));
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }
        System.out.println("\n===== BẢNG PHÂN CÔNG ĐÃ SẮP XẾP =====");
        dsPC.forEach(System.out::println);
    }

    // Thống kê tổng km mỗi lái xe
    static void thongKe() {
        if (dsPC.isEmpty()) {
            System.out.println("Chưa có phân công!");
            return;
        }
        System.out.println("\n===== THỐNG KÊ TỔNG KM MỖI LÁI XE =====");
        for (BangPhanCong b : dsPC) {
            System.out.printf("Lái xe: %s (Mã: %d) - Tổng km: %.2f km\n",
                    b.getLaiXe().getHoTen(), b.getLaiXe().getMaLX(), b.tongKm());
        }
    }

    // Ghi file
    static void ghiFile() {
        System.out.print("Ghi file sẽ ghi đè dữ liệu cũ. Tiếp tục? (1: Có, 0: Không): ");
        int ok = nhapSoNguyen();
        if (ok != 1) return;
        try {
            FileUtil.write("laixe.dat", dsLX);
            FileUtil.write("tuyen.dat", dsTuyen);
            FileUtil.write("phanCong.dat", dsPC);
            System.out.println("Đã lưu dữ liệu vào file!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // Đọc file, đồng thời cập nhật AUTO_ID
    @SuppressWarnings("unchecked")
    static void docFile() {
        File f1 = new File("laixe.dat");
        File f2 = new File("tuyen.dat");
        File f3 = new File("phanCong.dat");
        if (!f1.exists() || !f2.exists() || !f3.exists()) {
            System.out.println("Chưa có file dữ liệu đầy đủ, bắt đầu với dữ liệu rỗng.");
            return;
        }
        try {
            List<LaiXe> listLX = FileUtil.read("laixe.dat");
            List<Tuyen> listTuyen = FileUtil.read("tuyen.dat");
            List<BangPhanCong> listPC = FileUtil.read("phanCong.dat");
            if (listLX != null) dsLX = listLX;
            if (listTuyen != null) dsTuyen = listTuyen;
            if (listPC != null) dsPC = listPC;

            // Cập nhật AUTO_ID cho LaiXe
            int maxMaLX = dsLX.stream().mapToInt(LaiXe::getMaLX).max().orElse(10000);
            LaiXe.capNhatAutoId(maxMaLX);
            // Cập nhật AUTO_ID cho Tuyen
            int maxMaTuyen = dsTuyen.stream().mapToInt(Tuyen::getMaTuyen).max().orElse(100);
            Tuyen.capNhatAutoId(maxMaTuyen);

            System.out.println("Đã đọc dữ liệu từ file: " + dsLX.size() + " lái xe, " + dsTuyen.size() + " tuyến, " + dsPC.size() + " bảng phân công.");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}