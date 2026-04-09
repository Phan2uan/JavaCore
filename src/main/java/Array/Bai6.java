/*
Bài 6. Nhập mảng (a, n) và một giá trị thực x. Sắp xếp mảng a theo thứ tự tăng dần. Sau đó chèn giá trị x vào
dãy a sao cho vẫn giữ được tính sắp xếp của mảng.
*/
package Array;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập n và kiểm tra n > 0
        int n;
        do {
            System.out.print("Nhập số phần tử n (n > 0): ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("Vui lòng nhập n là số nguyên dương!");
        } while (n <= 0);

        int[] a = new int[n];
        System.out.println("Nhập các phần tử của mảng a (số nguyên):");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        System.out.print("Nhập giá trị thực x = ");
        double x = sc.nextDouble();

        // Sắp xếp mảng a tăng dần (bubble sort)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.print("Mảng a sau khi sắp xếp: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // Tạo mảng kết quả kiểu double (giữ nguyên phần thập phân của x)
        double[] b = new double[n + 1];

        // Tìm vị trí cần chèn x (vẫn giữ thứ tự tăng dần)
        int pos = 0;
        while (pos < n && a[pos] < x) {
            b[pos] = a[pos];
            pos++;
        }

        // Chèn x tại vị trí pos
        b[pos] = x;

        // Copy các phần tử còn lại của a vào b
        for (int i = pos; i < n; i++) {
            b[i + 1] = a[i];
        }

        // In mảng kết quả
        System.out.print("Mảng sau khi chèn x: ");
        for (int i = 0; i < n + 1; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}