package exam;

import java.util.Scanner;

/**
 * 请编写一个字符串压缩程序，将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。
 */
public class E23CompressString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isEmpty()) {
            System.out.println();
            return;
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ret.append(s.charAt(i - 1));
            }
        }
        ret.append(s.charAt(s.length() - 1));
        System.out.println(ret);
    }
}
