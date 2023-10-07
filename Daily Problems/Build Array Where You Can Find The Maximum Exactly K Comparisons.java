
class Solution {
    public int numOfArrays(int n, int m, int k) {
        Map<String, Integer> memo = new HashMap<>();
        int base = (int) (Math.pow(10, 9) + 7);

        return aux(0, -1, 0, n, m, k, memo, base);
    }

    private int aux(int index, int currentMax, int currentK, int n, int m, int k, Map<String, Integer> memo, int base) {
        String key = index + "," + currentMax + "," + currentK;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (currentK > k) {
            return 0;
        }

        if (index >= n) {
            if (currentK == k) {
                return 1;
            }
            return 0;
        }

        int max = (currentK == k) ? currentMax : m;
        int count = 0;

        for (int i = 1; i <= max; i++) {
            if (i > currentMax) {
                count = (count + aux(index + 1, i, currentK + 1, n, m, k, memo, base)) % base;
            } else {
                count = (count + aux(index + 1, currentMax, currentK, n, m, k, memo, base)) % base;
            }
        }

        memo.put(key, count);
        return count;
    }
}
