package exam;

import java.util.Scanner;

/**
 * 给定一个源串和目标串，能够对源串进行如下操作：
 * 在给定位置上插入一个字符
 * 替换任意字符
 * 删除任意字符
 * 写一个程序，返回最小操作数，使得对源串进行这些操作后等于目标串
 */
public class E12EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String s1 = input[0];
        String s2 = input[1];
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j - 1] + 1, dp[i -1][j] + 1));
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
