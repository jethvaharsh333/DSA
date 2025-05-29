// Time Complexity: O(2^n); Space Complexity: O(n)
class Solution4 {
    List<List<Integer>> res;
    List<Integer> list;

    private void dfs(int i, int total, int[] candidates, int target){
        if(total == target){
            res.add(new ArrayList<>(list));
            return;
        }

        if((i>=candidates.length) || (total>target)) return;

        list.add(candidates[i]);
        dfs(i, total + candidates[i], candidates, target);

        list.remove(list.size()-1);
        dfs(i+1, total, candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();

        dfs(0, 0, candidates, target);

        return res;
    }
}
