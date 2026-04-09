//Bài 2. Nhập mảng (a, n) và sắp xếp theo thứ tự tăng dần.

package Array;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập n với kiểm tra n > 0
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

        // Sắp xếp mảng tăng dần
        sortTangDan(a);

        // In kết quả
        System.out.println("Mảng sau khi sắp xếp tăng dần:");
        inMang(a);

        sc.close();
    }

    /**
     * Sắp xếp mảng theo thứ tự tăng dần (Selection sort)
     * @param arr mảng cần sắp xếp
     */
    public static void sortTangDan(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * Đổi chỗ hai phần tử trong mảng
     * @param arr mảng chứa phần tử
     * @param i chỉ số thứ nhất
     * @param j chỉ số thứ hai
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * In mảng ra màn hình, các phần tử cách nhau một khoảng trắng
     * @param arr mảng cần in
     */
    public static void inMang(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();   // xuống dòng cuối
    }
}