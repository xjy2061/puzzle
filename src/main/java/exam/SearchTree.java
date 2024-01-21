package exam;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        Node tree =  input[0].equals("null") ? null : new Node(Integer.parseInt(input[0]));
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(tree);
        for (int i = 1, len = input.length; i < len; i += 2) {
            Node node = nodes.remove();
            Node left = input[i].equals("null") ? null : new Node(Integer.parseInt(input[i]));
            int next = i + i;
            Node right = next >= len || input[next].equals("null") ? null : new Node(Integer.parseInt(input[next]));
            node.left = left;
            node.right = right;
            if (left != null) {
                nodes.add(left);
            }
            if (right != null) {
                nodes.add(right);
            }
        }

        System.out.println(inorder(tree));
    }

    private static int prev;

    private static boolean inorder(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }
        if (!inorder(node.left)) {
            return false;
        }
        if (prev >= node.value) {
            return false;
        } else {
            prev = node.value;
        }
        return inorder(node.right);
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
