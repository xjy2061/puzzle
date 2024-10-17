package exam;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 */
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
