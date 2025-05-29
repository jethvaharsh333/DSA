class TestBubbleSort{
	public static void main(String[] args){
		int[] arr = {23,42,1,56,20,35,35,89};

		bubbleSort(arr, (arr.length-1)); 

		for(int x: arr){
			System.out.println(x);
		}
	}

	static void bubbleSort(int[] arr, int high){
		int exchs = 0;

		for(int i=0 ; i<high ; i++){
			for(int j=0 ; j<high-i ; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					exchs++;
				}
			}
			if(exchs == 0){				
				break;
			}
			exchs = 0;
		}
	}
}