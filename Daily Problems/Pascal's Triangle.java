class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) {
            return res; // Handle the case when numRows is 0.
        }

        res.add(new ArrayList<Integer>() {{
            add(1);
        }});

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // The first element is always 1.

            List<Integer> prevRow = res.get(i - 1);

            for (int j = 1; j < i; j++) {
                int val = prevRow.get(j - 1) + prevRow.get(j);
                row.add(val);
            }

            row.add(1); // The last element is always 1.
            res.add(row);
        }

        return res;
    }
}
