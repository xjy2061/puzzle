package exam;

import java.util.*;

/**
 * 从实验室出来后，你忽然发现你居然把自己的电脑落在了实验室里，但是实验室的老师已经把大门锁上了。
 * 更糟的是，你没有那个老师的电话号码。你开始给你知道的所有人打电话，询问他们有没有老师的电话，如果没有，他们也会问自己的同学来询问电话号码。
 * 那么，你能联系到老师并且拿到电脑吗？
 */
public class M16CallTeacher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String teacher = input[0];
        int count = Integer.parseInt(input[1]);
        HashSet<String> teacherContacts = new HashSet<>();
        HashMap<String, HashSet<String>> contactMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] contact = scanner.nextLine().split(" ");
            if (teacher.equals(contact[1])) {
                teacherContacts.add(contact[1]);
            }
            HashSet<String> contacts = contactMap.get(contact[0]);
            if (contacts == null) {
                contacts = new HashSet<>();
                contactMap.put(contact[0], contacts);
            }
            contacts.add(contact[1]);
        }
        LinkedList<String> list = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        list.add("1");
        visited.add("1");
        while (!list.isEmpty()) {
            String person = list.poll();
            if (teacherContacts.contains(person)) {
                System.out.println("Yes");
                return;
            }
            HashSet<String> contacts = contactMap.get(person);
            if (contacts != null) {
                for (String contact : contacts) {
                    if (!visited.contains(contact)) {
                        list.add(contact);
                        visited.add(contact);
                    }
                }
            }
        }
        System.out.println("No");
    }
}
