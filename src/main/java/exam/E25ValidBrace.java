package exam;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class E25ValidBrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    System.out.println(0);
                    return;
                }
            } else {
                stack.push(c);
            }
        }
        System.out.println(stack.isEmpty() ? 1 : 0);
    }
}
