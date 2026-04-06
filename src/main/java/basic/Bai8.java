/*
Bài 8.
a. Viết chương trình liệt kê tất cả các số thuận nghịch có sáu chữ số (số thuận nghịch là số đối
xứng nhau, ví dụ 123321, 9512159, ...).
b. Viết chương trình liệt kê các số thuận nghịch có 6 chữ số mà tổng chữ số chiahết cho 10 (ví
dụ số: 721127).
*/
package basic;

public class Bai8 {

    // Hàm đảo số
    public static int reverse(int n) {
        int rev = 0;

        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return rev;
    }

    // Hàm tính tổng chữ số
    public static int sumDigits(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println("=== Bài 8a: Số thuận nghịch ===");

        for (int i = 100000; i <= 999999; i++) {
            if (i == reverse(i)) {
                System.out.println(i);
            }
        }

        System.out.println("\n=== Bài 8b: Thuận nghịch + tổng chia hết cho 10 ===");

        for (int i = 100000; i <= 999999; i++) {
            if (i == reverse(i) && sumDigits(i) % 10 == 0) {
                System.out.println(i);
            }
        }
    }
}

/**
 * Tối ưu vòng lặp
 * Không cần lặp từ 100000 → 999999
 * Tạo trực tiếp số thuận nghịch từ 3 chữ số đầu → 900 số, nhanh hơn rất nhiều.
 *
 *
 * public class Bai8 {
 *     public static int sumDigits(int n) {
 *         int sum = 0;
 *         while (n != 0) {
 *             sum += n % 10;
 *             n /= 10;
 *         }
 *         return sum;
 *     }
 *
 *     public static void main(String[] args) {
 *
 *         System.out.println("=== Bài 8a: Số thuận nghịch 6 chữ số ===");

 *         for (int a = 1; a <= 9; a++) {
 *             for (int b = 0; b <= 9; b++) {
 *                 for (int c = 0; c <= 9; c++) {
 *                     int num = 100000 * a + 10000 * b + 1000 * c
 *                               + 100 * c + 10 * b + a;
 *                     System.out.println(num);
 *                 }
 *             }
 *         }
 *
 *         System.out.println("\n=== Bài 8b: Thuận nghịch 6 chữ số + tổng chữ số chia hết cho 10 ===");
 *         for (int a = 1; a <= 9; a++) {
 *             for (int b = 0; b <= 9; b++) {
 *                 for (int c = 0; c <= 9; c++) {
 *                     int num = 100000 * a + 10000 * b + 1000 * c
 *                               + 100 * c + 10 * b + a;
 *                     if (sumDigits(num) % 10 == 0) {
 *                         System.out.println(num);
 *                     }
 *                 }
 *             }
 *         }
 *     }
 * }
* */