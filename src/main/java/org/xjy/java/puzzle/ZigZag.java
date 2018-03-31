package org.xjy.java.puzzle;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZag {

    private static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int len = s.length();
        if (len <= numRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int interval = (numRows << 1) - 2;
        for (int i = 0; i < len; i += interval) { //first line
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) { //middle lines
            int step = i << 1;
            for (int j = i; j < len; j += step) {
                sb.append(s.charAt(j));
                step = interval - step;
            }
        }
        for (int i = numRows - 1; i < len; i += interval) { //last line
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("AB", 1));
    }
}
