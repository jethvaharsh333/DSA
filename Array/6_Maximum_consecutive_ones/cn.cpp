int traffic(int n, int m, vector<int> vehicle) {

	int maxconsecutiveones = 0;
	int consecutiveones = 0;
	int flippedones = 0;

	for(int i=0 ; i<n ; ++i){
		if(vehicle[i] == 1){
			consecutiveones++;
			maxconsecutiveones = max(maxconsecutiveones, consecutiveones);
		}
		else{
			if(flippedones < m){
				consecutiveones++;
				flippedones++;
				maxconsecutiveones = max(maxconsecutiveones, consecutiveones);
			}
			else{
				consecutiveones = 0;
				flippedones = 0;
			}
		}
	}
	
    return maxconsecutiveones;

	// wrong soln.
	// int cnt=0;
	// int zerocount=0;
	// for(int i=0 ; i<n ; ++i){
	// 	if(vehicle[i]==1){
	// 		cnt++;
	// 	}
	// 	else{
	// 		if(zerocount < m){
	// 			zerocount++;
	// 		}
	// 	}
	// }
	// return zerocount+cnt;
}

// Test case
7 1
1 0 1 1 1 0 1
