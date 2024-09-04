package exam;

import java.util.HashSet;
import java.util.Scanner;

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
        for (int a : array1) {
            int b = (int) (a - delta);
            if (set2.contains(b)) {
                System.out.println(a + " " + b);
                return;
            }
        }
        System.out.println();
    }
}
