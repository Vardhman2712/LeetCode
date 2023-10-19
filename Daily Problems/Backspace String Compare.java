class Solution {
    public boolean backspaceCompare(String S, String T) {
        String result1 = processString(S);
        String result2 = processString(T);

        return result1.equals(result2);
    }

    private String processString(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
            } else if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
        }
        return result.toString();
    }
}
