package exam;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 */
public class E9Lunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        LinkedList<Integer> students = new LinkedList<>();
        for (String s : input) {
            students.add(Integer.parseInt(s));
        }
        input = scanner.nextLine().split(" ");
        LinkedList<Integer> sandwiches = new LinkedList<>();
        for (String s : input) {
            sandwiches.add(Integer.parseInt(s));
        }
        int count = 0;
        while (!students.isEmpty() ) {
            if (students.peek().equals(sandwiches.peek())) {
                students.remove();
                sandwiches.remove();
                count = 0;
            } else {
                students.add(students.remove());
                count++;
                if (count == students.size()) {
                    break;
                }
            }
        }
        System.out.println(students.size());
    }
}
