// Time complexity: O(n), Space complexity: O(1)

class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int totalGas=0, totalCost=0;
        int curr=0, index=0;
        

        for(int i=0 ; i<len ; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            curr += gas[i]-cost[i];

            if(curr < 0){
                index = i+1; 
                curr = 0;
            }
        }

        return totalGas>=totalCost ? index : -1;
    }
}
