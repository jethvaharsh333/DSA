// Time Complexity: O(nlogk), Space Complexity: O(n+k) [logk for heap operation]
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x: nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i=k-1 ; i>=0 ; i--){
            res[i] = pq.poll().getKey();
        }

        return res;    
    }
}
