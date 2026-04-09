/*
Bài 10. Nhập số liệu cho ma trận A kích thước n x n có các phần tử là các số nguyên. Tính tổng các phần tử
theo đường chéo chính và đường chéo phụ của ma trận.
*/
package Array;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập n và kiểm tra n > 0
        int n;
        do {
            System.out.print("Nhập kích thước ma trận n (n > 0): ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Vui lòng nhập n là số nguyên dương!");
            }
        } while (n <= 0);

        int[][] A = new int[n][n];

        // Nhập ma trận
        System.out.println("Nhập ma trận vuông " + n + "x" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = sc.nextInt();
            }
        }

        int sumMain = 0; // tổng đường chéo chính
        int sumSub = 0;  // tổng đường chéo phụ

        // Tính tổng (nếu n lẻ, phần tử trung tâm được tính vào cả hai tổng)
        for (int i = 0; i < n; i++) {
            sumMain += A[i][i];
            sumSub += A[i][n - 1 - i];
        }

        // In kết quả
        System.out.println("Tổng đường chéo chính: " + sumMain);
        System.out.println("Tổng đường chéo phụ: " + sumSub);

        sc.close();
    }
}

