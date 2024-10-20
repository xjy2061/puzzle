package exam;

import java.util.*;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 * 若有多个答案，返回所有满足条件的答案。若无满足条件的数值，不输出。
 */
public class E14SwapSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        int[] array1 = new int[input1.length];
        int[] array2 = new int[input2.length];
        long s1 = 0;
        long s2 = 0;
        for (int i = 0; i < input1.length; i++) {
            array1[i] = Integer.parseInt(input1[i]);
            s1 += array1[i];
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < input2.length; i++) {
            array2[i] = Integer.parseInt(input2[i]);
            s2 += array2[i];
            set2.add(array2[i]);
        }
        long delta = s1 - s2;
        if (delta % 2 != 0) {
            System.out.println();
            return;
        }
        delta = (s1 - s2) / 2;
        Arrays.sort(array1);
        HashSet<Integer> set1 = new HashSet<>();
        for (int a : array1) {
            if (set1.contains(a)) {
                continue;
            }
            set1.add(a);
            int b = (int) (a - delta);
            if (set2.contains(b)) {
                System.out.println(a + " " + b);
                return;
            }
        }
        System.out.println();
    }
}
