class Solution {
    public String reverseWords(String s) {
        // Adding extra ' '
        char[] data = (s + ' ').toCharArray();
        int l = 0;

        for (int r = 0; r < data.length; r++) {
            if (data[r] == ' ') {
                int start = l, end = r - 1;
                while (start < end) {
                    char temp = data[start];
                    data[start] = data[end];
                    data[end] = temp;
                    start++;
                    end--;
                }
                l = r + 1;
            }
        }

        // Convert char array to string and remove the extra space at the end
        return new String(data, 0, data.length - 1);
    }

    public String reverseWordsBuiltIn(String s) {
        // Using built-in functions
        String[] data = s.split(" ");
        for (int i = 0; i < data.length; i++) {
            char[] charArray = data[i].toCharArray();
            int start = 0, end = charArray.length - 1;
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
            data[i] = new String(charArray);
        }
        return String.join(" ", data);
    }
}
