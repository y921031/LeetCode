public class lt_09_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int original = x, reversed = 0;
        while (x != 0) {
            int d = x % 10;
            reversed = reversed * 10 + d;
            x /= 10;
        }
        return original == reversed;
    }
}
