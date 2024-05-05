package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class DeleteBrackets {
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
