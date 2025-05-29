// Time complexity: O(n.logn); Space complexity: O(n)

class Solution2 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != b) {
                pq.add(a - b);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
