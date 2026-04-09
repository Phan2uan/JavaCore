/*
Bài 10. Viết chương trình liệt kê các số nguyên có 7 chữ số thoả mãn cả 3 điều kiện sau:
- Là số nguyên tố.
- Tất cả các chữ số là nguyên tố.
- Đảo của nó cũng là một số nguyên tố.
*/
package basic;

public class Bai10 {

    // Kiểm tra số nguyên tố (tối ưu với sqrt)
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Đảo ngược số
    public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        // Các chữ số nguyên tố: 2, 3, 5, 7
        int[] digits = {2, 3, 5, 7};

        System.out.println("Các số có 7 chữ số thỏa mãn điều kiện:");

        // Chỉ xét chữ số cuối là 3 hoặc 7 (vì số nguyên tố > 2 không thể kết thúc bằng 2 hoặc 5)
        for (int a : digits) {               // chữ số hàng triệu
            for (int b : digits) {           // hàng trăm nghìn
                for (int c : digits) {       // hàng chục nghìn
                    for (int d : digits) {   // hàng nghìn
                        for (int e : digits) { // hàng trăm
                            for (int f : digits) { // hàng chục
                                for (int g : new int[]{3, 7}) { // hàng đơn vị
                                    int num = a * 1_000_000 + b * 100_000 + c * 10_000
                                            + d * 1_000 + e * 100 + f * 10 + g;

                                    // Kiểm tra nguyên tố và nguyên tố của số đảo
                                    if (isPrime(num) && isPrime(reverse(num))) {
                                        System.out.println(num);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}