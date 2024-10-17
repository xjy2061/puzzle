package exam;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * 找出满足下述条件的下标对 (i, j)：
 * i != j
 * abs(i - j) <= indexDiff
 * abs(nums[i] - nums[j]) <= valueDiff
 * 如果存在，返回 1 ；否则，返回 0
 */
public class M12ContainsDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        String[] numStr = input[0].split(" ");
        int[] nums = new int[numStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        int indexDiff = Integer.parseInt(input[1]);
        int valueDiff = Integer.parseInt(input[2]);

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceil = set.ceiling(nums[i] - valueDiff);
            if (ceil != null && ceil <= nums[i] + valueDiff) {
                System.out.println(1);
                return;
            }
            set.add(nums[i]);
            if (set.size() > indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        System.out.println(0);
    }
}
