package basic;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int temp = n; // giữ lại n ban đầu

        System.out.print(n + " = ");

        boolean first = true; // để xử lý dấu " x "

        for (int i = 2; i <= temp; i++) {
            while (temp % i == 0) {

                if (!first) {
                    System.out.print(" x ");
                }

                System.out.print(i);

                first = false;
                temp /= i;
            }
        }
    }
}