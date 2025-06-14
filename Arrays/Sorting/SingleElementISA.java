class SingleElementISA{
	public static void main(String[] args){
		int[] arr = {3,3,7,7,10,11,11};

		int ans = singleNonDuplicate(arr);
		System.out.println(ans);
	}

	static int singleNonDuplicate(int[] nums){
		int mid = (0+(nums.length-1))/2;
		int left = 0, right = nums.length-1;

		for(int i=0 ; i<nums.length ; i++){
			if(mid%2 == 0){				
				if(nums[mid] == nums[mid-1]){
					right = mid-2;
				}
				else if(nums[mid] == nums[mid+1]){
					left = mid+2;
				}
			}	
			else{
				if(nums[mid] == nums[mid-1]){
					left = mid+1;
				}
				else if(nums[mid] == nums[mid+1]){
					right = mid-1;
				}
			}

			if(left == right){
				return nums[left];
			}
			mid = (left+right)/2;
		}
		return -1;
	}
}