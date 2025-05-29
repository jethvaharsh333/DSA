// Time Complexity: O(n!*n), Space Complexity: O(n*n!)

class Solution1 {
    public String reorganizeString(String s) {
        List<String> result = new ArrayList<>();

        stringPerm(new StringBuilder(s), 0, result);
        
        for(String str: result){
            if (isValidReorganization(str)) {
                return str;
            }
        }

        return "";
    }

    private void stringPerm(StringBuilder s, int index, List<String> list){
        if(index == s.length()){
            list.add(s.toString());
            return;
        }

        for(int i=index ; i<s.length() ; i++){
            swap(s, i, index);
            stringPerm(s, index+1, list);
            swap(s, i, index);
        }
    }

    private void swap(StringBuilder s, int x, int y){
        char temp = s.charAt(x);
        s.setCharAt(x, s.charAt(y));
        s.setCharAt(y, temp); 
    }

    private boolean isValidReorganization(String str) {
        for(int i=1 ; i<str.length() ; i++){
            if(str.charAt(i) == str.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}
