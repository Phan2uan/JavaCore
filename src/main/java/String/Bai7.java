/*
Bài 7. Nhập hai xâu s1 và s2. Tìm xâu s2 trong s1. Nếu có hãy loại bỏ s2 trong s1. Chú ý: phải loại bỏ cho đến
khi không tìm được s2 trong s1 nữa.
 */
package String;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap s1: ");
        String s1 = sc.nextLine();
        System.out.print("Nhap s2: ");
        String s2 = sc.nextLine();

        // Loại bỏ lặp cho đến khi không còn s2 trong s1
        while (s1.contains(s2)) {
            // Tìm vị trí đầu tiên và xóa bằng substring (xóa từng cái một)
            int idx = s1.indexOf(s2);
            s1 = s1.substring(0, idx) + s1.substring(idx + s2.length());
        }

        System.out.println("Chuoi sau khi xoa: " + s1);
        sc.close();
    }
}