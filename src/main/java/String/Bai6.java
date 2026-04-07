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

        // Sắp xếp alphabet (không phân biệt hoa/thường)
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);

        System.out.println("Cac tu sau khi sap xep:");
        for (String w : words) {
            System.out.println(w);
        }
    }
}