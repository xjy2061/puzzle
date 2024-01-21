package exam;

import java.util.Scanner;

public class MinCoinCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = -1;
        if (n == 0) {
            System.out.println(count);
            return;
        }
        count = n / 5;
        n %= 5;
        if (n == 0) {
            System.out.println(count);
            return;
        }
        count += n / 2;
        n %= 2;
        if (n == 0) {
            System.out.println(count);
            return;
        }
        count += n;
        System.out.println(count);
    }
}
