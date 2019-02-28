package problem05;

import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * @Author xp
 * @Date：2019-02-26
 */
public class Solution {
    /**
     * 题目描述：Longest Palindromic Substring
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * <p>
     * 思路：观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，
     * 并且只有 2n - 1 个这样的中心，例：aba(n种),abba(n-1种)两种情况
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLength(s, i, i);
            int len2 = getLength(s, i, i + 1);
            int length = len1 > len2 ? len1 : len2;
            if (length > (end - start)) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int getLength(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        String s = "acbbaba";
        System.out.println(s.substring(3, 5));

    }
}
