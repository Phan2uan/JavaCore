package String;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi s1: ");
        String s1 = sc.nextLine();

        System.out.print("Nhap chuoi s2: ");
        String s2 = sc.nextLine();

        // Tránh vòng lặp vô hạn nếu s2 rỗng
        if (s2.isEmpty()) {
            System.out.println("s2 rong, khong the xu ly!");
            return;
        }

        // Xóa lặp lại
        while (s1.contains(s2)) {
            s1 = s1.replace(s2, "");
        }

        System.out.println("Chuoi sau khi xoa: " + s1);
    }
}