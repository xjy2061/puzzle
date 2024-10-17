package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一组非0整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最小的整数。
 * 注意：
 * 输入整数数组中，可能存在负数，但最多只会有一个负数
 * 输出结果可能非常小，所以你需要返回一个字符串而不是整数。
 */
public class M6MinNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        Arrays.sort(nums, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder ret = new StringBuilder();
        if (nums[0].startsWith("-")) {
            ret.append(nums[0]);
            for (int i = nums.length - 1; i > 0; i--) {
                ret.append(nums[i]);
            }
        } else {
            for (String num : nums) {
                ret.append(num);
            }
        }
        System.out.println(ret);
    }
}
