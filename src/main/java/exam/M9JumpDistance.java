package exam;

import java.util.Scanner;

/**
 * 给定一个非负整数数组nums，最初位于数组的第一个位置；数组中的每个元素表示你在该位置可以跳跃的最大长度。
 * 请确定是否可以到达最后一个位置。
 */
public class M9JumpDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                System.out.println(false);
                return;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
