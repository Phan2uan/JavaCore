package basic;  // hoặc package basic; tùy vào cấu trúc project của bạn

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

