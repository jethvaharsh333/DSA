class Solution {
    public int[][] merge(int[][] intervals) {
        
        // edge case
        if (intervals.length <=1) return intervals;
        /*
        // brute force approach

        List<int[]> result = new ArrayList<>();
        boolean[] merged = new boolean[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            if (merged[i]) continue;

            int[] current = intervals[i];

            for (int j = i + 1; j < intervals.length; j++) {
                if (merged[j]) continue;

                if (current[1] >= intervals[j][0] && current[0] <= intervals[j][1]) {
                    current[0] = Math.min(current[0], intervals[j][0]);
                    current[1] = Math.max(current[1], intervals[j][1]);
                    merged[j] = true;
                }
            }

            result.add(current);
        }

        return result.toArray(new int[result.size()][]);
        */

        if (intervals.length == 1) {
            return intervals;
        }
        int max = -1;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        if (max == -1) {
            return new int[][] { intervals[0] };
        }
        int[] timeTable = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            timeTable[startTime] = Math.max(endTime + 1, timeTable[startTime]);
        }
        int resultSize = 0, currEnd = -1, currStart = -1;
        for (int i = 0; i < timeTable.length; i++) {
            if (timeTable[i] != 0) {
                if (currStart == -1) {
                    currStart = i;
                }
                currEnd = Math.max(timeTable[i] - 1, currEnd);
            }
            if (currEnd == i) {
                intervals[resultSize++] = new int[] { currStart, currEnd };
                currEnd = -1;
                currStart = -1;
            }
        }
        if (currStart != -1) {
            intervals[resultSize++] = new int[] { currStart, currEnd };
        }
        if (intervals.length == resultSize) {
            return intervals;
        }
        int[][] res = new int[resultSize][];
        for (int i = 0; i < resultSize; i++) {
            res[i] = intervals[i];
        }
        return res;
        
    }
}
