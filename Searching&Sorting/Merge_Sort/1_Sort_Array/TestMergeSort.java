class TestMergeSort{
	public static void main(String[] args){
		int arr[] = {22,33,44,11};
		int low = 0;
		int high = arr.length-1;

		mergeSort(arr,low,high);

		for(int x=low; x<=high; x++){
			System.out.println(arr[x]);
		}
	}

	public static void mergeSort(int[] arr, int low, int high){
		if(low < high){
			int mid = (low+high)/2;
			System.out.println("mergeSort :: "+low+" :: "+mid+" :: "+high);
			
			//divide
			System.out.println("exe-1");
			mergeSort(arr, low, mid);
			System.out.println("exe-2");
			mergeSort(arr, mid+1, high);
			
			//conquer
			System.out.println("exe-3");
			merge(arr,low,mid,high);
		}
	}

	public static void merge(int[] arr, int low, int mid, int high){
		System.out.println("merge :: "+low+" :: "+mid+" :: "+high);
		int[] temp = new int[high - low + 1];
		int k=0;
		int i=low, j=mid+1;

		while(i<=mid && j<=high){
			if(arr[i] < arr[j]){
				System.out.println("==> "+arr[i]);
				temp[k++] = arr[i++];
			}
			else{
				System.out.println("<== "+arr[i]);
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			System.out.println(" 000000000000000 ");
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			System.out.println(" 111111111111111 ");
			temp[k++] = arr[j++];
		}

		for(int x=0; x<temp.length; x++){
			arr[low+x] = temp[x];
		}
	}
}
