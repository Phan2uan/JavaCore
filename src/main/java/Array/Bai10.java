/*
Bài 10. Nhập số liệu cho ma trận A kích thước n x n có các phần tử là các số nguyên. Tính tổng các phần tử
theo đường chéo chính và đường chéo phụ của ma trận.
*/
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

/*
Đúng: sumMain += A[i][i], sumSub += A[i][n-1-i].
Góp ý:
    Nếu n lẻ, phần tử trung tâm bị tính vào cả 2 tổng (đúng theo định nghĩa “tổng từng đường chéo”).
    Validate n > 0.
* */
