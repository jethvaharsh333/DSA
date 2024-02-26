int removeDuplicates(vector<int> &arr, int n) {
	// 1st way
	int i = 1;
	for(int j=1 ; j<n ; j++){
		if(arr[j] != arr[j-1]){
			arr[i++] = arr[j];
		}
	}
	return i;

	// 2nd way
	// int i = 0;
	// for(int j=1 ; j<n ; j++){
	//     if(arr[j] != arr[j-1]){
	//         arr[++i] = arr[j];
	//     }
	// }
	// return i+1;
	
	// 2nd way => 22ms
	// int count = 1; 
	// for(int i=1 ; i<n ; ++i){
	// 	if(arr[i] != arr[i-1]){
	// 		count++;
	// 	}
	// }
	// return count;
}
