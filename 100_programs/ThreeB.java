import java.util.*;

// FACTORS
public class ThreeB{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = sc.nextInt();

		System.out.print(num + " ");
		factor(num, num-1);
	}

	public static void factor(int num, int divisor){
		if(divisor == 0){
			return;
		}

		if(num%divisor == 0){
	        System.out.print(divisor + " ");
	    }

		factor(num, divisor-1);
	}
}