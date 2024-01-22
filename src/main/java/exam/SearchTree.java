package exam;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        Node root =  input[0].equals("null") ? null : new Node(Integer.parseInt(input[0]));
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        for (int i = 1, len = input.length; i < len; i += 2) {
            Node node = nodes.remove();
            Node left = input[i].equals("null") ? null : new Node(Integer.parseInt(input[i]));
            int next = i + i;
            Node right = (next >= len || input[next].equals("null")) ? null : new Node(Integer.parseInt(input[next]));
            if (node != null) {
                node.left = left;
                node.right = right;
            }
            nodes.add(left);
            nodes.add(right);
        }

        System.out.println(isBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    private static boolean isBST(Node root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.value <= min || root.value >= max) {
            return false;
        }
        return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
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
