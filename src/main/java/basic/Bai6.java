/*
Bài 6. Nhập vào một số nguyên từ bàn phím, viết chương trình phân tích số đó thành các
thừa số nguyên tố. Ví dụ: 28=2x2x7
*/
package basic;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Nhập an toàn số nguyên > 1
        while (true) {
            System.out.print("Nhập n (>1): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 1) break;
                else System.out.println("n phải > 1!");
            } else {
                System.out.println("Sai định dạng! Nhập số nguyên.");
                sc.next(); // bỏ input sai
            }
        }

        int temp = n; // giữ lại n ban đầu

        System.out.print(n + " = ");

        boolean first = true; // để xử lý dấu " x "

        //i * i <= temp → chỉ cần lặp đến căn bậc 2 của n, tối ưu hơn.
        for (int i = 2; i * i <= temp; i++) {
            while (temp % i == 0) {
                if (!first) {
                    System.out.print(" x ");
                }
                System.out.print(i);
                first = false;
                temp /= i;
            }
        }

        // Nếu còn lại là số nguyên tố lớn
        if (temp > 1) {
            if (!first) System.out.print(" x ");
            System.out.print(temp);
        }

        System.out.println();

        sc.close();
    }
}