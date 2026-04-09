/*
Bài 8. Viết chương trình tính tích 2 ma trận các số nguyên A cấp m*n và B cấp n*k.
*/
package Array;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập kích thước và kiểm tra > 0
        int m, n, k;
        do {
            System.out.print("Nhập số dòng m của A (m > 0): ");
            m = sc.nextInt();
            if (m <= 0) System.out.println("m phải là số nguyên dương!");
        } while (m <= 0);

        do {
            System.out.print("Nhập số cột n của A (n > 0, cũng là số dòng của B): ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("n phải là số nguyên dương!");
        } while (n <= 0);

        do {
            System.out.print("Nhập số cột k của B (k > 0): ");
            k = sc.nextInt();
            if (k <= 0) System.out.println("k phải là số nguyên dương!");
        } while (k <= 0);

        int[][] A = new int[m][n];
        int[][] B = new int[n][k];
        int[][] C = new int[m][k];

        // Nhập ma trận A
        System.out.println("Nhập ma trận A (" + m + "x" + n + "):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = sc.nextInt();
            }
        }

        // Nhập ma trận B
        System.out.println("Nhập ma trận B (" + n + "x" + k + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = sc.nextInt();
            }
        }

        // Nhân ma trận
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                C[i][j] = 0;
                for (int t = 0; t < n; t++) {
                    C[i][j] += A[i][t] * B[t][j];
                }
            }
        }

        // In kết quả
        System.out.println("Ma trận C = A × B (" + m + "x" + k + "):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}