package exam;

import java.util.LinkedList;
import java.util.Scanner;

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
        maxPathSum(root, ret);
        System.out.println(ret[0]);
    }

    static int maxPathSum(Node node, int[] ret) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(maxPathSum(node.left, ret), 0);
        int right = Math.max(maxPathSum(node.right, ret), 0);
        ret[0] = Math.max(ret[0], node.value + left + right);
        return node.value + Math.max(left, right);
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
