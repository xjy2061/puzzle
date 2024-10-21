package exam;

import java.util.*;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class E10StoneWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        LinkedList<Integer> stones = new LinkedList<>();
        for (String s : input) {
            stones.add(Integer.parseInt(s));
        }

        Collections.sort(stones);
        while (stones.size() > 1) {
            int s1 = stones.removeLast();
            int s2 = stones.removeLast();
            int remain = s1 - s2;
            if (remain == 0) {
                continue;
            } else if (!stones.isEmpty() && remain == stones.peekLast()) {
                stones.removeLast();
                continue;
            }
            for (int i = 0, size = stones.size(); i < size; i++) {
                if (stones.get(i) > remain) {
                    stones.add(i, remain);
                    break;
                }
            }
        }
        System.out.println(stones.isEmpty() ? 0 : stones.get(0));
    }
}
