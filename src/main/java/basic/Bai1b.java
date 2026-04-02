package basic;

import java.util.Scanner;

public class Bai1b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        double sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i; // ép kiểu double
        }

        System.out.println("S = " + sum);
    }
}