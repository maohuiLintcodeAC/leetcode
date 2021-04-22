package T0703;

public class KthLargest {
    private int[] data;
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        heapify(nums);
        data = nums;
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private void heapify(int[] nums) {
        int index = (nums.length - 1) / 2;
        while (index >= 0) {
            sink(nums, index, nums.length);
            index--;
        }
    }

    public int add(int val) {
        if (val > data[0]) {
            // 下沉
            data[0] = val;
            sink(data, 0, size);
        }

        return data[0];
    }

    private void sink(int[] nums, int index, int real) {
        int minChildIndex = getMinChild(nums, index, real);
        if (minChildIndex == -1) {
            return;
        }
        if (nums[index] >= nums[minChildIndex]){
            int temp = nums[index];
            nums[index] = nums[minChildIndex];
            nums[minChildIndex] = temp;
            sink(nums, minChildIndex, real);
        }
    }

    private int getMinChild(int[] nums, int index, int real) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int childIndex = -1;

        if (rightChild < real) {
            childIndex = nums[rightChild] < nums[leftChild] ? rightChild : leftChild;
        } else if (leftChild < real) {
            childIndex = leftChild;
        }
        return childIndex;
    }

    public static void main(String[] args) {
        int[] data = new int[] {
                4, 5, 8, 2
        };
        KthLargest test = new KthLargest(1, data);
        int key = test.add(3);
        System.out.println("key:" + key);
    }
}
