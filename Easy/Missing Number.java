class Solution {
    public int missingNumber(int[] nums) {
        int missingNum = 0;
        int checker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != checker) {
                return missingNum;
            }
            checker++;
            missingNum++;
        }
        return missingNum++;
    }
}
