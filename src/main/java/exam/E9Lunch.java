package exam;

import java.util.LinkedList;
import java.util.Scanner;

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
