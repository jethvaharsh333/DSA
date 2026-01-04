package A_Hashing.AAR_Max_Distance_Between_Two_Occurrences;

import java.util.*;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(maxDistanceBtwTwoOccur(arr));
    }

    private static int maxDistanceBtwTwoOccur(int[] nums){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int maximumDistance = 0;

        for(int j=0 ; j<n ; j++){
            int current = nums[j];

            if(map.containsKey(current)){
                int i = map.get(current);
                maximumDistance = Math.max(maximumDistance, j-i);
            }else{
                map.put(current, j);
            }
        }

        return maximumDistance;
    }
}
