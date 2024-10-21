package exam;

import java.util.*;

/**
 * 给定两个链表L1=a1→a2→⋯→an−1→an 和L2=b1→b2→⋯→bm−1→bm，其中n≥2m。
 * 需要将较短的链表L2反转并合并到较长的链表L1中
 * 使得合并后的链表如下形式：a1→a2→bm→a3→a4→bm−1→…
 * 合并规则：在长链表中每隔两个元素，将短链表中的元素倒序插入。
 * 例如：给定一个较长链表1→2→3→4→5，另外一个较短链表6→7，需要输出1→2→7→3→4→6→5
 */
public class H1MergeLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String head1 = input[0];
        String head2 = input[1];
        int n = Integer.parseInt(input[2]);
        HashMap<String, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine().split(" ");
            map.put(input[0], new Node(input[0], input[1], input[2]));
        }
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();
        String addr = head1;
        while (!addr.equals("-1")) {
            Node node = map.get(addr);
            list1.add(node);
            addr = node.next;
        }
        addr = head2;
        while (!addr.equals("-1")) {
            Node node = map.get(addr);
            list2.add(node);
            addr = node.next;
        }

        int len1 = list1.size();
        int len2 = list2.size();
        if (len2 > len1) {
            ArrayList<Node> tempList = list1;
            list1 = list2;
            list2 = tempList;
            len1 = list1.size();
            len2 = list2.size();
        }
        for (int i = 0, j = len2 - 1; i < len1; i++) {
            Node node1 = list1.get(i);
            Node node2 = null;
            if (i % 2 == 1 && j >= 0) {
                node2 = list2.get(j--);
                node1.next = node2.addr;
                int next = i + 1;
                if (next < len1) {
                    node2.next = list1.get(next).addr;
                }
            }
            System.out.println(node1);
            if (node2 != null) {
                System.out.println(node2);
            }
        }
    }

    static class Node {
        String addr;
        String data;
        String next;

        Node(String addr, String data, String next) {
            this.addr = addr;
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return addr + " " + data + " " + next;
        }
    }
}