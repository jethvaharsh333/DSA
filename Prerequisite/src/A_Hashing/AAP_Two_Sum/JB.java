package A_Hashing.AAP_Two_Sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int[] answer = findIndexTwoSum(arr, target);

        if(answer[0] == -1 || answer[1] == -1) System.out.println("No such 2 elements found.");

        System.out.println("Indexes: " + answer[0] + ", " + answer[1]);
    }

    private static int[] findIndexTwoSum(int[] arr, int target) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0 ; i<n ; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                int index = map.get(complement);
                return new int[]{i, index};
            }
            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }
}
