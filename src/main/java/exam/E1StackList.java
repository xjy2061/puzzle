package exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 注意：返回的的字符串结果需要是小写的格式
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class E1StackList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ops = scanner.nextLine().split(",");
        String[] params = scanner.nextLine().split(",");
        MyQueue queue = new MyQueue();
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            switch (op) {
                case "push":
                    queue.push(Integer.parseInt(params[i]));
                    ret.add("null");
                    break;
                case "pop":
                    ret.add(String.valueOf(queue.pop()));
                    break;
                case "peek":
                    ret.add(String.valueOf(queue.peak()));
                    break;
                case "empty":
                    ret.add(String.valueOf(queue.empty()));
                    break;
            }
        }
        System.out.println(String.join(",", ret));
    }

    static class MyQueue {
        final LinkedList<Integer> list = new LinkedList<>();
        void push(int x) {
            list.add(x);
        }

        int pop() {
            return list.pop();
        }

        @SuppressWarnings("DataFlowIssue")
        int peak() {
            return list.peek();
        }

        boolean empty() {
            return list.isEmpty();
        }
    }
}
