/*
Bài 5. Nhập 2 mảng (a, n) và (b, m) và số nguyên p (0 ≤ p < n). Hãy chèn mảng b vào vị trí p của a. Ví dụ:
(a, 4): 5 3 6 7;
(b, 3): 2 9 11;
p: 1
=> (a, 7): 5 2 9 11 3 6 7* */
package Array;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập mảng a và kiểm tra n > 0
        int n;
        do {
            System.out.print("Nhập số phần tử n của mảng a (n > 0): ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("n phải là số nguyên dương!");
        } while (n <= 0);

        int[] a = new int[n];
        System.out.println("Nhập các phần tử của a:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        // Nhập mảng b và kiểm tra m >= 0 (có thể m = 0, nhưng đề không cấm)
        int m;
        do {
            System.out.print("Nhập số phần tử m của mảng b (m >= 0): ");
            m = sc.nextInt();
            if (m < 0) System.out.println("m không thể âm!");
        } while (m < 0);

        int[] b = new int[m];
        if (m > 0) {
            System.out.println("Nhập các phần tử của b:");
            for (int i = 0; i < m; i++) {
                System.out.print("b[" + i + "] = ");
                b[i] = sc.nextInt();
            }
        }

        // Nhập vị trí p với ràng buộc 0 ≤ p < n
        int p;
        do {
            System.out.print("Nhập vị trí p (0 ≤ p < " + n + "): ");
            p = sc.nextInt();
            if (p < 0 || p >= n) {
                System.out.println("p không hợp lệ! Vui lòng nhập lại.");
            }
        } while (p < 0 || p >= n);

        // Tạo mảng kết quả
        int[] result = new int[n + m];

        // 1. Copy phần đầu của a (từ 0 đến p-1)
        for (int i = 0; i < p; i++) {
            result[i] = a[i];
        }

        // 2. Chèn toàn bộ mảng b vào vị trí p
        for (int i = 0; i < m; i++) {
            result[p + i] = b[i];
        }

        // 3. Copy phần còn lại của a (từ p đến n-1)
        for (int i = p; i < n; i++) {
            result[m + i] = a[i];
        }

        // In kết quả
        System.out.println("Mảng sau khi chèn:");
        for (int i = 0; i < n + m; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println(); // xuống dòng

        sc.close();
    }
}