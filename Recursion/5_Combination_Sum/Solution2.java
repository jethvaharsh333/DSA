// 1ms, 44.76MB

class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void findCombinations(int[] candidates, int target, int idx, List<Integer> current, List<List<Integer>> ans) {
        if (target == 0) {  // If we hit the target, store the current combination
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {  // Iterate from 'idx' to avoid duplicate combinations
            if (candidates[i] > target) {  // If the current candidate exceeds target, no need to proceed further
                continue;
            }

            current.add(candidates[i]);  // Add the current candidate to the list
            findCombinations(candidates, target - candidates[i], i, current, ans);  // Recurse with updated target
            current.remove(current.size() - 1);  // Backtrack after recursion
        }
    }
}
