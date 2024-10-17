package exam;

import java.util.Scanner;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 1；否则，返回 0。
 */
public class E4Palindromic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String s = input.toLowerCase().replaceAll("[^0-9a-z]+", "");
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println(0);
                return;
            }
            i++;
            j--;
        }
        System.out.println(1);
    }
}
