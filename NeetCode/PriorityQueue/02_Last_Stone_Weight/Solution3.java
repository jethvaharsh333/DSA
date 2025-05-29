// Time complexity: O(n^2.logn); Space complexity: O(1)

class Solution3 {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int lastWeight = stones[stones.length-1];
        int left = stones.length-2;
        int right = stones.length-1;

        while(left>=0 && stones[left]!=0){
            int resultWeight = Math.abs(stones[right]-stones[left]);
            stones[right] = resultWeight;
            stones[left] = 0;
            Arrays.sort(stones);
        }

        return stones[right];
    }
}
