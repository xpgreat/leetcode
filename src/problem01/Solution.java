package problem01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xp
 * @Date: 2019/1/1
 *
 * <p>1.最简单的解法就是暴力破解，双重循环实现遍历，f(n)= O(n^2)</p>
 * <p>2.利用散列性质，实现f(n) = O(n)</p>
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> number = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (number.containsKey(complement)) {
                result[0] = i;
                result[1] = number.get(complement);
                return result;
            }
            number.put(nums[i], i);
        }
        return null;
    }
}
