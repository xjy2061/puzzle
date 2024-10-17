package exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class E11MinStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ops = scanner.nextLine().split(",");
        String[] params = scanner.nextLine().split(",");
        MyStack stack = new MyStack();
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "push":
                    stack.push(Integer.parseInt(params[i]));
                    ret.add("null");
                    break;
                case "pop":
                    stack.pop();
                    ret.add("null");
                    break;
                case "top":
                    ret.add(String.valueOf(stack.top()));
                    break;
                case "getMin":
                    ret.add(String.valueOf(stack.getMin()));
                    break;
            }
        }
        System.out.println(String.join(",", ret));
    }

    static class MyStack {
        final LinkedList<Integer> list = new LinkedList<>();
        void push(int val) {
            list.push(val);
        }

        void pop() {
            list.pop();
        }

        int top() {
            return list.getFirst();
        }

        int getMin() {
            int min = Integer.MAX_VALUE;
            for (Integer i : list) {
                if (i < min) {
                    min = i;
                }
            }
            return min;
        }
    }
}
