package exam;

import java.util.Scanner;

/**
 * 给你一个整数数组 arr 。将 arr 分割成若干 块 ，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 返回能将数组分成的最多块数？
 */
public class H11MaxBlockToMakeSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        int[] rightMin = new int[arr.length];
        rightMin[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                count++;
            }
        }
        System.out.println(count + 1);
    }
}
