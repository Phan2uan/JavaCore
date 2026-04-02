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