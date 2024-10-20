package exam;

import java.util.Scanner;

/**
 * 给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
 * 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
 * 0 <= i < nums.length
 * 0 <= j < nums.length
 * 0 <= k < nums.length
 * nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 * 提示：
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < 2^16
 */
public class H14TripletCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] counts = new int[1 << 16];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int add = nums[i] & nums[j];
                counts[add]++;
            }
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < counts.length; j++) {
                if ((nums[i] & j) == 0) {
                    ret += counts[j];
                }
            }
        }
        System.out.println(ret);
    }
}
