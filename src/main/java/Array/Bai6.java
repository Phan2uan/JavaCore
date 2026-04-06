/*
Bài 6. Nhập mảng (a, n) và một giá trị thực x. Sắp xếp mảng a theo thứ tự tăng dần. Sau đó chèn giá trị x vào
dãy a sao cho vẫn giữ được tính sắp xếp của mảng.
*/
package Array;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //SAI
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        double x = sc.nextDouble();

        // Sắp xếp
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        int[] b = new int[n + 1];

        int i = 0;

        // tìm vị trí chèn
        while (i < n && a[i] < x) {
            b[i] = a[i];
            i++;
        }

        b[i] = (int)x;

        // copy phần còn lại
        for (int j = i; j < n; j++) {
            b[j + 1] = a[j];
        }

        for (int j = 0; j < n + 1; j++) {
            System.out.print(b[j] + " ");
        }
    }
}
/*
Sai yêu cầu dữ liệu:
    Đề nói x là giá trị thực, nhưng lại:
        Dùng mảng int[] cho kết quả
        Chèn bằng b[i] = (int) x; → mất phần thập phân, sai bản chất bài toán.
Lỗi/thiếu khác:
    Input không có prompt, khó dùng.
    So sánh a[i] < x giữa int và double OK, nhưng vì ép kiểu về int khi chèn nên dãy có thể không còn đúng thứ tự với giá trị thực x.
Cách làm đúng theo đề (gợi ý):
    Hoặc đổi toàn bộ sang double[] a, double[] b.
    Hoặc nếu đề bắt mảng nguyên nhưng x thực thì kết quả phải là mảng thực.
Kết luận: Bài 6 cần sửa để đạt yêu cầu.
 */