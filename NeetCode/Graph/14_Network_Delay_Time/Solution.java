// Time Complexity: O((v+e)logv), Space Complexity: O(v+e)

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            list.add(new ArrayList<>());
        }

        for(int[] time: times){
            int u = time[0]-1;
            int v = time[1]-1;
            int w = time[2];

            list.get(u).add(new int[]{v,w});
        }

        int[] minTime = dijkstra(k-1, n, list);
        int result = Integer.MIN_VALUE;
        for(int time : minTime){
            result = Math.max(result,time);
        }

        return (result==Integer.MAX_VALUE) ? -1 : result;

    }

    private int[] dijkstra(int src, int n, List<List<int[]>> adj){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return p1[1] - p2[1];
            }
        });

        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[src] = 0;
        pq.offer(new int[]{src,0});


        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int u = pair[0];
            int d = pair[1];

            if(d > time[u]) continue;

            for(int[] neighbor: adj.get(u)){
                int v = neighbor[0];
                int w = neighbor[1];
                if(time[u]+w < time[v]){
                    time[v] = time[u] + w;
                    pq.offer(new int[]{v, time[v]});
                }
            }
        }

        return time;
    }
}
