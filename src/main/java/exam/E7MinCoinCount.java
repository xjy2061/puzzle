package exam;

import java.util.Scanner;

/**
 * 假设现在有一堆硬币，其中有足够个1元硬币、足够个2元硬币和足够个5元硬币。现在需要用这些硬币凑出总价值为n元的钱，求最少需要多少枚硬币？
 */
public class E7MinCoinCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }
        int count = n / 5;
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
