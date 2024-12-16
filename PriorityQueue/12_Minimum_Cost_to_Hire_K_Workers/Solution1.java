// Memory limit exceeded
class Solution1 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double minCost = Double.MAX_VALUE;

        List<List<Integer>> combinations = new ArrayList<>();
        combinations(combinations, new ArrayList<>(), n, k, 0);

        for(List<Integer> group : combinations){
            double maxRatio = 0.0;
            int totalQuality = 0;

            for(int i : group){
                double ratio = (double) wage[i]/quality[i];
                maxRatio = Math.max(maxRatio, ratio);
                totalQuality += quality[i];
            }

            double cost = maxRatio*totalQuality;

            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    private void combinations(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
        if(temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start ; i<n ; i++){
            temp.add(i);
            combinations(result, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
