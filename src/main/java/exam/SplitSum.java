package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class SplitSum {
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
