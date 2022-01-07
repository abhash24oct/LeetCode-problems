class MereSortArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, end);
    }


    void merge(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        int L[] = new int[mid - start + 1];
        int R[] = new int[end - mid];
        int x = 0;
        for (int i = start; i <= mid; i++) {
            L[x++] = nums[i];
        }
        x = 0;
        for (int i = mid + 1; i <= end; i++) {
            R[x++] = nums[i];
        }
        int k = start;
        int i = 0;
        int j = 0;

        while (i < L.length && j < R.length) {
            if (L[i] > R[j]) {
                nums[k] = R[j];
                j++;
            } else {
                nums[k] = L[i];
                i++;
            }
            k++;
        }

        while (j < R.length) {
            nums[k++] = R[j++];
        }

        while (i < L.length) {
            nums[k++] = L[i++];
        }
    }

    public static void main(String[] args) {
        MereSortArray mereSortArray = new MereSortArray();
        mereSortArray.sortArray(new int[]{6, 4, 8, 3});
    }
}
