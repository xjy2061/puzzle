package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
 * 现在，给定两个正整数 L 和 R ，请按照从小到大的顺序打印包含在范围 [L, R] 中的所有超级回文数。
 * 注：R包含的数字不超过20位
 * 回文数定义：将该数各个位置的数字反转排列，得到的数和原数一样，例如676，2332，10201。
 */
public class H10SuperPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        long l = Long.parseLong(input[0]);
        long r = Long.parseLong(input[1]);

        int limit = (int) Math.sqrt(r) + 1;
        ArrayList<Long> ret = new ArrayList<>();
        for (int i = 1; i < limit; i++) {
            String s = Integer.toString(i);
            long p = Long.parseLong(s + new StringBuilder(s.substring(0, s.length() - 1)).reverse());
            long square = p * p;
            if (square > r) {
                break;
            }
            if (square >= l && isPalindrome(square)) {
                ret.add(square);
            }
            p = Long.parseLong(s + new StringBuilder(s).reverse());
            square = p * p;
            if (square >= l && square <= r && isPalindrome(square)) {
                ret.add(square);
            }
        }
        Collections.sort(ret);
        System.out.println(ret);
    }

    static boolean isPalindrome(long p) {
        String s = Long.toString(p);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}