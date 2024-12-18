// Time Complexity: O(t), Space Complexity: O(1) [t = number of tasks]
class Solution3 {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int maximum = 0;
        int maxCount = 0;

        for(char task : tasks){
            counter[task-'A']++;
            if(maximum == counter[task-'A']){
                maxCount++;
            }
            else if(maximum < counter[task-'A']){
                maximum = counter[task-'A'];
                maxCount = 1;
            }
        }
        
        int partCount = maximum - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maximum * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}
