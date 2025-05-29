public class ArrayMaxRec{
	public static void main(String[] args){
		int arr[] = {22,33,44,11};
		
		int x = largestRectangleArea(arr);
		System.out.println(x);
	}

	public int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i=0 ; i<heights.length ; i++){
        	int sum = arr[i];
        	while(arr[i] > arr[j]){
        		sum += arr[i];
        	}
        	if(max < sum){
        		max = sum;
        	}
        }
        return max;
    }	
}