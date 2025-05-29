import java.util.*;

// PALINDROME
public class Two{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string: ");
		String str = sc.nextLine();

		int start = 0, end = str.length()-1;
		int flag = 0;

		while(start<=end){
			if(str.charAt(start) != str.charAt(end)){
				flag = 1;
				break;
			}
			start++;
			end--;
		}

		if(flag == 0){
			System.out.println("Palindrome");
		}else{
			System.out.println("Not Palindrome");
		}
	}
}