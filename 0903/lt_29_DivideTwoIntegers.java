// 題目：Divide Two Integers
// 不使用乘、除、模運算，計算 dividend / divisor 的商（向零截斷），注意 32-bit 溢位邊界。
public class lt_29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // 邊界特判：最小整數 / -1 會溢位
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // 統一轉成負數來處理（負區間多一個值），並記錄符號
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;
        // 透過位移找最大可減倍數
        for (int shift = 31; shift >= 0; shift--) {
            if ((a >> shift) >= b) {
                a -= (b << shift);
                result += (1 << shift);
            }
        }
        return negative ? -result : result;
    }
}
/*
 * 解題思路：
 * 1) 以位移模擬除法：對 divisor 進行 2^k 倍擴張，從高位到低位嘗試減去。
 * 2) 每次能減就累加對應位的商並從被除數扣除。
 * 3) 注意邊界：MIN_VALUE / -1 溢位需特判；用 long 做絕對值避免溢位。
 * 時間 O(32)≈O(1)，空間 O(1)。
 */
