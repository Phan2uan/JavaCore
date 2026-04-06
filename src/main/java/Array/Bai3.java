/*
Bài 3. Nhập mảng (a, n) và đếm số lần xuất hiện của từng phần tử trong mảng, đồng thời cho biết phần tử có số
lần xuất hiện nhiều nhất trong a.
* */
package Array;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        boolean[] daDem = new boolean[n]; // đánh dấu đã đếm

        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
            daDem[i] = false;
        }

        int maxCount = 0;
        int valueMax = a[0];

        // Đếm
        for (int i = 0; i < n; i++) {
            if (daDem[i] == true) continue;

            int count = 1;

            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                    daDem[j] = true;
                }
            }

            // In số lần xuất hiện
            System.out.println(a[i] + " xuất hiện " + count + " lần");

            // Tìm max
            if (count > maxCount) {
                maxCount = count;
                valueMax = a[i];
            }
        }

        System.out.println("Phần tử xuất hiện nhiều nhất: " + valueMax);
    }
}

/*
Ý tưởng đúng: mảng daDem[] để tránh đếm lặp.
Lỗi/thiếu quan trọng:
    Bug khi n = 0: valueMax = a[0] sẽ crash (ArrayIndexOutOfBoundsException).
Góp ý logic:
    Nếu có nhiều phần tử cùng tần suất max, bài chưa nói chọn phần tử nào:
    Hiện tại code chọn phần tử đầu tiên đạt max (ổn, nhưng nên nêu rõ).
Cần sửa tối thiểu:
    Nếu n <= 0 thì thông báo và kết thúc.
    Hoặc khởi tạo maxCount = -1 và chỉ gán valueMax khi gặp phần tử đầu tiên.
* */