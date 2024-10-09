package exam;

import java.util.Scanner;

public class E28BuyPenWays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int x = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        long count = 0;
        for (int i = 0; i * a <= x; i++) {
            int remain = x - i * a;
            count += (remain / b) + 1;
        }
        System.out.println(count);
    }
}
