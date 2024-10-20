package exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class H13LongestNonRepeatSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            Integer pos = map.get(c);
            if (pos != null) {
                l = pos + 1;
            }
            map.put(c, r);
            max = Math.max(max, r - l + 1);
        }
        System.out.println(max);
    }
}
