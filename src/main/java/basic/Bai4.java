/*
Bài 4: Viết chương trình in ra các cặp số nguyên tố cùng nhau trong đoạn [a,b]. Với a,b nhập từ
bàn phím.
*/
package basic;

import java.util.Scanner;

public class Bai4 {
    // Hàm tính UCLN (dùng thuật toán Euclid)
    public static int gcd(int a, int b) {
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

        // Nhập a (nguyên dương)
        do {
            System.out.print("Nhập a (số nguyên dương): ");
            while (!sc.hasNextInt()) {
                System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
                sc.next();
                System.out.print("Nhập a (số nguyên dương): ");
            }
            a = sc.nextInt();
            if (a <= 0) System.out.println("a phải lớn hơn 0!");
        } while (a <= 0);

        // Nhập b (phải >= a)
        do {
            System.out.print("Nhập b (b >= a): ");
            while (!sc.hasNextInt()) {
                System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
                sc.next();
                System.out.print("Nhập b (b >= a): ");
            }
            b = sc.nextInt();
            if (b < a) System.out.println("b phải lớn hơn hoặc bằng a!");
        } while (b < a);

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
            System.out.println("Không có cặp số nguyên tố cùng nhau nào!");
        }

        sc.close();
    }
}