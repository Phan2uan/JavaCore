package Array;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử n: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        // Kiểm tra đối xứng
        boolean doiXung = true;

        for (int i = 0; i < n / 2; i++) {
            if (a[i] != a[n - 1 - i]) {
                doiXung = false;
                break;
            }
        }
        // Kết quả
        if (doiXung) {
            System.out.println("Mảng đối xứng");
        } else {
            System.out.println("Mảng KHÔNG đối xứng");
        }
    }
}