package Array;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập kích thước
        System.out.print("Nhập số dòng m của A: ");
        int m = sc.nextInt();

        System.out.print("Nhập số cột n của A (cũng là số dòng của B): ");
        int n = sc.nextInt();

        System.out.print("Nhập số cột k của B: ");
        int k = sc.nextInt();

        int[][] A = new int[m][n];
        int[][] B = new int[n][k];
        int[][] C = new int[m][k];

        // Nhập ma trận A
        System.out.println("Nhập ma trận A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = sc.nextInt();
            }
        }

        // Nhập ma trận B
        System.out.println("Nhập ma trận B:");
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
        System.out.println("Ma trận C = A × B:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}