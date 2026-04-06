/*
Bài 4: Viết chương trình in ra các cặp số nguyên tố cùng nhau trong đoạn [a,b]. Với a,b nhập từ
bàn phím.
*/
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
        int a, b;

        // Nhập an toàn số nguyên dương
        while (true) {
            System.out.print("Nhập số a: ");
            if (sc.hasNextInt()) {
                a = sc.nextInt();
                if (a > 0) break;
                else System.out.println("a phải là số nguyên dương!");
            } else {
                System.out.println("Sai định dạng! Nhập số nguyên.");
                sc.next();
            }
        }

        while (true) {
            System.out.print("Nhập số b: ");
            if (sc.hasNextInt()) {
                b = sc.nextInt();
                if (b >= a) break;
                else System.out.println("b phải >= a!");
            } else {
                System.out.println("Sai định dạng! Nhập số nguyên.");
                sc.next();
            }
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