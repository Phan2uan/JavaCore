/*
Bài 3. Nhập mảng (a, n) và đếm số lần xuất hiện của từng phần tử trong mảng, đồng thời cho biết phần tử có số
lần xuất hiện nhiều nhất trong a.
* */
package Array;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập n và kiểm tra n > 0
        int n;
        do {
            System.out.print("Nhập số phần tử n (n > 0): ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Vui lòng nhập n là số nguyên dương!");
            }
        } while (n <= 0);

        int[] a = new int[n];
        boolean[] daDem = new boolean[n]; // đánh dấu đã đếm

        // Nhập mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
            daDem[i] = false;
        }

        int maxCount = -1;          // khởi tạo -1 để tránh lỗi khi n>0
        int valueMax = a[0];        // tạm gán, nhưng sẽ được cập nhật sau

        // Đếm số lần xuất hiện của từng phần tử
        for (int i = 0; i < n; i++) {
            if (daDem[i]) continue; // đã đếm rồi thì bỏ qua

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                    daDem[j] = true;
                }
            }

            // In số lần xuất hiện
            System.out.println(a[i] + " xuất hiện " + count + " lần");

            // Tìm phần tử có số lần xuất hiện nhiều nhất
            // (nếu nhiều phần tử cùng tần suất max, chọn phần tử đầu tiên gặp)
            if (count > maxCount) {
                maxCount = count;
                valueMax = a[i];
            }
        }

        System.out.println("Phần tử xuất hiện nhiều nhất: " + valueMax + " (với " + maxCount + " lần)");
        sc.close();
    }
}