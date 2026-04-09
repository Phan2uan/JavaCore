/*
Bài 1. Nhập mảng (a, n) và kiểm tra mảng a có phải là mảng đối xứng hay không. Ví dụ: [15 2 1 2 15] là
mảng đối xứng.
* */
package Array;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phần tử n (kiểm tra n > 0)
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

        // In mảng vừa nhập
        System.out.print("Mảng vừa nhập: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // Kiểm tra đối xứng
        boolean doiXung = kiemTraDoiXung(a);

        // Kết quả
        if (doiXung) {
            System.out.println("=> Mảng ĐỐI XỨNG");
        } else {
            System.out.println("=> Mảng KHÔNG đối xứng");
        }

        sc.close();
    }

    /**
     * Phương thức kiểm tra mảng có đối xứng hay không.
     * @param arr mảng cần kiểm tra
     * @return true nếu mảng đối xứng, ngược lại false
     */
    public static boolean kiemTraDoiXung(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}