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

        // Nhập a
        while (true) {
            System.out.print("Nhap a (so nguyen duong): ");
            if (sc.hasNextInt()) {
                a = sc.nextInt();
                if (a > 0) break;
                else System.out.println("Phai la so duong!");
            } else {
                System.out.println("Sai dinh dang! Hay nhap so nguyen.");
                sc.next();
            }
        }

        // Nhập b
        while (true) {
            System.out.print("Nhap b (so nguyen duong): ");
            if (sc.hasNextInt()) {
                b = sc.nextInt();
                if (b > 0) break;
                else System.out.println("Phai la so duong!");
            } else {
                System.out.println("Sai dinh dang! Hay nhap so nguyen.");
                sc.next();
            }
        }

        // Store original values
        int x = a, y = b;

        // Calculate GCD using Euclidean algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        int ucln = a;

        // Calculate LCM: (a * b) / GCD(a, b)
        // Need to use the original values, not the modified ones
        int bcnn = (x * y) / ucln;
        //Nên sửa: int BCNN = (a / UCLN) * b;
        //Giảm nguy cơ overflow

        System.out.println("UCLN = " + ucln);
        System.out.println("BCNN = " + bcnn);

        sc.close();
    }
}