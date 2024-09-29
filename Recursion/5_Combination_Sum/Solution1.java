// 4ms, 44.85MB

class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> li = new ArrayList<>();
        return ans(li, candidates, 0, 0, target);
    }

    private List<List<Integer>> ans(List<Integer> li, int[] candidates, int sum, int i, int target) {
        if (sum > target) {
            return new ArrayList<>();
        }
        
        if (sum == target) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(li));
            return list;
        }

        List<List<Integer>> ans = new ArrayList<>();

        while (i < candidates.length) {
            li.add(candidates[i]);
            ans.addAll(ans(li, candidates, sum + candidates[i], i, target));
            li.remove(li.size() - 1); // backtrack
            i++;
        }

        return ans;
    }
}
