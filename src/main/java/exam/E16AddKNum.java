package exam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
 * 返回追加到 nums 中的 k 个整数之和。
 */
public class E16AddKNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> nums = new HashSet<>();
        for (String n : scanner.nextLine().split(" ")) {
            nums.add(Integer.parseInt(n));
        }
        int k = scanner.nextInt();
        int sum = 0;
        int cur = 1;
        while (k > 0) {
            if (!nums.contains(cur)) {
                sum += cur;
                k--;
            }
            cur++;
        }
        System.out.println(sum);
    }
}
