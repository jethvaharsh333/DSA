// Time complexity: O(n*(n+klogk)), Space complexity: O(n+k) 

class Solution2 {
    public double mincostToHireWorkers(int[] quality, int[] minWage, int k) {
        int n = quality.length;
        double result = Double.MAX_VALUE;
        
        for (int manager = 0; manager < n; manager++) {
            double managerRatio = (double) minWage[manager]/quality[manager];
            
            List<Double> group = new ArrayList<>();
            for(int worker=0 ; worker<n ; worker++){
                double workerWage = quality[worker]*managerRatio;
                if (workerWage >= minWage[worker]) {
                    group.add(workerWage);
                }
            }

            if (group.size() < k) {
                continue;
            }
            
            PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
            double sum = 0;

            for(double wage : group){
                sum += wage;
                pq.add(wage);

                if(pq.size() > k){
                    sum -= pq.poll();
                }
            }

            result = Math.min(result, sum);
        }

        return result;
    }
}
