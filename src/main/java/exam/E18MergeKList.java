package exam;

import java.util.Arrays;
import java.util.Scanner;

public class E18MergeKList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("[]")) {
            System.out.println("[]");
            return;
        }
        String[] strLists = input.substring(2, input.length() - 2).split("],\\[");
        int[][] lists = new int[strLists.length][];
        for (int i = 0; i < lists.length; i++) {
            if (strLists[i].isEmpty()) {
                lists[i] = new int[0];
                continue;
            }
            String[] strList = strLists[i].split(",");
            int[] list = new int[strList.length];
            for (int j = 0; j < list.length; j++) {
                list[j] = Integer.parseInt(strList[j]);
            }
            lists[i] = list;
        }
        int total = 0;
        for (int[] list : lists) {
            total += list.length;
        }
        int[] ret = new int[total];
        int[] indexes = new int[lists.length];
        for (int i = 0; i < ret.length; i++) {
            int min = Integer.MAX_VALUE;
            int picked = -1;
            for (int j = 0; j < lists.length; j++) {
                if (indexes[j] < lists[j].length && lists[j][indexes[j]] < min) {
                    min = lists[j][indexes[j]];
                    picked = j;
                }
            }
            indexes[picked]++;
            ret[i] = min;
        }
        System.out.println(Arrays.toString(ret));
    }
}
