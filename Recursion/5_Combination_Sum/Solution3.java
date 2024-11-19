// Time Complexity: O(2^n); Space Complexity: O(n); EFFICIENT SOLUTION
class Solution3 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        genC(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    private void genC(int[] candidates, int begin, int target, List<Integer> currentlist, List<List<Integer>> result){
        if(target < 0){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<>(currentlist));
            return;
        }
        
        for(int i=begin ; i<candidates.length ; i++){
            currentlist.add(candidates[i]);
            genC(candidates, i, target-candidates[i], currentlist, result);
            currentlist.remove(currentlist.size()-1);
        }

        return;
    }
}
