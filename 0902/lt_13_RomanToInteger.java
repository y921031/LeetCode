import java.util.*;

public class lt_13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i + 1 < s.length() && val < map.get(s.charAt(i + 1))) {
                total -= val; // 減法情況
            } else {
                total += val;
            }
        }
        return total;
    }
}

/*
 * 解題思路：
 * 1. 建立符號對應數值的表。
 * 2. 從左到右掃描字串：
 * - 若當前符號小於右邊符號，則代表是減法，扣掉該值。
 * - 否則加上該值。
 * 3. 累加完成後即是整數值。
 * 時間複雜度：O(n)，n 為字串長度。
 */
