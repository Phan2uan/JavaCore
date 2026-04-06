/*
Bài 10. Viết chương trình liệt kê các số nguyên có 7 chữ số thoả mãn cả 3 điều kiện sau:
- Là số nguyên tố.
- Tất cả các chữ số là nguyên tố.
- Đảo của nó cũng là một số nguyên tố.
* */
package basic;

public class Bai10 {

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
                                for (int g : new int[]{3, 7}) {
                                    // chỉ chữ số cuối là 3 hoặc 7
                                    // Giảm số lần kiểm tra từ 4^7 = 16384 → 4^6 * 2 = 2048

                                    int num = a*1000000 + b*100000 + c*10000
                                            + d*1000 + e*100 + f*10 + g;

                                    // kiểm tra điều kiện
                                    if (isPrime(num) && isPrime(reverse(num))) {
                                        System.out.println(num);
                                    }
                                }
    }
}