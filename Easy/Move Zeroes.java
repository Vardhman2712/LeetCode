class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0; // pointer to track the position to place non-zero elements

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, place it at the next available position
            if (nums[i] != 0) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }

        // Fill the remaining positions with zeros
        while (pointer < nums.length) {
            nums[pointer] = 0;
            pointer++;
        }
    }
}
