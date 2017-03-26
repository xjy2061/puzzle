package org.xjy.java.puzzle;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //sliding window
        for (int i = 0, j = 0, n = s.length(); j < n; j++) {
            char c = s.charAt(j);
            Integer k = map.get(c); 
            if (k != null) {
                i = Math.max(i, k + 1);
        	}
            maxLen = Math.max(maxLen, j - i + 1);
            map.put(c, j);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
