package org.xjy.java.puzzle;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Note: The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows. 
 */
public class ReverseInteger {
	public static int reverse(int x) {
		boolean negative = x < 0;
		x = Math.abs(x);
		long y = 0;
		while (x > 0) {
			y = y * 10 + x % 10;
			x /= 10;
		}
		y = negative ? -y : y;
        return y >= Integer.MIN_VALUE && y <= Integer.MAX_VALUE ? (int) y : 0;
    }
	
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
}
