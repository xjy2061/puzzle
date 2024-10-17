package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 括号只考虑 "(" 和 ")" ，有效的括号是指一系列左括号 "(" 和 ")" 组成；但是如果有一些额外的括号，使得括号不能正确配对，就需要删除。
 * 删除规则：从前往后，且尽可能少的删除多余括号。
 */
public class M3DeleteBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int len = input.length();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    indexList.add(stack.pop());
                    indexList.add(i);
                }
            } else {
                indexList.add(i);
            }
        }
        Collections.sort(indexList);
        StringBuilder sb = new StringBuilder();
        for (Integer i : indexList) {
            sb.append(input.charAt(i));
        }
        System.out.println(sb);
    }
}
