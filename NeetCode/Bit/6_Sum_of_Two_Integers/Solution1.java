class Solution1 {
    public int getSum(int a, int b) {
        while(b > 0){
            a++;
            b--;
        }

        while(b < 0){
            a--;
            b++;
        }
        
        return a;
    }
}
