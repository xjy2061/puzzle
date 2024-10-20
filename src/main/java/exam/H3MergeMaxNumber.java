package exam;

import java.util.Scanner;

/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (0 <=k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 */
public class H3MergeMaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] nums1 = new int[input.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.parseInt(input[i]);
        }
        input = scanner.nextLine().split(",");
        int[] nums2 = new int[input.length];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = Integer.parseInt(input[i]);
        }
        int k = scanner.nextInt();

        int m = nums1.length;
        int n = nums2.length;
        int[] max = new int[k];
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] sub1 = maxSubArray(nums1, i);
            int[] sub2 = maxSubArray(nums2, k - i);
            int[] merged = merge(sub1, sub2);
            if (greater(merged, 0, max, 0)) {
                max = merged;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(max[i]);
        }
        System.out.println(sb);
    }

    static int[] maxSubArray(int[] a, int k) {
        int[] ret = new int[k];
        int n = a.length;
        int top = 0;
        int remain = n - k;
        for (int i = 0; i < n; i++) {
            while (top > 0 && ret[top - 1] < a[i] && remain > 0) {
                top--;
                remain--;
            }
            if (top < k) {
                ret[top++] = a[i];
            } else {
                remain--;
            }
        }
        return ret;
    }

    static int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] ret = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (greater(a, i, b, j)) {
                ret[k++] = a[i++];
            } else {
                ret[k++] = b[j++];
            }
        }
        while (i < m) {
            ret[k++] = a[i++];
        }
        while (j < n) {
            ret[k++] = b[j++];
        }
        return ret;
    }

    static boolean greater(int[] a, int i, int[] b, int j) {
        int m = a.length;
        int n = b.length;
        while (i < m && j < n && a[i] == b[j]) {
            i++;
            j++;
        }
        return j == n || (i < m && a[i] > b[j]);
    }
}
