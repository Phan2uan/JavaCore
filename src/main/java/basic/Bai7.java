/*
Bài 7. Viết chương trình liệt kê các số nguyên tố có 6 chữ số chỉ bao gồm các chữ số lẻ.
*/
package basic;

public class Bai7 {

    // Kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Kiểm tra tất cả chữ số đều là số lẻ
    public static boolean allOddDigits(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) return false;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Các số nguyên tố có 6 chữ số chỉ gồm chữ số lẻ:");
        int count = 0;

        for (int i = 100000; i <= 999999; i++) {
            // Kiểm tra chữ số lẻ trước (nhanh hơn kiểm tra nguyên tố)
            if (allOddDigits(i) && isPrime(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) System.out.println(); // xuống dòng sau mỗi 10 số
            }
        }

        System.out.println("\n\nTổng số: " + count);
    }
}