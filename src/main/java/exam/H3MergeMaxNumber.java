package exam;

import java.util.Scanner;

public class H3MergeMaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] arr1 = new int[input.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(input[i]);
        }
        input = scanner.nextLine().split(",");
        int[] arr2 = new int[input.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(input[i]);
        }
        int k = scanner.nextInt();

        int[] max = new int[k];
        for (int i = Math.max(0, k - arr2.length); i < Math.min(k, arr1.length); i++) {
            int[] max1 = maxSubArray(arr1, i);
            int[] max2 = maxSubArray(arr2, k - i);
            int[] curMax = merge(max1, max2);
            if (greater(curMax, 0, max, 0)) {
                max = curMax;
            }
        }
        for (int i = 0; i < max.length; i++) {
            if (i != 0) {
                System.out.print(",");
            }
            System.out.print(max[i]);
        }
    }

    static int[] maxSubArray(int[] array, int k) {
        int[] ret = new int[k];
        int top = 0;
        int remain = array.length - k;
        for (int i : array) {
            while(top > 0 && ret[top - 1] < i && remain > 0) {
                top--;
                remain--;
            }
            if (top < k) {
                ret[top++] = i;
            } else {
                remain--;
            }
        }
        return ret;
    }

    static int[] merge(int[] a, int[] b) {
        int[] ret = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (greater(a, i, b, j)) {
                ret[k++] = a[i++];
            } else {
                ret[k++] = b[j++];
            }
        }
        while (i < a.length) {
            ret[k++] = a[i++];
        }
        while (j < b.length) {
            ret[k++] = b[j++];
        }
        return ret;
    }

    static boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}
