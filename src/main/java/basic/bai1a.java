/*
Bài 1:
a. Nhập số nguyên n vào từ bàn phím và viết chương trình tính tổng:
S = 1 + 3 + 5 + ... + n (nếu n lẻ)
S = 2 + 4 + ... + n (nếu n chẵn)
*/
package basic;

import java.util.Scanner;

public class bai1a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int sum = 0;
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

