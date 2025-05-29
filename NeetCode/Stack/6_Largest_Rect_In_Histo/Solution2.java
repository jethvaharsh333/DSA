// BRUTE FORCE  [Will not reach answer => Error: "Time exceeded"]

// 1
int maxArea = 0;
for(int i   =0 ; i<heights.length ; i++){
    int point=heights[i], k=i+1, sum=heights[i];
    while(k<heights.length && point <= heights[k]){
        sum += point; k++;
    }
    k=i-1;
    System.out.print(sum);
    while(k>=0 && point <= heights[k]){
        sum += point; k--;
    }
    System.out.print(" :: "+sum);
    if(maxArea < sum){
        
        maxArea = sum;
    }
    System.out.println();
}
return maxArea;

// 2
int maxArea = 0;
for (int i = 0; i < heights.length; i++) {
    int point = heights[i];
    // Expand to the left
    int left = i;
    while (left >= 0 && heights[left] >= point) {
        left--;
    }
    // Expand to the right
    int right = i;
    while (right < heights.length && heights[right] >= point) {
        right++;
    }
    // Calculate the width
    int width = right - left - 1;
    // Calculate the area
    int area = point * width;
    // Update the maximum area
    maxArea = Math.max(maxArea, area);
}
return maxArea;
