package String;

public class Bai1 {
    public static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        for (int i = 100000; i <= 999999; i++) {
            if (isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }
}

