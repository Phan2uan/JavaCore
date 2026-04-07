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

        String longest = words[0];
        int pos = 0;

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
                pos = i;
            }
        }

        System.out.println("Tu dai nhat: " + longest);
        System.out.println("Vi tri (index): " + pos);
    }
}