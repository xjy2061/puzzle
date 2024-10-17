package exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
 * 「超赞子字符串」需满足满足下述两个条件：
 * 该字符串是 s 的一个非空子字符串
 * 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
 * 1 <= s.length <= 10^5
 * s 仅由数字组成
 */
public class H9LongestAwesomeSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int state = 0;
        int max = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0, len = s.length(); i < len; i++) {
            int digital = s.charAt(i) - '0';
            state ^= (1 << digital);
            Integer pos = seen.get(state);
            if (pos == null) {
                seen.put(state, i);
            } else {
                max = Math.max(max, i - pos);
            }
            for (int j = 0; j < 10; j++) {
                int tempState = state ^ (1 << j);
                Integer tempPos = seen.get(tempState);
                if (tempPos != null) {
                    max = Math.max(max, i - tempPos);
                }
            }
        }
        System.out.println(max);
    }
}
