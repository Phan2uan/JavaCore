/*
Bài 1:
b. Nhập số tự nhiên n từ bàn phím rồi tính tổng (lưu ý phép chia các số nguyên):
S = 1 + 1/2 + 1/3 + ... + 1/n
*/
package basic;

import java.util.Scanner;

public class Bai1b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Nhập n nguyên dương
        do {
            System.out.print("Nhập n (số nguyên dương): ");
            while (!sc.hasNextInt()) {
                System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
                sc.next();
                System.out.print("Nhập n (số nguyên dương): ");
            }
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Phải nhập n > 0!");
            }
        } while (n <= 0);

        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i; // ép kiểu double để tránh chia số nguyên
        }

        System.out.println("S = " + sum);
        sc.close();
    }
}