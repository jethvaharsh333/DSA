// Time complexity: O(n); Space Complexity: O(1)
class Solution3 {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] arr= new int[26];
        int left =0 ;
        int right = 0;
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i) - 'a']++;
        }
        while(right<s2.length()){
            arr[s2.charAt(right) - 'a']--;
            if(right - left + 1 == s1.length()){
                if(checkArr(arr)){
                    return true;
                }else{
                    arr[s2.charAt(left++)-'a']++;
                    right++;
                }
            }else{
                right++;
            }
        }
        return false;
    }

    private static boolean checkArr(int[] arr) {
        for(int num:arr){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}
