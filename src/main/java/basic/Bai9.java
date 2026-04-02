package basic;

public class Bai9 {

    // Kiểm tra tổng chữ số chia hết cho 10
    public static boolean sumDivisibleBy10(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum % 10 == 0;
    }

    public static void main(String[] args) {

        int[] digits = {0, 6, 8};

        // -------- 7 chữ số --------
        for (int a : digits) {
            if (a == 0) continue; // không được bắt đầu bằng 0

            for (int b : digits)
                for (int c : digits)
                    for (int d : digits) {

                        int num = a*1000000 + b*100000 + c*10000 + d*1000
                                + c*100 + b*10 + a;

                        if (sumDivisibleBy10(num)) {
                            System.out.println(num);
                        }
                    }
        }

        // -------- 8 chữ số --------
        for (int a : digits) {
            if (a == 0) continue;

            for (int b : digits)
                for (int c : digits)
                    for (int d : digits) {

                        int num = a*10000000 + b*1000000 + c*100000 + d*10000
                                + d*1000 + c*100 + b*10 + a;

                        if (sumDivisibleBy10(num)) {
                            System.out.println(num);
                        }
                    }
        }

        // -------- 9 chữ số --------
        for (int a : digits) {
            if (a == 0) continue;

            for (int b : digits)
                for (int c : digits)
                    for (int d : digits)
                        for (int e : digits) {

                            int num = a*100000000 + b*10000000 + c*1000000 + d*100000 + e*10000
                                    + d*1000 + c*100 + b*10 + a;

                            if (sumDivisibleBy10(num)) {
                                System.out.println(num);
                            }
                        }
        }
    }
}