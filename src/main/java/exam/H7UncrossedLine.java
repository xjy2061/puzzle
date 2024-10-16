package exam;

import java.util.Scanner;

public class H7UncrossedLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(" ");
            int[] nums1 = new int[input.length - 1];
            for (int i = 1; i < input.length; i++) {
                nums1[i - 1] = Integer.parseInt(input[i]);
            }
            input = scanner.nextLine().split(" ");
            int[] nums2 = new int[input.length - 1];
            for (int i = 1; i < input.length; i++) {
                nums2[i - 1] = Integer.parseInt(input[i]);
            }

            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            System.out.println(dp[nums1.length][nums2.length]);
        }
    }
}
