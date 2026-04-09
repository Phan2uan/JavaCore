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

        // Nhập n > 1 (số cần phân tích)
        do {
            System.out.print("Nhập n (n > 1): ");
            while (!sc.hasNextInt()) {
                System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
                sc.next();
                System.out.print("Nhập n (n > 1): ");
            }
            n = sc.nextInt();
            if (n <= 1) System.out.println("n phải lớn hơn 1!");
        } while (n <= 1);

        int temp = n;
        System.out.print(n + " = ");

        boolean first = true; // kiểm soát dấu " x "

        // Chỉ cần xét đến căn bậc hai của temp
        for (int i = 2; i * i <= temp; i++) {
            while (temp % i == 0) {
                if (!first) System.out.print(" x ");
                System.out.print(i);
                first = false;
                temp /= i;
            }
        }

        // Nếu còn lại là số nguyên tố lớn hơn 1
        if (temp > 1) {
            if (!first) System.out.print(" x ");
            System.out.print(temp);
        }

        System.out.println();
        sc.close();
    }
}