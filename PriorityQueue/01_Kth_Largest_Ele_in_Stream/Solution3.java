// Time complexity: O(n.logk); Space complexity: O(k) [Adding an element: Time Complexity: O(logk)]

class KthLargest {
    private int[] heap;  // Array-based min-heap
    private int k;       // The "k" in "kth largest"
    private int size;    // Current size of the heap

    // Constructor initializes the min-heap and fills it with up to k largest elements from nums
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k];
        this.size = 0;

        // Insert each number in nums into the heap
        for (int num : nums) {
            add(num);
        }
    }

    // Adds a new element to the stream and returns the kth largest element
    public int add(int val) {
        if (size < k) {
            // If heap is not full, add the element and heapify up
            heap[size] = val;
            size++;
            heapifyUp(size - 1);
        } else if (val > heap[0]) {
            // If heap is full and val is larger than the root, replace root and heapify down
            heap[0] = val;
            heapifyDown(0);
        }

        // The root of the min-heap is the kth largest element
        return heap[0];
    }

    // Heapify up - restores the heap property by comparing child and parent
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[parentIndex] > heap[index]) {
                // Swap if parent is greater than the child
                swap(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Heapify down - restores the heap property by comparing parent and children
    private void heapifyDown(int index) {
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            // Find the smallest of parent, left child, and right child
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                // Swap if the smallest isn't the parent
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    // Utility method to swap elements at two indices
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
