/*
Bài 7. Nhập hai xâu s1 và s2. Tìm xâu s2 trong s1. Nếu có hãy loại bỏ s2 trong s1. Chú ý: phải loại bỏ cho đến
khi không tìm được s2 trong s1 nữa.
 */
package String;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi s1: ");
        String s1 = sc.nextLine();

        System.out.print("Nhap chuoi s2: ");
        String s2 = sc.nextLine();

        // Tránh vòng lặp vô hạn nếu s2 rỗng
        if (s2.isEmpty()) {
            System.out.println("s2 rong, khong the xu ly!");
            return;
        }

        // Xóa lặp lại
        while (s1.contains(s2)) {
            // NOTE (đối chiếu đề bài): yêu cầu "loại bỏ cho đến khi không tìm được s2 trong s1 nữa".
            // Với Java String, replace(old, new) đã thay TẤT CẢ occurrences trong 1 lần gọi,
            // nên vòng while này là dư (thường chạy tối đa 1 vòng).
            // Tuy nhiên vẫn đúng logic và an toàn.
            s1 = s1.replace(s2, "");
        }

        System.out.println("Chuoi sau khi xoa: " + s1);
    }
}