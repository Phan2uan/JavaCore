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

        String[] words = s.split("\\s+");

        // Kiểm tra ràng buộc
        if (words.length > 20) {
            System.out.println("Loi: So tu vuot qua 20!");
            sc.close();
            return;
        }
        for (String w : words) {
            if (w.length() > 10) {
                System.out.println("Loi: Tu \"" + w + "\" co do dai > 10 ky tu!");
                sc.close();
                return;
            }
        }

        // Sắp xếp theo thứ tự alphabet (không phân biệt hoa/thường)
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);

        System.out.println("Cac tu sau khi sap xep:");
        for (String w : words) {
            System.out.println(w);
        }
        sc.close();
    }
}