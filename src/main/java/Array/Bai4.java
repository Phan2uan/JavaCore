/*
Bài 4. Nhập mảng (a, n) và nhập số X. Xác định vị trí của số nguyên tố trên a có giá trị gần với X nhất.
* */
package Array;

import java.util.Scanner;

public class Bai4 {

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int x) {
        if (x < 2) return false;
        int limit = (int) Math.sqrt(x);
        for (int i = 2; i <= limit; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập n và kiểm tra n > 0
        int n;
        do {
            System.out.print("Nhập số phần tử n (n > 0): ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Vui lòng nhập n là số nguyên dương!");
            }
        } while (n <= 0);

        int[] a = new int[n];

        // Nhập mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        System.out.print("Nhập X: ");
        int X = sc.nextInt();

        int minDiff = Integer.MAX_VALUE;
        int viTri = -1;

        for (int i = 0; i < n; i++) {
            if (isPrime(a[i])) {
                int diff = Math.abs(a[i] - X);
                // Nếu có nhiều số cùng khoảng cách, giữ số đầu tiên (vì chỉ cập nhật khi <)
                if (diff < minDiff) {
                    minDiff = diff;
                    viTri = i;
                }
            }
        }

        if (viTri == -1) {
            System.out.println("Không có số nguyên tố trong mảng.");
        } else {
            System.out.println("Vị trí của số nguyên tố gần " + X + " nhất là: " + viTri);
            System.out.println("Giá trị tại vị trí đó: " + a[viTri] + ", khoảng cách: " + minDiff);
        }

        sc.close();
    }
}