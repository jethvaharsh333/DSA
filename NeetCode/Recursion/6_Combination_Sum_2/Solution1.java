// Time complexity: O(2^n); Space complexity: O(n); OPTIMAL SOLUTION
class Solution1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getC2(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    private void getC2(int[] candidates, int begin, int target, List<Integer> currList, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(currList));
            return;
        }

        for(int i=begin ; i<candidates.length ; i++){
            if(i>begin && candidates[i]==candidates[i - 1]) continue;

            if(target >= candidates[i]){
                currList.add(candidates[i]);
                getC2(candidates, i+1, target-candidates[i], currList, result);
                currList.remove(currList.size() - 1);
            }
        }

        return;
    }
}
