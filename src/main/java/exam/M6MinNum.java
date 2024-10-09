package exam;

import java.util.Arrays;
import java.util.Scanner;

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
