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

        // Kiểm tra chuỗi rỗng
        if (s.isEmpty()) {
            System.out.println("Chuoi rong!");
            return;
        }

        String[] parts = s.split("\\s+");

        // NOTE (đối chiếu đề bài): Input theo cấu trúc "họ ... đệm ... tên".
        // Bạn đã split theo khoảng trắng (\\s+) nên tự loại bỏ các dấu cách thừa => tốt.

        // Nếu chỉ có 1 từ
        if (parts.length == 1) {
            System.out.println("Ket qua: " + parts[0]);
            return;
        }

        String ten = parts[parts.length - 1]; // tên

        StringBuilder result = new StringBuilder();
        result.append(ten).append(" ");

        // họ + đệm
        for (int i = 0; i < parts.length - 1; i++) {
            result.append(parts[i]).append(" ");
        }

        // NOTE: Bài không yêu cầu chuẩn hóa hoa/thường, nên giữ nguyên chữ như người dùng nhập.
        // Nếu muốn đẹp hơn, có thể kết hợp chuẩn hóa như Bài 3.

        System.out.println("Ket qua: " + result.toString().trim());
    }
}