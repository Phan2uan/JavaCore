/*
Bài 6. Nhập một câu không quá 20 từ, mỗi từ không quá 10 ký tự. Viết chương trình tách các từ trong câu và
in các từ theo thứ tự Alphabet.
 */
package String;

import java.util.*;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap cau: ");
        String s = sc.nextLine().trim();

        // Kiểm tra rỗng
        if (s.isEmpty()) {
            System.out.println("Chuoi rong!");
            return;
        }

        String[] words = s.split("\\s+");

        // NOTE (đối chiếu đề bài): Đề cho ràng buộc "không quá 20 từ, mỗi từ không quá 10 ký tự".
        // Code hiện tại chưa kiểm tra/nhắc lại nếu người dùng nhập vượt ràng buộc.
        // (Không bắt buộc phải chặn, nhưng nếu muốn đúng đề chặt chẽ thì nên validate words.length <= 20
        // và mỗi words[i].length() <= 10).

        // Sắp xếp alphabet (không phân biệt hoa/thường)
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);

        // NOTE: CASE_INSENSITIVE_ORDER sẽ bỏ qua hoa/thường khi so sánh.
        // Nếu có dấu tiếng Việt/Unicode, thứ tự alphabet có thể không đúng "từ điển tiếng Việt" (đề không yêu cầu).
        System.out.println("Cac tu sau khi sap xep:");
        for (String w : words) {
            System.out.println(w);
        }
    }
}