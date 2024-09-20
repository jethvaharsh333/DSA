// O(n) - 10ms
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }
}

/*
The hash set approach uses a hash set data structure to store encountered elements. 
It iterates through the array, checking if an element is already in the set. If so, it returns true. Otherwise, it adds the element to the set. 
This approach has a time complexity of O(n) and provides an efficient way to check for duplicates.
*/
