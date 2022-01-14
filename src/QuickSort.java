import java.util.Arrays;

public class QuickSort {

    public void sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num+" ,");
        }
    }

    private void quickSort(int[] nums, int start, int end) {

        if (start < end) {
            int pIndex = partition(nums, start, end);
            quickSort(nums, start, pIndex - 1);
            quickSort(nums, pIndex + 1, end);
        }

    }

    private int partition(int[] nums, int low, int end) {

        int pivot = nums[end];
        int pivotIndex = low;
        for (int i = low; i <= end - 1; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotIndex);
                pivotIndex++;

            }
        }
        swap(nums, end, pivotIndex);
        return pivotIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.sortArray(new int[]{6, 4, 8, 3});
    }


}
