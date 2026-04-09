/*
Bài 2. Nhập số tự nhiên n rồi liệt kê các ước số của nó và số lượng ước số mà nó có.
*/
package basic;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Nhập n nguyên dương
        do {
            System.out.print("Nhập n (số tự nhiên > 0): ");
            while (!sc.hasNextInt()) {
                System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
                sc.next();
                System.out.print("Nhập n (số tự nhiên > 0): ");
            }
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Phải nhập số tự nhiên lớn hơn 0!");
            }
        } while (n <= 0);

        int count = 0;
        System.out.print("Các ước số của " + n + ": ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                count++;
            }
        }

        System.out.println("\nSố lượng ước số: " + count);
        sc.close();
    }
}