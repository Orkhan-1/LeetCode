
// Time complexity -  O(N)
// Space complexity - O(1)
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int w = r - l;
            maxArea = Math.max(maxArea, h * w);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
