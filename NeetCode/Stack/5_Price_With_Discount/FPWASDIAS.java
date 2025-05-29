import java.util.Stack;

public class FPWASDIAS{
    public static void main(String[] args) {
        int[] arr = {8,4,6,2,3};

        int[] newArr = finalPrices(arr);

        for (int b : newArr) {
            System.out.println(b);
        }
    }

    static int[] finalPrices(int[] prices){
//        int size = prices.length;
//        int i=0, j=1;
//        Stack<Integer> stack = new Stack<Integer>();
//        for(i=0 ; j<=size ; ++i){
//            if(stack.empty()){
//                if(!stack.empty() && prices[i] == stack.peek()){
//                    stack.pop();
//                }
//                while(prices[i]<prices[j] && j<=size) ++j;
//                stack.push(prices[j]);
//                prices[i] = prices[j];
//                break;
//            }
//            else{
//                prices[i] = stack.peek();
//            }
//        }
//        return prices;

        int n = prices.length;
        int j;
        int x[] = new int[n];
        for(int i=0 ; i<n ; i++){
            for(j=i+1 ; j<n ; j++){
                if(prices[j] <= prices[i]){
                    x[i] = prices[i]-prices[j];
                    break;
                }

            }
            if(j == prices.length){
                x[i] = prices[i];
            }
        }
        return x;
    }

}
