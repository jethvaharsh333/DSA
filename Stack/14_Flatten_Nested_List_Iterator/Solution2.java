// Time complexity: O(n); Space complexity: O(d) [d is the maximum depth of nesting] [OPTIMAL SOLUTION]
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<ListIterator<NestedInteger>> lists;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.lists = new Stack<>();
        this.lists.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!lists.empty()){
            if(!lists.peek().hasNext()){
                lists.pop();
            }
            else{
                NestedInteger x = lists.peek().next();
                if (x.isInteger())
                    return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
            }
        }

        return false;
    }
}
/*
    Push outermost iterator	            [ [1, 2], 3, [4, [5, 6]] ]	                    Start with an iterator for the entire nestedList.
    Push iterator for                   [1, 2]	[ [1, 2], 3, [4, [5, 6]] ], [1, 2]	    Found [1, 2]; go deeper into this nested list.
    Integer 1 prepared	                [ [1, 2], 3, [4, [5, 6]] ], [1, 2]	            hasNext() returns true for integer 1.
    Pop exhausted [1, 2] iterator	    [ [1, 2], 3, [4, [5, 6]] ]	                    Iterator for [1, 2] is exhausted, pop it off.
    Integer 3 prepared	                [ [1, 2], 3, [4, [5, 6]] ]	                    hasNext() returns true for integer 3.
    Push iterator for [4, [5, 6]]	    [ [1, 2], 3, [4, [5, 6]] ], [4, [5, 6]]	        Go deeper into [4, [5, 6]].
    Integer 4 prepared	                [ [1, 2], 3, [4, [5, 6]] ], [4, [5, 6]]	        hasNext() returns true for integer 4.
    Push iterator for [5, 6]	        [ [1, 2], 3, [4, [5, 6]] ], [4, [5, 6]], [5, 6]	Go deeper into [5, 6].
    Integer 5 prepared	                [ [1, 2], 3, [4, [5, 6]] ], [4, [5, 6]], [5, 6]	hasNext() returns true for integer 5.
*/
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
