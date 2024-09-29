// 4ms, 44.85MB

class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;

        List<Integer> adding=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();

        f(candidates,target,n,0,adding,ans);

        return ans;
    }
    
    public static void f(int[] candidates, int target, int n, int idx,List<Integer> adding,List<List<Integer>> ans){
        if(idx==n){
            if(target==0){
                ans.add(new ArrayList<>(adding));
            }
            return;
        }
        
        if(candidates[idx]<=target){
            adding.add(candidates[idx]);
            f(candidates,target-candidates[idx],n,idx,adding,ans);
            adding.remove(adding.size()-1);
        }

        f(candidates,target,n,idx+1,adding,ans);
    }
}
