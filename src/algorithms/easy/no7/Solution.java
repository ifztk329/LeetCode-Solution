package algorithms.easy.no7;

import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 */
class Solution {

    /**
     * 3 ms
     * 36.9 MB
     * @param x
     * @return
     */
    public static int reverse(int x) {

        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();

        //assume that your function returns 0 when the reversed integer overflows
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

/**
 * Pop and Push Digits & Check before Overflow
 */
class PopAndPushDigitsAndCheckBeforeOverflow {

    /**
     * 1 ms
     * 36.5 MB
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;

            x = x / 10;

            /**
             *
             * Integer.MAX_VALUE == 2147483647
             * Integer.MIN_VALUE == -2147483648
             *
             * 如果rev = rev * 10 + pop造成溢出，此时一定有rev ≥ INTMAX / 10。
             * 如果rev > INTMAX / 10，rev = rev * 10 + pop 一定会溢出。
             * 如果rev == INTMAX / 10，rev = rev * 10 + pop当且仅当pop > 7时溢出。
             * 当rev是负数时，也是相同的逻辑。
             */
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }

        return rev;
    }
}