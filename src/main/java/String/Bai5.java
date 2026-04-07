package String;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ho ten: ");
        String s = sc.nextLine().trim();

        // Kiểm tra chuỗi rỗng
        if (s.isEmpty()) {
            System.out.println("Chuoi rong!");
            return;
        }

        String[] parts = s.split("\\s+");

        // Nếu chỉ có 1 từ
        if (parts.length == 1) {
            System.out.println("Ket qua: " + parts[0]);
            return;
        }

        String ten = parts[parts.length - 1]; // tên

        StringBuilder result = new StringBuilder();
        result.append(ten).append(" ");

        // họ + đệm
        for (int i = 0; i < parts.length - 1; i++) {
            result.append(parts[i]).append(" ");
        }

        System.out.println("Ket qua: " + result.toString().trim());
    }
}