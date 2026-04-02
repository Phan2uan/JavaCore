package basic;

public class bai10 {

    // kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    // đảo số
    public static int reverse(int n) {
        int rev = 0;

        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return rev;
    }

    public static void main(String[] args) {

        int[] digits = {2, 3, 5, 7};

        // tạo tất cả số 7 chữ số từ 2,3,5,7
        for (int a : digits)
            for (int b : digits)
                for (int c : digits)
                    for (int d : digits)
                        for (int e : digits)
                            for (int f : digits)
                                for (int g : digits) {

                                    int num = a*1000000 + b*100000 + c*10000
                                            + d*1000 + e*100 + f*10 + g;

                                    // kiểm tra điều kiện
                                    if (isPrime(num) && isPrime(reverse(num))) {
                                        System.out.println(num);
                                    }
                                }
    }
}