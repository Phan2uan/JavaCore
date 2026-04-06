/*
Bài 2. Nhập số tự nhiên n rồi liệt kê các ước số của nó và số lượng ước số mà nó có.
*/
package basic;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        //validate
        while (true) {
            System.out.print("Nhap n (so tu nhien > 0): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) break;
                else System.out.println("Phai la so tu nhien > 0!");
            } else {
                System.out.println("Sai dinh dang! Nhap lai.");
                sc.next();
            }
        }

        int count = 0;

        System.out.print("Ước số: ");
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
