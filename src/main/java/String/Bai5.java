/*
Bài 5.Viết chương trình thực hiện nhập một xâu họ tên theo cấu trúc: họ...đệm...tên; chuyển xâu đó sang biểu
diễn theo cấu trúc tên...họ...đệm.
 */
package String;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        String s = sc.nextLine().trim();

        String[] parts = s.split("\\s+");
        if (parts.length == 1) {
            System.out.println("Ket qua: " + parts[0]);
        } else {
            // Lấy tên (phần tử cuối)
            String ten = parts[parts.length - 1];
            // Ghép họ và đệm (từ đầu đến trước phần tử cuối)
            StringBuilder hoDem = new StringBuilder();
            for (int i = 0; i < parts.length - 1; i++) {
                hoDem.append(parts[i]).append(" ");
            }
            System.out.println("Ket qua: " + ten + " " + hoDem.toString().trim());
        }
        sc.close();
    }
}