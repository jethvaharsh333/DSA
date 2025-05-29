// O(n) - 16ms
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(num) && seen.get(num) >= 1)
                return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}

/*
The hash map approach is similar to the hash set approach but also keeps track of the count of occurrences for each element. 
It uses a hash map to store the elements as keys and their counts as values. If a duplicate element is encountered (count greater than or equal to 1), it returns true. 
This approach provides more information than just the presence of duplicates and has a time complexity of O(n).
*/
