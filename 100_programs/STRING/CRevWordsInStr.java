import java.util.*;

public class CRevWordsInStr{
	public static String revWords(String s){
		Stack<String> li = new Stack<String>();
		String sb = new String();
		
		for(int i=0 ; i<s.length() ; i++){
			if(s.charAt(i) == ' ' || s.charAt(i) == '.'){
				if(sb != ""){
					li.push(sb);
					sb = "";
				}
				continue;
			}

			sb += s.charAt(i);
		}
		li.push(sb);

		System.out.println(li);

		sb = "";

		while(!li.isEmpty()){
			sb+=li.peek();
			sb+=" ";
			li.pop();
		}

		return sb;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string: ");
		String str = sc.nextLine();

		String ans = revWords(str);

		System.out.println(ans);
	}
}