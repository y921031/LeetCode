public class lt_12_IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }
}

/*
 * 解題思路：
 * 1. 使用對照表，把數字與羅馬數字符號配對。
 * 2. 從大到小檢查，能減多少就減多少，並加上對應的羅馬符號。
 * 3. 特殊情況 (4, 9, 40, 90, 400, 900) 事先放到對照表。
 * 時間複雜度：O(1)，因為數字範圍最大是 3999，迴圈最多跑有限次。
 */
