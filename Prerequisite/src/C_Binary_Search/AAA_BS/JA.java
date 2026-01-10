package C_Binary_Search.AAA_BS;

public class JA {
    public static int binarySearch(int[] arr, int target) {
        int low=0, high=arr.length-1;

        // O(log n)
        while(low <= high){
            int mid = low + (high-low)/2; // avoids overflow

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 10, 15, 18, 21};
        int target = 10;

        System.out.println(binarySearch(arr, target));
    }
}

/*

Mini Walkthrough

Array: [2, 4, 7, 10, 15, 18, 21]
Target: 10

low mid high        arr[mid]	Action
0	3	 6	         10	        Found

* */