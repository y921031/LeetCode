
// 題目：Valid Parentheses
// 僅包含 ()[]{} 的字串 s，判斷是否為有效括號序列。
import java.util.*;

public class lt_20_ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                st.push(')');
            else if (c == '[')
                st.push(']');
            else if (c == '{')
                st.push('}');
            else {
                if (st.isEmpty() || st.pop() != c)
                    return false;
            }
        }
        return st.isEmpty();
    }
}
/*
 * 解題思路：
 * 1) 左括號時把對應的右括號壓入棧；遇到右括號時，必須與棧頂匹配。
 * 2) 中途不匹配或最後棧不空就不是有效序列。
 * 時間複雜度 O(n)，空間 O(n) 最壞情形全是左括號。
 */