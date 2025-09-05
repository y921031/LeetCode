
// 題目：Longest Valid Parentheses
// 給定一個只包含 '(' 和 ')' 的字串，找出最長的有效括號長度。
import java.util.Stack;

public class lt_32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 初始化基準索引
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // 左括號入棧
            } else {
                stack.pop(); // 右括號出棧
                if (stack.isEmpty()) {
                    stack.push(i); // 棧空時更新基準索引
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek()); // 更新最大長度
                }
            }
        }
        return maxLen;
    }
}
/*
 * 解題思路：
 * 1. 使用 Stack 儲存索引，遇到左括號入棧，右括號出棧。
 * 2. 當棧空時記錄新的基準點。
 * 3. 每次有效配對後更新最大長度。
 */
