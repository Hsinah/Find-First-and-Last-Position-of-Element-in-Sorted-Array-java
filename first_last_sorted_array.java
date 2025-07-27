class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean findFirst) {
        int start = 0;
        int end = nums.length - 1;
        int bound = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (findFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1; 
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return bound;
    }
}
