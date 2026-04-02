package basic;  // hoặc package org.example; tùy vào vị trí file

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

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
