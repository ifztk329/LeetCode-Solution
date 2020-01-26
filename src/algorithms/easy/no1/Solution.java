package algorithms.easy.no1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/two-sum/submissions/
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 *
 */
class BruteForce {
    /**
     * 57 ms
     * 39.6 MB
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;

    }
}

/**
 * Two-pass Hash Table
 */
class TwoPassHashTable {
    /**
     * 2 ms
     * 41.8 MB
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }

        return null;
    }
}

/**
 * One-pass Hash Table
 */
class OnePassHashTable {

    /**
     * 1 ms
     * 41.8 MB
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}