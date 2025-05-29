// Time complexity: O(n); Space complexity: O(n)
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

    Iterator<Integer> it;
    List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = unnestList(nestedList);
        it = list.iterator();
    }

    private List<Integer> unnestList(List<NestedInteger> nestedList) {
        List<Integer> ret = new ArrayList<>();

        for (NestedInteger ni : nestedList) {
            System.out.println("------------------");
            if(ni.isInteger()){
                ret.add(ni.getInteger());
                System.out.println("Integer returned "+ni.getInteger());
            } 
            else{
                System.out.println("list returned "+ni.getList());
                ret.addAll(unnestList(ni.getList()));
            }
        }
        return ret;
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
