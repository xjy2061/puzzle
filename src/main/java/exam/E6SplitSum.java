package exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 对于给定的正整数k，将其表示为一个正整数序列之和，且该序列中相邻元素的差值为等差分布（等差分布从1开始，差值为1，即1,2,3,...,）
 * 注意：请打印出所有可能的序列（打印多个序列时，按照首个数字从小到大依次打印）
 */
public class E6SplitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        ArrayList<ArrayList<Integer>> seqs = new ArrayList<>();
        int start = 1;
        int half = k / 2;
        while (start <= half) {
            int cur = start;
            int sum = 0;
            int i = 0;
            ArrayList<Integer> seq = new ArrayList<>();
            while (sum < k) {
                cur += i;
                sum += cur;
                seq.add(cur);
                i++;
            }
            if (sum == k) {
                seqs.add(seq);
            }
            start++;
        }
        System.out.println(seqs);
    }
}
