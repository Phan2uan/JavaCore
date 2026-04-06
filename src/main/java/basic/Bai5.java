/*
Bài 5. Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ nhập vào từ bàn phím. Ví
dụ: Số 8545604 có tổng các chữ số là: 8 + 5 + 4 + 5 + 6 + 0 + 4 = 32.
*/
package basic;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Nhập số nguyên: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                break;
            } else {
                System.out.println("Sai định dạng! Nhập số nguyên.");
                sc.next();
            }
        }

        int sum = 0;

        // xử lý số âm (nếu có)
        if (n < 0) {
            n = -n;
        }

        while (n != 0) {
            int digit = n % 10; // lấy chữ số cuối
            sum += digit;       // cộng vào tổng
            n = n / 10;         // bỏ chữ số cuối
        }

        System.out.println("Tổng các chữ số = " + sum);
        sc.close();
    }
}