package org.xjy.java.puzzle;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * Example 1:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Example 2:
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {

    private static int[] sortedSquares(int[] array) {
        int j = 0;
        while (j < array.length && array[j] < 0) {
            j++;
        }
        int i = j - 1;
        int[] squares = new int[array.length];
        int k = 0;
        while (i >= 0 && j < array.length) {
            int squareNegtive = array[i] * array[i];
            int squarePositive = array[j] * array[j];
            if (squareNegtive < squarePositive) {
                squares[k++] = squareNegtive;
                i--;
            } else {
                squares[k++] = squarePositive;
                j++;
            }
        }
        while (i >= 0) {
            squares[k++] = array[i] * array[i];
            i--;
        }
        while (j < array.length) {
            squares[k++] = array[j] * array[j];
            j++;
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
