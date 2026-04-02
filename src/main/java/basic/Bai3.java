package basic;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        int a = sc.nextInt();
        System.out.print("Nhập số thứ hai: ");
        int b = sc.nextInt();

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

        System.out.println("UCLN = " + ucln);
        System.out.println("BCNN = " + bcnn);

        sc.close();
    }
}