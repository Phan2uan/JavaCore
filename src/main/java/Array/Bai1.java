/*
Bài 1. Nhập mảng (a, n) và kiểm tra mảng a có phải là mảng đối xứng hay không. Ví dụ: [15 2 1 2 15] là
mảng đối xứng.
* */
package Array;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử n: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        // Kiểm tra đối xứng
        boolean doiXung = true;

        for (int i = 0; i < n / 2; i++) {
            if (a[i] != a[n - 1 - i]) {
                doiXung = false;
                break;
            }
        }
        // Kết quả
        if (doiXung) {
            System.out.println("Mảng đối xứng");
        } else {
            System.out.println("Mảng KHÔNG đối xứng");
        }
    }
}
/*
Đúng thuật toán: so sánh a[i] với a[n-1-i] tới n/2.
Edge case:
    n = 0: chương trình vẫn tạo mảng được, vòng lặp không chạy, in “đối xứng” cũng hợp lý, nhưng UX thì nên chặn n > 0 (không bắt buộc).
Góp ý:
    Input validation: nên kiểm tra n âm (nếu nhập sai).
 */