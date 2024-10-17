package exam;

import java.util.Scanner;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 */
public class M18MaxSubArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int currentMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(currentMax, max);
        }
        System.out.println(max);
    }
}