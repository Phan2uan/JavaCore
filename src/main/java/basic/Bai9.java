/*
Bài 9. Viết chương trình liệt kê các số nguyên có 7 đến 9 chữ số thoả mãn cả 3 điều kiện sau:
- Là số thuận nghịch.
- Chỉ có chữ số 0, 6, 8.
- Tổng chữ số chia hết cho 10.
*/
package basic;

public class Bai9 {
    public static void main(String[] args) {
        int[] digits = {0, 6, 8};

        System.out.println("Các số thuận nghịch từ 7 đến 9 chữ số (chỉ gồm 0,6,8) có tổng chữ số chia hết cho 10:");

        // -------- 7 chữ số (dạng a b c d c b a) --------
        for (int a : digits) {
            if (a == 0) continue; // chữ số đầu tiên không thể là 0
            for (int b : digits) {
                for (int c : digits) {
                    for (int d : digits) {
                        int num = a * 1_000_000 + b * 100_000 + c * 10_000 + d * 1_000
                                + c * 100 + b * 10 + a;
                        int sum = a + a + b + b + c + c + d; // tổng chữ số
                        if (sum % 10 == 0) {
                            System.out.println(num);
                        }
                    }
                }
            }
        }

        // -------- 8 chữ số (dạng a b c d d c b a) --------
        for (int a : digits) {
            if (a == 0) continue;
            for (int b : digits) {
                for (int c : digits) {
                    for (int d : digits) {
                        int num = a * 10_000_000 + b * 1_000_000 + c * 100_000 + d * 10_000
                                + d * 1_000 + c * 100 + b * 10 + a;
                        int sum = a + a + b + b + c + c + d + d;
                        if (sum % 10 == 0) {
                            System.out.println(num);
                        }
                    }
                }
            }
        }

        // -------- 9 chữ số (dạng a b c d e d c b a) --------
        for (int a : digits) {
            if (a == 0) continue;
            for (int b : digits) {
                for (int c : digits) {
                    for (int d : digits) {
                        for (int e : digits) {
                            int num = a * 100_000_000 + b * 10_000_000 + c * 1_000_000 + d * 100_000 + e * 10_000
                                    + d * 1_000 + c * 100 + b * 10 + a;
                            int sum = a + a + b + b + c + c + d + d + e;
                            if (sum % 10 == 0) {
                                System.out.println(num);
                            }
                        }
                    }
                }
            }
        }
    }
}