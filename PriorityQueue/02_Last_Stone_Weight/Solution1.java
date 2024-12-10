// Time complexity: O(n.logn); Space complexity: O(n)

class Solution1 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0 ; i<stones.length ; i++){
            pq.add(stones[i]);
        }

        Iterator itr = pq.iterator();

        while(itr.hasNext()){
            int a = pq.poll();
            int b = 0;

            if(itr.hasNext()){
                b = pq.poll();
            }else{
                return a;
            }

            pq.add(Math.abs(a-b));
        }

        return 0;
    }
}
