class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }
}

LINK OF THE QUESTION :- "https://leetcode.com/problems/remove-duplicates-from-sorted-array/"
