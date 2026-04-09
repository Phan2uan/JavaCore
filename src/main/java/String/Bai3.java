package String;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine().trim();

        // Nếu chuỗi rỗng sau khi trim
        if (s.isEmpty()) {
            System.out.println("Chuoi sau khi chuan hoa: ");
            return;
        }

        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)));

            if (word.length() > 1) {
                result.append(word.substring(1).toLowerCase());
            }

            result.append(" ");
        }

        System.out.println("Chuoi sau khi chuan hoa: " + result.toString().trim());
        sc.close();
    }
}