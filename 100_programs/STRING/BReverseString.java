import java.util.*;

public class BReverseString{
	public static String revString(String s){
		StringBuilder sb = new StringBuilder();

		for(int i=s.length()-1 ; i>=0 ; i--){
			sb.append(s.charAt(i));
		}

		// System.out.println("!:::::::::::::");
		// System.out.println(sb.toString());

		return sb.toString();
	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string: ");
		String str = sc.nextLine();

		String ans = revString(str);
			
		System.out.println(ans);

		return;
	}
}