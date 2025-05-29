class Test{
	public static void main(String[] args){
		int[] arr = {4,5,6,7,3};
		int targetint = 7;

		int ans = search(arr, targetint);
		
		System.out.println(ans);
	}

	static int search(int[] nums, int target){
		int size = nums.length;
		int left = 0, right = size-1;

		if(size==1){
			if(target==nums[left]){
				return left;
			}
			else{
				return -1;
			}
		}

		int mid = (left+right)/2;
		// System.out.println(mid);

		while(left<=right){
			System.out.println("target = "+target+"  ::::  "+"nums[mid] = "+nums[mid]);
			if(target == nums[mid]){
        		System.out.println("exit1");
        		return mid;
        	}

			if(nums[left] > nums[right]){
				// System.out.println("ex-1");
				
				if(target > (nums[mid]-nums[left])){
					right = mid-1;
					// System.out.println("ex-1-1");
				}
				else{
					left = mid+1;
					// System.out.println("ex-1-2");
				}
			}
			else if(nums[left] < nums[right]){
				// System.out.println("ex-2");
				if(target > nums[mid]){
					left = mid+1;
				}
				else{
					right = mid-1;
				}
			}
			else if(nums[left] == nums[right] && target == nums[left]){
				System.out.println("exit2");
				return left;
			}
			else if(nums[left] == nums[right] && target != nums[left]){
				return -1;
			}

			mid = (left+right)/2;
		
			System.out.println(left+" :: "+mid+" :: "+right);
		}

		return -1;
	}
}