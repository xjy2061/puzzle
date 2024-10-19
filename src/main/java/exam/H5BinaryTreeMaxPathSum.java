package exam;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class H5BinaryTreeMaxPathSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        Node root = new Node(Integer.parseInt(input[0]));
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < input.length; i += 2) {
            Node node = list.remove();
            Node left = input[i].equals("null") ? null : new Node(Integer.parseInt(input[i]));
            int next = i + 1;
            Node right = next >= input.length || input[next].equals("null") ? null : new Node(Integer.parseInt(input[next]));
            node.left = left;
            node.right = right;
            if (left != null) {
                list.add(left);
            }
            if (right != null) {
                list.add(right);
            }
        }

        int[] ret = {Integer.MIN_VALUE};
        maxGain(root, ret);
        System.out.println(ret[0]);
    }

    static int maxGain(Node node, int[] ret) {
        if (node == null) {
            return 0;
        }
        int lGain = Math.max(maxGain(node.left, ret), 0);
        int rGain = Math.max(maxGain(node.right, ret), 0);
        int pathSum = node.value + lGain + rGain;
        ret[0] = Math.max(ret[0], pathSum);
        return node.value + Math.max(lGain, rGain);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}
