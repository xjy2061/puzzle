package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组的数量。
 * 注意：答案中不可以包含重复的三元组（例如[a,b,c]与[c,b,a]为重复），如果无符合要求的三元组，则返回0。
 */
public class M5ThreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0, limit = len - 2; i < limit; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = len - 1;
                int expected = -nums[i];
                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == expected) {
                        count++;
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (sum < expected) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
