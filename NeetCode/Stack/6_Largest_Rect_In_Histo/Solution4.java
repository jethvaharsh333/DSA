// 4 ms

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int N = heights.length;
        int[] stack = new int[N];
        int si = -1;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (si != -1 && heights[i] <= heights[stack[si]]) {
                int j = stack[si--];
                int k = si == -1 ? -1 : stack[si];
                int curArea = (i - k - 1) * heights[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack[++si] = i;
        }
        while (si != -1) {
            int j = stack[si--];
            int k = si == -1 ? -1 : stack[si];
            int curArea = (heights.length - k - 1) * heights[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}
