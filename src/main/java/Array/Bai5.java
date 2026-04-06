/*
Bài 5. Nhập 2 mảng (a, n) và (b, m) và số nguyên p (0 ≤ p < n). Hãy chèn mảng b vào vị trí p của a. Ví dụ:
(a, 4): 5 3 6 7;
(b, 3): 2 9 11;
p: 1
=> (a, 7): 5 2 9 11 3 6 7* */
package Array;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập mảng a
        System.out.print("Nhập số phần tử n của mảng a: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Nhập các phần tử của a:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        // Nhập mảng b
        System.out.print("Nhập số phần tử m của mảng b: ");
        int m = sc.nextInt();
        int[] b = new int[m];

        System.out.println("Nhập các phần tử của b:");
        for (int i = 0; i < m; i++) {
            System.out.print("b[" + i + "] = ");
            b[i] = sc.nextInt();
        }

        // Nhập vị trí p
        System.out.print("Nhập vị trí p: ");
        int p = sc.nextInt();

        // Tạo mảng mới
        int[] c = new int[n + m];

        // 1. Copy phần đầu của a
        for (int i = 0; i < p; i++) {
            c[i] = a[i];
        }

        // 2. Chèn b vào
        for (int i = 0; i < m; i++) {
            c[p + i] = b[i];
        }

        // 3. Copy phần còn lại của a
        for (int i = p; i < n; i++) {
            c[m + i] = a[i];
        }

        // In kết quả
        System.out.println("Mảng sau khi chèn:");
        for (int i = 0; i < n + m; i++) {
            System.out.print(c[i] + " ");
        }
    }
}
/*
Ý tưởng đúng: tạo mảng mới c kích thước n+m, copy 3 đoạn.
Thiếu quan trọng:
    Đề cho ràng buộc 0 ≤ p < n nhưng code không validate:
        Nếu p < 0 hoặc p > n sẽ lỗi hoặc cho kết quả sai.
    Đề là p < n (không cho chèn cuối), còn thực tế nhiều bài cho phép p == n. Nen theo đúng đề hoặc chặn.
Góp ý:
    Đặt tên c có thể là result để dễ hiểu (không bắt buộc).
 */