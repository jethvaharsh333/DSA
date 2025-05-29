import java.util.*;

public class DCheckForRotn{
	public static int checkForRotation(String s1, String s2){
		int left = 0;

		for(int r=0 ; r<s1.length() ; r++){
			if(s1.equals(s2)){
				return r;
			}

			char last = s2.charAt(s2.length()-1);
			s2 = last+s2.substring(0, s2.length()-1);
		}

		return -1;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter string 1: ");
		String str1 = sc.nextLine();

		System.out.print("Enter string 2: ");
		String str2 = sc.nextLine();

		int ans = checkForRotation(str1, str2);

		System.out.println("Rotation: " + ans);
	}
}