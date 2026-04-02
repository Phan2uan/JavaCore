package Array;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        boolean[] daDem = new boolean[n]; // đánh dấu đã đếm

        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
            daDem[i] = false;
        }

        int maxCount = 0;
        int valueMax = a[0];

        // Đếm
        for (int i = 0; i < n; i++) {
            if (daDem[i] == true) continue;

            int count = 1;

            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                    daDem[j] = true;
                }
            }

            // In số lần xuất hiện
            System.out.println(a[i] + " xuất hiện " + count + " lần");

            // Tìm max
            if (count > maxCount) {
                maxCount = count;
                valueMax = a[i];
            }
        }

        System.out.println("Phần tử xuất hiện nhiều nhất: " + valueMax);
    }
}
