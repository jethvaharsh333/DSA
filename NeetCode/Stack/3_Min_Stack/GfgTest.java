class GfG
{
    int minEle; // variable to store the minimum element
    Stack<Integer> s; // stack to store the elements

    GfG()
    {
        s = new Stack<Integer>(); // initialize the stack
    }

    int getMin()
    {
        if(s.isEmpty())
            return -1; // if stack is empty, return -1
        else
            return minEle; // return the minimum element
    }
    
    int pop()
    {
        if(s.isEmpty())
            return -1; // if stack is empty, return -1

        int t = s.pop(); // get the top element from stack

        if(t < minEle) // if the top element was the minimum element
        {
            int k = minEle; // store the current minimum element
            minEle = 2*minEle - t; // update the minimum element
            return k; // return the previous minimum element
        }
        else 
        {
            return t; // return the top element
        }
    }
    
    void push(int x)
    {
        if(s.isEmpty()) // if stack is empty
        {
            minEle = x; // x becomes the minimum element
            s.push(x); // push x to stack
            return ;
        }
        else if(x < minEle) // if x is smaller than the current minimum element
        {
            s.push(2*x - minEle); // push a modified x to stack
            minEle = x; // update the minimum element
        }
        else
        {
            s.push(x); // push x to stack
        }
    }   
}
