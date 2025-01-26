// Time complexity: O(n^2), Space complexity: O(1)

class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        for(int start=0 ; start<len ; start++){
            int gasLeft = 0;
            boolean canComplete = true;

            for(int i=0 ; i<len ; i++){
                int curr = (start+i)%len;
                gasLeft += gas[curr]-cost[curr];

                if(gasLeft < 0){
                    canComplete = false;
                    break;
                }
            }

            if(canComplete){
                return start;
            }
        }

        return -1;
    }
}
