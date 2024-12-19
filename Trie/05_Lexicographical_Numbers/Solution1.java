// Time Complexity: O(nlogn), Space Complexity: O(n)

class Solution1 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){res.add(i);}
        Collections.sort(res,(a,b)->(Integer.toString(a).compareTo(Integer.toString(b)))); //comparing integers lexicographically
        return res;
    }
}
