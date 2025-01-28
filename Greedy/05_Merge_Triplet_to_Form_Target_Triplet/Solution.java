// Time Complexity: O(n), Space Complexity: O(1)

class Solution1 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first = false, second = false, third = false;

        for(int[] triplet : triplets){
            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){
                if(triplet[0] == target[0]) first = true;
                if(triplet[1] == target[1]) second = true;
                if(triplet[2] == target[2]) third = true;

                if(first && second && third) return true;
            }
        }

        return first && second && third;
    }
}
