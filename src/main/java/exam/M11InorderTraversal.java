package exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 给定一个二叉树的根节点root，返回它的中序遍历结果。
 */
public class M11InorderTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        Node root = new Node(Integer.parseInt(input[0]));
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        for (int i = 1, len = input.length; i < len; i += 2) {
            Node node = nodes.remove();
            Node left = input[i].equals("null") ? null : new Node(Integer.parseInt(input[i]));
            int next = i + 1;
            Node right = (next >= len || input[next].equals("null")) ? null : new Node(Integer.parseInt(input[next]));
            node.left = left;
            node.right = right;
            if (left != null) {
                nodes.add(left);
            }
            if (right != null) {
                nodes.add(right);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                s.append(",");
            }
            s.append(list.get(i));
        }
        System.out.println(s);
    }

    static void inorderTraversal(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.value);
        inorderTraversal(root.right, list);
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
