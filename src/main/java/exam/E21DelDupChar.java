package exam;

import java.util.Scanner;
import java.util.Stack;

public class E21DelDupChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] array = s.toCharArray();
        char[] counts = new char[128];
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[128];
        for (char c : array) {
            counts[c]++;
        }
        for (char c : array) {
            counts[c]--;
            if (seen[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && counts[stack.peek()] > 0) {
                seen[stack.pop()] = false;
            }
            stack.push(c);
            seen[c] = true;
        }
        StringBuilder ret = new StringBuilder();
        for (Character c : stack) {
            ret.append(c);
        }
        System.out.println(ret);
    }
}
