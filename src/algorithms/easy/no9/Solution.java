package algorithms.easy.no9;

/**
 *
 * https://leetcode.com/problems/palindrome-number/submissions/
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 *
 * Coud you solve it without converting the integer to a string?
 */
class Solution {
    /**
     * 6 ms
     * 40.5 MB
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        if (x < 0) { return false; }
        if (x == 0) { return true; }

        //reverse int like no7
        int rev = 0;
        int storeX = x;

        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) { return false; }

            rev = rev * 10 + pop;
        }
        return storeX == rev ? true : false;
    }

}

/**
 * 相比于类似no7的解法，本题可以考虑只翻转一半的数字即可
 * 翻转一半的话就不用考虑翻转后超出Integer.MAX_VALUE的问题
 */
class RevertHalfOfTheNumber {

    /**
     * 6 ms
     * 40.4 MB
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}