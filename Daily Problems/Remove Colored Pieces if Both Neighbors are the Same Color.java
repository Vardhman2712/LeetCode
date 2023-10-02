class Solution {
    public boolean winnerOfGame(String colors) {
        int cAlice = 0;
        int cBob = 0;
        int n = colors.length();

        // Alice
        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A' && colors.charAt(i) == 'A') {
                cAlice++;
            }
        }
        // Bob
        for (int j = 1; j < n - 1; j++) {
            if (colors.charAt(j - 1) == 'B' && colors.charAt(j + 1) == 'B' && colors.charAt(j) == 'B') {
                cBob++;
            }
        }
        // Check
        if (cBob >= cAlice) {
            return false;
        } else {
            return true;
        }
    }
}
