/*
Bài 3: Viết chương trình tìm ước số chung lớn nhất và bội số chung nhỏ nhất của hai số nguyên
dương a,b. Với a,b nhập từ bàn phím.
*/
package basic;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;

        // Nhập a nguyên dương
        do {
            System.out.print("Nhập a (số nguyên dương): ");
            while (!sc.hasNextInt()) {
                System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
                sc.next();
                System.out.print("Nhập a (số nguyên dương): ");
            }
            a = sc.nextInt();
            if (a <= 0) System.out.println("a phải lớn hơn 0!");
        } while (a <= 0);

        // Nhập b nguyên dương
        do {
            System.out.print("Nhập b (số nguyên dương): ");
            while (!sc.hasNextInt()) {
                System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
                sc.next();
                System.out.print("Nhập b (số nguyên dương): ");
            }
            b = sc.nextInt();
            if (b <= 0) System.out.println("b phải lớn hơn 0!");
        } while (b <= 0);

        // Lưu giá trị gốc
        int x = a, y = b;

        // Tính UCLN bằng thuật toán Euclid
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int ucln = a;

        // Tính BCNN: (a / UCLN) * b để tránh tràn số (overflow)
        int bcnn = (x / ucln) * y;

        System.out.println("UCLN của " + x + " và " + y + " = " + ucln);
        System.out.println("BCNN của " + x + " và " + y + " = " + bcnn);

        sc.close();
    }
}