package exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

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
