package exam;

import java.util.Scanner;

public class E27RangeSumCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int lower = scanner.nextInt();
        int upper = scanner.nextInt();
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int count = 0;
        for (int j = 1; j < prefixSum.length; j++) {
            for (int i = 0; i < j; i++) {
                long sum = prefixSum[j] - prefixSum[i];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
