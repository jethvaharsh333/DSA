class Solution {
    public int[] sortArray(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new MergeSortTask(arr, 0, arr.length, temp));
        return arr;
    }
}

class MergeSortTask extends RecursiveAction {
    private static final int THRESHOLD = 1024;
    private final int[] arr;
    private final int[] temp;
    private final int left;
    private final int right;

    public MergeSortTask(int[] arr, int left, int right, int[] temp) {
        this.arr = arr;
        this.temp = temp;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (right - left <= THRESHOLD) {
            mergeSort(arr, left, right, temp);
        } else {
            int mid = left + (right - left) / 2;
            MergeSortTask leftTask = new MergeSortTask(arr, left, mid, temp);
            MergeSortTask rightTask = new MergeSortTask(arr, mid, right, temp);
            invokeAll(leftTask, rightTask);
            merge(arr, left, mid, right, temp);
        }
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right - 1) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid;
        int k = left;

        while (i < mid && j < right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }

        while (j < right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, left, arr, left, right - left);
    }

}
