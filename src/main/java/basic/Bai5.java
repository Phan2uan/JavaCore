package basic;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên: ");
        int n = sc.nextInt();

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
    }
}