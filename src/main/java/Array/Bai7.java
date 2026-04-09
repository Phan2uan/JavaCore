/*
Bài 7. Nhập mảng (a, n). Xác định đường chạy dài nhất, xuất lên màn hình vị trí phần tử đầu tiên và độ dài của
đường chạy đó. Đường chạy là một dãy liên tiếp các phần tử không giảm của dãy ban đầu. Ví dụ:
Nhập dãy 1 4 2 3 1 2 6 8 3 5 7
Đường chạy dài nhất ở vị trí 4 với độ dài là 4
*/
package Array;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập n và kiểm tra n > 0
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

        // Xử lý trường hợp n == 1 (chỉ có một phần tử)
        if (n == 1) {
            System.out.println("Đường chạy dài nhất bắt đầu tại vị trí: 0");
            System.out.println("Độ dài: 1");
            sc.close();
            return;
        }

        // Khởi tạo
        int currLen = 1;
        int maxLen = 1;
        int start = 0;
        int bestStart = 0;

        // Duyệt tìm đường chạy
        for (int i = 1; i < n; i++) {
            if (a[i] >= a[i - 1]) {
                currLen++;
            } else {
                if (currLen > maxLen) {
                    maxLen = currLen;
                    bestStart = start;
                }
                currLen = 1;
                start = i;
            }
        }

        // Kiểm tra đoạn cuối
        if (currLen > maxLen) {
            maxLen = currLen;
            bestStart = start;
        }

        // Kết quả
        System.out.println("Đường chạy dài nhất bắt đầu tại vị trí: " + bestStart);
        System.out.println("Độ dài: " + maxLen);

        sc.close();
    }
}