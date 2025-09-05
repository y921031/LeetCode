// 題目：Count and Say
// 給定一個正整數 n，回傳「數數列」的第 n 項。
// 數數列定義：
// countAndSay(1) = "1"
// countAndSay(n) 為 countAndSay(n-1) 的 Run-Length Encoding 結果。
// 例如：countAndSay(4) = "1211"

class lt_38_countAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1"; // base case

        String prev = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            int count = 1;
            for (int j = 0; j < prev.length(); j++) {
                if (j + 1 < prev.length() && prev.charAt(j) == prev.charAt(j + 1)) {
                    count++;
                } else {
                    cur.append(count).append(prev.charAt(j));
                    count = 1;
                }
            }
            prev = cur.toString();
        }
        return prev;
    }
}

class Main {
    public static void main(String[] args) {
        lt_38_countAndSay sol = new lt_38_countAndSay();
        System.out.println(sol.countAndSay(1)); // 1
        System.out.println(sol.countAndSay(4)); // 1211
        System.out.println(sol.countAndSay(6)); // 312211
    }
}
