package exam;

import java.util.HashMap;
import java.util.Scanner;

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
            sum %= k;
            Integer pre = map.get(sum);
            if (pre != null) {
                if (i - pre > 1) {
                    System.out.println(1);
                    return;
                }
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(0);
    }
}
