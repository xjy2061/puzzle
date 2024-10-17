package exam;

import java.util.Scanner;

/**
 * 假设你正在使用一款版本控制系统，这款系统使用两个字符串A和B来表示两个版本内容。这两个字符串的长度都不超过1000。你的任务是计算出这两个版本之间的最长公共子序列长度，以便更好地理解这两个版本之间的差异。请注意，子序列的字符不需要在原始字符串中连续。
 * 例如，假设输入两个版本，其内容分别为 "abcfbcab" 和 "bdcabdfcab"，那么 "bca" 是一个公共子序列，"abcab" 也是一个公共子序列，其中 "abfcab" 是这两个版本之间的最长公共子序列，输出的长度为6
 */
public class M15LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
