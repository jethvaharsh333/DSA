// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         Stack<Integer> stack = new Stack<Integer>();
        
//         for(int i=0 ; i<nums1.length ; ++i){
//             int x = nums1[i];
//             stack.clear();
//             for(int j=nums2.length-1 ; j>=0 ; j--){
//                 if(stack.empty()){
//                     nums1[i] = -1;
//                     stack.push(nums2[j]);
//                     break;
//                 }
//                 else{
//                     if(x == nums2[j]){
//                         nums1[i] = stack.pop();
//                         // break;
//                     }
//                     else{
//                         while(!stack.empty() && nums2[j] >= stack.peek()){
//                             stack.pop();
//                         }
//                         stack.push(nums2[j]);
//                     }
//                 }
//             }
//         }

//         return nums1;
//     }
// }

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 2nd code
        // int[] result = new int[nums1.length];
        // Stack<Integer> stack=new Stack<>();
        // Map<Integer, Integer> map = new HashMap<>();

        // for(int num: nums2){            
        //     while(!stack.isEmpty() && num > stack.peek())
        //         map.put(stack.pop(), num);
        //     stack.push(num);            
        // }
        
        // int i=0;        
        // for(int num : nums1)
        //     result[i++] = map.getOrDefault(num, -1);
        // return result;

        int[] stack = new int[1001];
        int[] map = new int[10_001];
        
        int top = -1;
        for (int i = nums2.length - 1; i >= 0; i--) {
            int val = nums2[i];
            while (top >= 0 && stack[top] <= val) top--;
            map[val] = (top == -1) ? -1 : stack[top];
            stack[++top] = val;
        }
        for (int i = 0; i < nums1.length; i++) nums1[i] = map[nums1[i]];
        return nums1;
    }
}
