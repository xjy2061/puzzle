package exam;

import java.util.HashMap;
import java.util.Scanner;

public class M13DelDuplicate {
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

        Node dummy = new Node("", "", "");
        dummy.next = head;
        Node prev = dummy;
        while (head != null) {
            int count = 0;
            current = head;
            while (current != null && current.data.equals(head.data)) {
                count++;
                current = current.next;
            }
            if (count > 2) {
                prev.next = current;
                prev.nextAddress = current == null ? "-1" : current.address;
            } else {
                prev = head.next == current ? head : head.next;
            }
            head = current;
        }
        current = dummy.next;
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
