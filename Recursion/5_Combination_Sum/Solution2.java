// Time Complexity: O(2^n); Space Complexity: O(n)
class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentlist = new ArrayList<>();

        genC(candidates, 0, target, currentlist, result);

        return result;
    }

    private void genC(int[] candidates, int begin, int target, List<Integer> currentlist, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(currentlist));
            return;
        }
        
        for(int i=begin ; i<candidates.length ; i++){
            if(target >= candidates[i]){
                currentlist.add(candidates[i]);
                genC(candidates, i, target-candidates[i], currentlist, result);
                currentlist.remove(currentlist.size()-1);
            }
        }

        return;
    }
}
