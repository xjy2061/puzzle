package exam;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须在之后有相同类型的右括号配对，配对仅能一次
 * 所有类型的括号必须以正确的顺序配对，先有左括号，再有右括号
 * 括号要按顺序配对，不能出现不同类型的括号相互交叠
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 * 运行有时间和内存限制
 */
public class E25ValidBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    System.out.println(0);
                    return;
                }
            } else {
                stack.push(c);
            }
        }
        System.out.println(stack.isEmpty() ? 1 : 0);
    }
}
