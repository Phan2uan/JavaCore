package basic;

public class Bai7 {

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Hàm kiểm tra tất cả chữ số là lẻ
    public static boolean allOddDigits(int n) {
        while (n != 0) {
            int digit = n % 10;

            if (digit % 2 == 0) {
                return false; // có số chẵn → loại
            }
            n /= 10;
        }

        return true;
    }

    public static void main(String[] args) {

        for (int i = 100000; i <= 999999; i++) {

            if (allOddDigits(i) && isPrime(i)) {
                System.out.println(i);
            }

        }
    }
}