package exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class E26ArrayIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");
        HashSet<Integer> set1 = new HashSet<>();
        for (String s : input[0].split(",")) {
            set1.add(Integer.parseInt(s));
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (String s : input[1].split(",")) {
            int i = Integer.parseInt(s);
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set2);
        list.sort(null);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ret.append(list.get(i));
            if (i != list.size() - 1) {
                ret.append(",");
            }
        }
        System.out.println(ret);
    }
}
