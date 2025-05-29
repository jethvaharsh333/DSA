class TestQuickSort{
	public static void main(String[] args){
		int arr[] = {22,33,44,11};

		quickSort(arr,0,(arr.length-1));

		for(int x: arr){
			System.out.println(x);
		}
	}

	static void quickSort(int[] arr, int low, int high){
		
		if(low>=high) return;
		int x = partition(arr, low, high);
		quickSort(arr, low, x-1);
		quickSort(arr, x+1, high);

	}

	static int partition(int[] arr, int low, int high){
		int pivot=arr[low];
		int i=low, j=high; //edit

		
		while(i<j){
			while (i <= high && arr[i] <= pivot) {  //while(i<=high && pivot >= arr[i]){
				i++;
			}
			while(j>=low && pivot < arr[j]){
				j--;
			}

			if(i<j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;	
			}
			
		}

		arr[low] = arr[j];
		arr[j] = pivot;

		return j;
	}
}
