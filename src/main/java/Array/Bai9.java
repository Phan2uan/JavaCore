/*
Bài 9. Nhập số liệu cho ma trận A(n*m) có các phần tử là các số nguyên. Hãy liệt kê trên màn hình tất cả các
phần tử của ma trận nhưng theo thứ tự tăng dần từ trái qua phải, từ trên xuống dưới.
*/
package Array;

import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập kích thước ma trận và kiểm tra > 0
        int n, m;
        do {
            System.out.print("Nhập số dòng n (n > 0): ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("n phải là số nguyên dương!");
        } while (n <= 0);

        do {
            System.out.print("Nhập số cột m (m > 0): ");
            m = sc.nextInt();
            if (m <= 0) System.out.println("m phải là số nguyên dương!");
        } while (m <= 0);

        int[][] A = new int[n][m];

        // Nhập ma trận
        System.out.println("Nhập ma trận A (" + n + "x" + m + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = sc.nextInt();
            }
        }

        // B1: Đưa về mảng 1 chiều
        int[] b = new int[n * m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[index++] = A[i][j];
            }
        }

        // B2: Sắp xếp mảng 1 chiều tăng dần
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i] > b[j]) {
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }

        // B3: Đổ lại vào ma trận theo thứ tự từ trái qua phải, từ trên xuống dưới
        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = b[index++];
            }
        }

        // B4: In ma trận kết quả
        System.out.println("Ma trận sau khi sắp xếp tăng dần theo hàng:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}