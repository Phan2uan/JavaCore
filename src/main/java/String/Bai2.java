/*
Bài 2: Viết chương trình nhập vào một xâu ký tự s bất kỳ, sau đó chuyển sang dạng xen kẽ chữ in hoa và chữ
in thường. Ví dụ s = ABCDefgh thì kết quả là AbCdEfGh
 */
package String;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap xau s: ");
        String s = sc.nextLine();

        StringBuilder result = new StringBuilder();
        int count = 0; // đếm số chữ cái để quyết định hoa/thường

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (count % 2 == 0) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
                count++;
            } else {
                result.append(c); // giữ nguyên ký tự không phải chữ
            }
        }

        System.out.println("Chuoi sau khi chuyen: " + result);
        sc.close();
    }
}