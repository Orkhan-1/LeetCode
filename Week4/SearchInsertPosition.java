public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        if(nums[0]>target) {
            return 0;
        }
        if(nums[r]<target) {
            return r+1;
        }
        while(l<=r) {
            int m=(l+r)/2;
            if(nums[m]==target) {
                return m;
            }
            if(nums[m]<target) {
                l=m+1;
            } else {
                r=m-1;
            }
        }
        return nums[r]<target?r+1:r;
    }
}
