/*
Bài 8.
a. Viết chương trình liệt kê tất cả các số thuận nghịch có sáu chữ số (số thuận nghịch là số đối
xứng nhau, ví dụ 123321, 9512159, ...).
b. Viết chương trình liệt kê các số thuận nghịch có 6 chữ số mà tổng chữ số chia hết cho 10 (ví
dụ số: 721127).
*/
package basic;

public class Bai8 {

    // Tính tổng các chữ số của một số (có thể dùng công thức, nhưng viết hàm cho rõ)
    public static int sumDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Bài 8a: Số thuận nghịch 6 chữ số ===");
        int countA = 0;

        // Số thuận nghịch 6 chữ số có dạng: a b c c b a
        // a: 1..9, b: 0..9, c: 0..9
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    int num = a * 100000 + b * 10000 + c * 1000 + c * 100 + b * 10 + a;
                    System.out.print(num + " ");
                    countA++;
                    if (countA % 10 == 0) System.out.println(); // xuống dòng sau 10 số
                }
            }
        }
        System.out.println("\nTổng số thuận nghịch 6 chữ số: " + countA);

        System.out.println("\n=== Bài 8b: Thuận nghịch 6 chữ số + tổng chữ số chia hết cho 10 ===");
        int countB = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    int num = a * 100000 + b * 10000 + c * 1000 + c * 100 + b * 10 + a;
                    if (sumDigits(num) % 10 == 0) {
                        System.out.print(num + " ");
                        countB++;
                        if (countB % 10 == 0) System.out.println();
                    }
                }
            }
        }
        System.out.println("\nTổng số thuận nghịch thỏa mãn: " + countB);
    }
}