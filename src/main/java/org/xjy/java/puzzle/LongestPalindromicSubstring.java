package org.xjy.java.puzzle;

import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
	
	private static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		
		//add boundaries
		int length = s.length();
		char[] s2 = new char[2 * length + 1];
		for (int i = 0; i < length; i++) {
			int i2 = 2 * i;
			s2[i2] = '|';
			s2[i2 + 1] = s.charAt(i);
		}
		s2[s2.length - 1] = '|';
		
		int[] p = new int[s2.length];
		int c = 0;
		int r = 0;
		int m = 0;
		int n = 0;
		for (int i = 1; i < s2.length - 1; i++) {
			if (i > r) {
				p[i] = 0;
				m = i - 1;
				n = i + 1;
			} else {
				int i2 = 2 * c - i;
				if (p[i2] < r - i - 1) {
					p[i] = p[i2];
					m = -1;
				} else {
					p[i] = r - i;
					n = r + 1;
					m = 2 * i - n;
				}
			}
			while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
				p[i]++;
				m--;
				n++;
			}
			if (i + p[i] > r) {
				c = i;
				r = i + p[i];
			}
		}
		c = 0;
		int max = 0;
		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] > max) {
				c = i;
				max = p[i];
			}
		}
		char[] s3 = Arrays.copyOfRange(s2, c - max, c + max + 1);
		
		//remove boundaries
		char[] s4 = new char[s3.length / 2];
		for (int i = 0; i < s4.length; i++) {
			s4[i] = s3[2 * i + 1];
		}
		
		return new String(s4);
    }
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
	}
}
