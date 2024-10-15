package exam;

import java.util.HashMap;
import java.util.Scanner;

public class M14ReorderList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String headAddress = input[0];
        int n = Integer.parseInt(input[1]);
        Node head = null;
        HashMap<String, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] nodeInfo = scanner.nextLine().split(" ");
            Node node = new Node(nodeInfo[0], nodeInfo[1], nodeInfo[2]);
            if (node.address.equals(headAddress)) {
                head = node;
            }
            map.put(node.address, node);
        }
        Node current = head;
        while (current != null) {
            current.next = map.get(current.nextAddress);
            current = current.next;
        }

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        current = slow;
        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            current.nextAddress = prev == null ? "-1" : prev.address;
            prev = current;
            current = temp;
        }
        Node first = head;
        Node second = prev;
        while (second != null && first != second) {
            Node temp = second.next;
            second.next = first;
            second.nextAddress = first.address;
            second = temp;
            temp = first.next;
            first.next = second;
            first.nextAddress = second == null ? "-1" : second.address;
            first = temp;
        }
        current = prev;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    static class Node {
        String address;
        String data;
        String nextAddress;
        Node next;

        Node(String address, String data, String nextAddress) {
            this.address = address;
            this.data = data;
            this.nextAddress = nextAddress;
        }

        @Override
        public String toString() {
            return address + " " + data + " " + nextAddress;
        }
    }
}