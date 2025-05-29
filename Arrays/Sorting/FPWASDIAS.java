import java.util.Stack;

class FPWASDIAS{
	public static void main(String[] args) {
        int[] arr = {8,4,6,2,3};

        int[] newArr = finalPrices(arr);

        for (int b : newArr) {
        	System.out.println(b);
        }
    }

    static int[] finalPrices(int[] prices){
    	int size = prices.length;
    	int i=0, j=1;

    	Stack<Integer> stack = new Stack<Integer>(); 

    	for(i=0 ; j<=size ; ++i){
    		if(stack.empty()){
    			if(!stack.empty() && prices[i] == stack.peek()){
    				stack.pop();
    			}
    			while(prices[i]<prices[j] && j<=size) ++j;
    			stack.push(prices[j]); 
    			prices[i] = prices[j];
    			break;
    		}
    		else{
    			prices[i] = stack.peek();
    		}
    	}

    	return prices;
    }

}