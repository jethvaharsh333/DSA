import java.util.*;

// Fibonacci
public class SevenA{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int a=0, b=1;

		System.out.print(a+" "+b+" ");

		int count = 2;
		while(count<num){
			int sum = a+b;
			System.out.print(sum+" ");
			a = b;
			b = sum;

			count++;
		}
	}
}