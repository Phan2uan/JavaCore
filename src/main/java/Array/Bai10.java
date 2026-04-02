package Array;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[][] A = new int[n][n];

        // Nhập ma trận
        System.out.println("Nhập ma trận:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = sc.nextInt();
            }
        }

        int sumMain = 0;
        int sumSub = 0;

        // Tính tổng
        for (int i = 0; i < n; i++) {
            sumMain += A[i][i];
            sumSub += A[i][n - 1 - i];
        }

        // In kết quả
        System.out.println("Tổng đường chéo chính: " + sumMain);
        System.out.println("Tổng đường chéo phụ: " + sumSub);
    }
}
