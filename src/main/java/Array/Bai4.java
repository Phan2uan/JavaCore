/*
Bài 4. Nhập mảng (a, n) và nhập số X. Xác định vị trí của số nguyên tố trên a có giá trị gần với X nhất.
* */
package Array;

import java.util.Scanner;

public class Bai4 {

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int x) {
        if (x < 2) return false;

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        System.out.print("Nhập X: ");
        int X = sc.nextInt();

        int minDiff = Integer.MAX_VALUE;
        int viTri = -1;

        for (int i = 0; i < n; i++) {
            if (isPrime(a[i])) {
                int diff = Math.abs(a[i] - X);

                if (diff < minDiff) {
                    minDiff = diff;
                    viTri = i;
                }
            }
        }

        if (viTri == -1)
            System.out.println("Không có số nguyên tố");
        else
            System.out.println("Vị trí: " + viTri);
    }
}
/*
Đúng: duyệt, kiểm tra prime, lấy diff nhỏ nhất.
Góp ý:
    Nếu có 2 số nguyên tố cùng khoảng cách đến X:
        Code hiện giữ cái xuất hiện trước (vì chỉ cập nhật khi <, không cập nhật khi ==).
    isPrime dùng Math.sqrt(x) trong vòng for: OK, nhưng để tối ưu có thể tính int limit=(int)Math.sqrt(x) trước.
 */
