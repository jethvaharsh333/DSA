import java.util.*;

public class One{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter size of array: ");
		
		int len = sc.nextInt();
		int[] arr = new int[len];

		for(int i=0 ; i<len ; i++){
			System.out.print("element "+(i+1)+" : ");
			arr[i] = sc.nextInt();	
		}

		// LOGIC
		int sum = 0;

		for(int i=0 ; i<len ; i++){
			if(arr[i]%2 == 0){
				sum += arr[i];
			}
		}

		System.out.println("Sum: "+sum);
	}
}