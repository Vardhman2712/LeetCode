class Solution {
    public static int thirdMax(int[] nums) {
        // Initialize the three maximum variables
        long max1 = Long.MIN_VALUE; // Maximum
        long max2 = Long.MIN_VALUE; // Second maximum
        long max3 = Long.MIN_VALUE; // Third maximum

        // Iterate through the array
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num < max1 && num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num < max2 && num > max3) {
                max3 = num;
            }
        }

        // If the third maximum doesn't exist, return the maximum
        return (max3 == Long.MIN_VALUE) ? (int) max1 : (int) max3;
    }
}
