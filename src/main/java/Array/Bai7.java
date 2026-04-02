package Array;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập n
        System.out.print("Nhập số phần tử n: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        // Nhập mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
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
        // Check đoạn cuối
        if (currLen > maxLen) {
            maxLen = currLen;
            bestStart = start;
        }
        // Kết quả
        System.out.println("Đường chạy dài nhất bắt đầu tại vị trí: " + bestStart);
        System.out.println("Độ dài: " + maxLen);
    }
}
