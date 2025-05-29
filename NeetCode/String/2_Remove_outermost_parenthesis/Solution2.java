// 2 ms, 42.05 mb

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int counter = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (counter > 0) {
                    str.append(c);
                }
                counter++;
            } else {
                counter--;
                if (counter > 0) {
                    str.append(c);
                }
            }
        }

        return str.toString();
    }
}
