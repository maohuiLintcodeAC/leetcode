package T0080;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int length = 1;
        int k = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
                count = 1;
                length++;
            } else if(++count == 2){
                nums[++k] = nums[i];
                length++;
            }
        }
        return length;
    }
}