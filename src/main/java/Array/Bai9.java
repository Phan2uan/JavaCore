/*
Bài 9. Nhập số liệu cho ma trận A(n*m)có các phần tử là các số nguyên. Hãy liệt kê trên màn hình tất cả các
phần tử của ma trận nhưng theo thứ tự tăng dần từ trái qua phải, từ trên xuống dưới.
*/
package Array;

import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số dòng n: ");
        int n = sc.nextInt();

        System.out.print("Nhập số cột m: ");
        int m = sc.nextInt();

        int[][] A = new int[n][m];

        // Nhập ma trận
        System.out.println("Nhập ma trận:");
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

        // B2: Sắp xếp tăng dần
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i] > b[j]) {
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }

        // B3: In kết quả
        //Sửa lại hien thi
        System.out.println("Các phần tử tăng dần:");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}

/*
Đúng hướng:
    Flatten ra mảng 1D b
    Sort b
    In ra tăng dần
Nhận xét theo đúng đề:
    Đề nói “liệt kê … theo thứ tự tăng dần từ trái qua phải, từ trên xuống dưới”:
    Dang hiểu sai :
        (1) In ra toàn bộ phần tử đã sort (mảng 1 chiều) → SAI
        (2) Sắp xếp lại ma trận sao cho khi đọc theo hàng/cột sẽ tăng dần → sau khi sort thì đổ lại vào A[i][j] theo thứ tự hàng rồi in ma trận.
Kết luận: logic sort đúng, nhưng chưa đưa về ma trận.
 */