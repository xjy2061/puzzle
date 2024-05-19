package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class E16MaxTime {
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
