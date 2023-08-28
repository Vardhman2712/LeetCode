class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Create frequency maps for both arrays
        Map<Integer, Integer> freqMap1 = new HashMap<>();
        Map<Integer, Integer> freqMap2 = new HashMap<>();
        
        // Populate frequency maps for nums1 and nums2
        for (int num : nums1) {
            freqMap1.put(num, freqMap1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            freqMap2.put(num, freqMap2.getOrDefault(num, 0) + 1);
        }
        
        // Find the common elements and their frequencies
        List<Integer> resultList = new ArrayList<>();
        for (int num : freqMap1.keySet()) {
            if (freqMap2.containsKey(num)) {
                int count = Math.min(freqMap1.get(num), freqMap2.get(num));
                for (int i = 0; i < count; i++) {
                    resultList.add(num);
                }
            }
        }
        
        // Convert the result list to an array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}
