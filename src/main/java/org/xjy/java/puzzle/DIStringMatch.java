package org.xjy.java.puzzle;

import java.util.Arrays;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 * Example 1:
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 *
 * Example 2:
 * Input: "III"
 * Output: [0,1,2,3]
 *
 * Example 3:
 * Input: "DDI"
 * Output: [3,2,0,1]
 *
 *
 * Note:
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */
public class DIStringMatch {

    private static int[] diStringMatch(String s) {
        int n = s.length();
        int[] ret = new int[n + 1];
        int low = 0;
        int high = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ret[i] = low++;
            } else {
                ret[i] = high--;
            }
        }
        ret[n] = low;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));
    }
}
