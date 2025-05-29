import java.util.*;

// MAX, MIN, AVG OF n NUMBERS
public class Twelve{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter no of terms: ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++){
			System.out.print("element "+(i+1)+" : ");
			arr[i] = sc.nextInt();
		}

		int max=0, sum=0;
		for(int i=0 ; i<n ; i++){
			if(max < arr[i]){
				max = arr[i];
			}
			sum += arr[i];
		}

		int min = max;
		for(int i=0 ; i<n ; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}

		System.out.println("max: "+max+", min: "+min+", avg: "+(sum/n));
	}
}