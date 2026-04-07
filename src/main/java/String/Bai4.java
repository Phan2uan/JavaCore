/*
Bài 4. Viết chương trình thực hiện nhập một xâu ký tự và tìm từ dài nhất trong xâu đó. Từ đó xuất hiện ở vị trí
nào? (Chú ý. nếu có nhiều từ có độ dài giống nhau thì chọn từ đầu tiên tìm thấy).
 */
package String;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine().trim();

        // Nếu chuỗi rỗng
        if (s.isEmpty()) {
            System.out.println("Chuoi rong!");
            return;
        }

        String[] words = s.split("\\s+");

        // NOTE (đối chiếu đề bài): Bạn tách từ theo khoảng trắng => hợp lý.
        // Yêu cầu: nếu nhiều từ cùng độ dài lớn nhất thì chọn từ đầu tiên.
        // Bạn chỉ cập nhật khi '>' nên sẽ giữ từ đầu tiên => đúng yêu cầu.

        String longest = words[0];
        int pos = 0;

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
                pos = i;
            }
        }

        System.out.println("Tu dai nhat: " + longest);
        // NOTE (đối chiếu đề): "xuất hiện ở vị trí nào" có thể được hiểu là:
        // - vị trí từ thứ mấy (1-based), hoặc
        // - vị trí index (0-based) trong mảng words, hoặc
        // - vị trí ký tự (character index) trong chuỗi ban đầu.
        // Hiện tại bạn đang in vị trí index 0-based theo mảng words.
        System.out.println("Vi tri (index): " + pos);
    }
}