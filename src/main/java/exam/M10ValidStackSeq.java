package exam;

import java.util.Scanner;
import java.util.Stack;

public class M10ValidStackSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pushed = scanner.nextLine().split(",");
        String[] popped = scanner.nextLine().split(",");
        Stack<String> stack = new Stack<>();
        int i = 0;
        for (String s : pushed) {
            stack.push(s);
            while (!stack.isEmpty() && stack.peek().equals(popped[i])) {
                stack.pop();
                i++;
            }
        }
        System.out.println(stack.isEmpty());
    }
}
