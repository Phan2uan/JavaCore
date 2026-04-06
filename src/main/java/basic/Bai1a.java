/*
Bài 1:
a. Nhập số nguyên n vào từ bàn phím và viết chương trình tính tổng:
S = 1 + 3 + 5 + ... + n (nếu n lẻ)
S = 2 + 4 + ... + n (nếu n chẵn)
*/
package basic;

import java.util.Scanner;

public class Bai1a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = 0;

        //Validate giá trị nhập vào tránh nhập sai dừng chương tình luôn
        while (true) {
            System.out.print("Nhap n (so nguyen duong): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) break;
                else System.out.println("Phai > 0!");
            } else {
                System.out.println("Sai dinh dang!");
                sc.next(); // bỏ input sai
            }
        }

        if (n % 2 == 1) { // n lẻ
            for (int i = 1; i <= n; i += 2) {
                sum += i;
            }
        } else { // n chẵn
            for (int i = 2; i <= n; i += 2) {
                sum += i;
            }
        }

        System.out.println("Tổng S = " + sum);
        sc.close();
    }
}

