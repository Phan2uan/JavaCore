/*
Bài 5. Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ nhập vào từ bàn phím. Ví
dụ: Số 8545604 có tổng các chữ số là: 8 + 5 + 4 + 5 + 6 + 0 + 4 = 32.
*/
package basic;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Nhập số nguyên (có thể âm)
        System.out.print("Nhập số nguyên bất kỳ: ");
        while (!sc.hasNextInt()) {
            System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
            sc.next();
            System.out.print("Nhập số nguyên bất kỳ: ");
        }
        n = sc.nextInt();

        // Xử lý số âm: lấy giá trị tuyệt đối để tính tổng chữ số
        int absN = Math.abs(n);
        int sum = 0;

        // Trường hợp đặc biệt: n = 0
        if (absN == 0) {
            sum = 0;
        } else {
            while (absN != 0) {
                sum += absN % 10;   // lấy chữ số cuối
                absN /= 10;         // bỏ chữ số cuối
            }
        }

        System.out.println("Tổng các chữ số của " + n + " = " + sum);
        sc.close();
    }
}