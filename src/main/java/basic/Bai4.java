package basic;

import java.util.Scanner;

public class Bai4 {
    public static int gcd(int a, int b) {
        // Euclidean algorithm for GCD
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số a: ");
        int a = sc.nextInt();
        System.out.print("Nhập số b: ");
        int b = sc.nextInt();

        // Validate input
        if (a > b) {
            System.out.println("Lỗi: a phải nhỏ hơn hoặc bằng b!");
            sc.close();
            return;
        }

        if (a <= 0 || b <= 0) {
            System.out.println("Lỗi: a và b phải là số nguyên dương!");
            sc.close();
            return;
        }

        System.out.println("Các cặp số nguyên tố cùng nhau trong đoạn [" + a + ", " + b + "]:");
        boolean found = false;

        for (int i = a; i <= b; i++) {
            for (int j = i + 1; j <= b; j++) {
                if (gcd(i, j) == 1) {
                    System.out.println("(" + i + ", " + j + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Không có cặp số nguyên tố cùng nhau nào trong đoạn này!");
        }

        sc.close();
    }
}