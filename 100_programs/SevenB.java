import java.util.*;

// Fibonacci
public class SevenB{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int[] dp = Arrays.stream(new int[num+1]).map(e -> -1).toArray();
        int x = fibonacci(num, dp);
	}

	public static int fibonacci(int n, int[] dp){
		if(n < 2){
			System.out.println();
			System.out.print(n+" ");
            return n == 0 ? 0 : 1;
        }

        if(dp[n] != -1)
            return dp[n];

        dp[n] = fibonacci(n-1,dp) + fibonacci(n-2,dp);
        System.out.print(dp[n]+" ");
        return dp[n];

	}
}