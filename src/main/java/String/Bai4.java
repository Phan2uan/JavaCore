/*
Bài 4. Viết chương trình thực hiện nhập một xâu ký tự và tìm từ dài nhất trong xâu đó. Từ đó xuất hiện ở vị trí
nào? (Chú ý. nếu có nhiều từ có độ dài giống nhau thì chọn từ đầu tiên tìm thấy).
 */
package String;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap xau: ");
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("Xau rong.");
            sc.close();
            return;
        }

        String[] words = s.split("\\s+");
        String longest = words[0];
        int viTri = 1; // vị trí từ thứ 1 (1-based)

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
                viTri = i + 1;
            }
        }

        System.out.println("Tu dai nhat: " + longest);
        System.out.println("Vi tri (thu tu tu trong cau): " + viTri);
        sc.close();
    }
}