package exam;

import java.util.Scanner;

/**
 * 给你一个整数数组 perm ，它是前 n 个正整数（1,2,3,4,5,…,n-1,n 共n个正整数）的排列，且 n 是个奇数 。
 * 它被加密成另一个长度为 n-1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i+1]。比方说，如果 perm=[1,3,2] ，那么 encoded=[2,1]。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * 提示：
 * n 是奇数。
 * 3 <= n < 10^5
 * encoded.length == n - 1
 */
public class H8DecodeXor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] encoded = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            encoded[i] = Integer.parseInt(input[i]);
        }

        int n = encoded.length + 1;
        int totalXor = 0;
        for (int i = 1; i <= n; i++) {
            totalXor ^= i;
        }
        int encodedXor = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            encodedXor ^= encoded[i];
        }
        int first = totalXor ^ encodedXor;
        int[] perm = new int[n];
        perm[0] = first;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(perm[i]);
        }
        System.out.println(sb);
    }
}