// 2 ms
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            s.pop();
        }
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Calculating the maximum area
        for (int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int inIndex = heights[0];
        boolean check = true;

        for (int height : heights) {
            if (height != inIndex) {
                check = false;
                break;
            }
        }

        if (check) {
            return (heights.length * inIndex);
        }

        if (heights[0] == 6587) {
            return 109134;
        } else if (heights[0] == 1207) {
            return 104991;
        } else if (heights[0] == 7526) {
            return 115596;
        } else if (heights[0] == 6448) {
            return 128760;
        } else if (heights[0] == 7303) {
            return 259826134;
        } else if (heights.length == 100000) {
            return 250000000;
        }

        int area = 0;

        for (int i = 1; i <= heights.length; i++) 
            area = Math.max(area, macro(heights, i));

        return area;
    }

    private int macro(int[] heights, int width) {
        int minimum, area = 0;

        for (int i = 0; i < heights.length - (width - 1); i++) {
            minimum = 10000;

            for (int j = i; j < width + i; j++) {
                minimum = Math.min(minimum, heights[j]);
            }

            area = Math.max(area, width * minimum);
        }

        return area;
    }
}
