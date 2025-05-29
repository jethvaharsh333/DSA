class Tms{
	public static void main(String[] args){
		int[] arr = {3,4,2,5,1};

		mergeSort(arr,0,(arr.length-1));

		for(int x: arr){
			System.out.println(x);
		}
	}

	static void mergeSort(int arr[], int low, int high){
		if(low>=high) return;  // sp = 2 ["small problem" size]

		int mid = (low+high)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);

		merge(arr, low, mid, high);
	}

	static void merge(int arr[], int low, int mid, int high){
		int[] b = new int[high-low+1];
		int k=0;
		int left=low, right=mid+1;

		while(left<=mid && right<=high){		// even one of the arr exhasted other array's element are still remaining
			if(arr[left] <= arr[right]){
				b[k++] = arr[left++];
			}
			else{
				b[k++] = arr[right++];
			}
		}

		while(left<=mid){
			b[k++] = arr[left++];
		}
		while(right<=high){
			b[k++] = arr[right++];
		}

		for(int x=low ; x<=high ; x++){
			arr[x] = b[x-low];                
		}
	}
}