import java.util.*;

// ARMSTRONG
public class Eleven{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int count = 0;
		int temp = num;
		while(temp > 0){
			temp /= 10;
			count++;
		}

		temp = num;
		int sum = 0;

		while(num > 0){
			int rem = num%10;

			sum += Math.pow(rem, count);
			num /= 10;
		}

		if(sum == temp){
			System.out.println("ARMSTRONG");
		}
		else{
			System.out.println("NOT ARMSTRONG");
		}
	}
}