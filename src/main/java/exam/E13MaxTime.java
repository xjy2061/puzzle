package exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * 24 小时格式为HH:MM ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59。
 * 以长度为 5 的字符串，按 HH:MM 格式返回答案。如果不能确定有效时间，则返回空字符串。
 */
public class E13MaxTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        ArrayList<int[]> permutations = new ArrayList<>();
        permute(nums, 0, permutations);
        int max = -1;
        String ret = "";
        for (int[] permutation : permutations) {
            int hour = permutation[0] * 10 + permutation[1];
            int minute = permutation[2] * 10 + permutation[3];
            if (hour < 24 && minute < 60) {
                int time = hour * 60 + minute;
                if (time > max) {
                    max = time;
                    ret = String.format("%02d:%02d", hour, minute);
                }
            }
        }
        System.out.println(ret);
    }

    private static void permute(int[] nums, int start, ArrayList<int[]> permutations) {
        if (start == nums.length) {
            permutations.add(nums.clone());
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, permutations);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
