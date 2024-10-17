package exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 给两个整型数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。输出结果按照从小到大排列。
 * 例如： nums1的内容是[1,2,6,5,9,8]，nums2的内容是[3,9,6]，最后输出的结果是[6,9]。
 */
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
