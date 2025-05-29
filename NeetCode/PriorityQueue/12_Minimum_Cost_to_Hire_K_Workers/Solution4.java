// Time complexity: O(n(logn+logk)), Space complexity: O(n+k) 

class Solution4 {
    class WorkerRatio{
        double ratio;
        int quality;

        WorkerRatio(double ratio, int quality){
            this.ratio = ratio;
            this.quality = quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        WorkerRatio[] ratio = new WorkerRatio[n];

        for(int i=0; i<n;i++){
            ratio[i] = new WorkerRatio((double)wage[i]/quality[i], quality[i]);
        }

        Arrays.sort(ratio, (a, b) -> Double.compare(a.ratio, b.ratio));

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int sum = 0;

        for(int i=0 ; i<k ; i++){
            pq.add(ratio[i].quality);
            sum += ratio[i].quality;
        }

        double baseRatio = ratio[k-1].ratio;
        double ans = baseRatio*sum;

        for(int i=k ; i<n ; i++){
            double newRatio = ratio[i].ratio;
            int cur_quality = ratio[i].quality;

            if(pq.peek() > cur_quality){
                sum -= pq.poll();
                pq.add(cur_quality);
                sum += cur_quality;
            }

            ans = Math.min(ans, newRatio * sum);
        }

        return ans;
    }
}
