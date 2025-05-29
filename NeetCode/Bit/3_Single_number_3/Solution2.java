// 4 ms, Beats 41.07%
class Solution2 {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int elem : nums){
            if(set.contains(elem)){
                set.remove(elem);
            }else{
                set.add(elem);
            }
        }
        int[] res = new int[2];
        int i=0;
        for(int x : set){
            res[i++]=x;
        }
        return res;
    }
}
