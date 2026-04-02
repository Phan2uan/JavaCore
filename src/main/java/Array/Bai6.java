package Array;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        double x = sc.nextDouble();

        // Sắp xếp
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        int[] b = new int[n + 1];

        int i = 0;

        // tìm vị trí chèn
        while (i < n && a[i] < x) {
            b[i] = a[i];
            i++;
        }

        b[i] = (int)x;

        // copy phần còn lại
        for (int j = i; j < n; j++) {
            b[j + 1] = a[j];
        }

        for (int j = 0; j < n + 1; j++) {
            System.out.print(b[j] + " ");
        }
    }
}
