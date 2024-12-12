// Time Complexity: O(t), Space Complexity: O(1) [t = number of tasks]
class Solution4 {
    public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        for(char task : tasks){
            bucket[task-'A']++;
        }

        int max = 0;
        for(int val : bucket){
            max = Math.max(max, val);
        }

        int maxCount = 0;
        for(int val : bucket){
            if(val == max){
                maxCount++;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }
}
