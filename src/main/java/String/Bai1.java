/*
Bài 1. Sử dụng xâu ký tự để viết hàm kiểm tra số thuận nghịch. Áp dụng liệt kê các số thuận nghịch có 6 chữ
số.
 */
package String;

public class Bai1 {
    public static boolean isPalindrome(int n) {
        // NOTE (đối chiếu đề bài): Đề yêu cầu "sử dụng xâu ký tự" để kiểm tra số thuận nghịch.
        // đã chuyển số sang String và đảo bằng StringBuilder => đúng
        String s = String.valueOf(n);
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        // NOTE: Duyệt toàn bộ [100000..999999] và in ra các số thuận nghịch 6 chữ số => đúng yêu cầu
        // Hiệu năng vẫn ổn (900k lần kiểm tra), nhưng in ra console rất nhiều dòng
        // Nếu cần tối ưu, có thể sinh trực tiếp dạng abc|cba thay vì duyệt toàn bộ
        for (int i = 100000; i <= 999999; i++) {
            if (isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }
}

