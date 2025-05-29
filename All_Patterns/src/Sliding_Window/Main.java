package Sliding_Window;

import java.util.*;
public class Main {
    public static int findmaxconssum(int arr[],int n,int k)
    {
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<n-k;i++)
        {
            int currsum=0;
            for(int  j=0;j<k;j++)
                currsum+=arr[j+i];
            maxsum=Math.max(maxsum,currsum);
        }
        return maxsum;
    }
    public static void main(String args[]) {
        int arr[]={1,7,6,2,3,4,5};
        int n=7;
        int k=2;
        System.out.println(findmaxconssum(arr,n,k));
    }
}
