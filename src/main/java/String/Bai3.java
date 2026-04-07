/*
Bài 3. Viết chương trình thực hiện chuẩn hoá một xâu ký tự nhập từ bàn phím (loại bỏ các dấu cách thừa, chuyển
ký tự đầu mỗi từ thành chữ hoa, các ký tự khác thành chữ thường)
 */
package String;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine().trim();

        // NOTE (đối chiếu đề bài): Bạn đã trim() và split("\\s+") để loại bỏ dấu cách thừa => đúng yêu cầu.
        // Sau đó viết hoa ký tự đầu và chuyển phần còn lại về thường => đúng chuẩn hóa theo đề.

        // Nếu chuỗi rỗng sau khi trim
        if (s.isEmpty()) {
            // NOTE: Với input chỉ toàn dấu cách, bạn in ra chuỗi rỗng => hợp lý.
            System.out.println("Chuoi sau khi chuan hoa: ");
            return;
        }

        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // NOTE: Với từ có độ dài 1 ký tự, đoạn if (word.length() > 1) sẽ bỏ qua substring => an toàn.
            result.append(Character.toUpperCase(word.charAt(0)));

            if (word.length() > 1) {
                result.append(word.substring(1).toLowerCase());
            }

            result.append(" ");
        }

        System.out.println("Chuoi sau khi chuan hoa: " + result.toString().trim());

        // NOTE (edge case): Nếu chuỗi có dấu câu dính liền từ (vd: "hello,"), dấu câu sẽ được coi là 1 phần của từ.
        // Đề không yêu cầu xử lý dấu câu nên cách làm này chấp nhận được.
    }
}