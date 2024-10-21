package exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 1 ；否则，返回 0 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 */
public class M1SubArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int k = scanner.nextInt();
        if (nums.length < 2) {
            System.out.println(0);
            return;
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            Integer pre = map.get(mod);
            if (pre != null) {
                if (i - pre > 1) {
                    System.out.println(1);
                    return;
                }
            } else {
                map.put(mod, i);
            }
        }
        System.out.println(0);
    }
}
