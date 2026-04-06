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

/*
Đúng: duyệt 1 lần, tracking currLen, maxLen, start.
Góp ý:
    Nếu có nhiều đường chạy dài nhất bằng nhau:
        Code hiện chọn đường chạy xuất hiện trước (do chỉ update khi >). Đây là hợp lý.
    Edge case n = 0: hiện currLen=1 sẽ không hợp lý và có thể in sai. Nên chặn n > 0.
 */