package problem03;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author xp
 * @Date：2019-02-25
 */
public class Solution {
    /**
     * 题目描述： Longest Substring Without Repeating Characters
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * <p>
     * 思路：做一个类似滑动窗口，然后如果没有值右边滑动，否则左边滑动，记录最大值
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i=0,j=0,length=s.length();
        while (i<length&&j<length){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = max > (j-i) ? max : (j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s="dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
