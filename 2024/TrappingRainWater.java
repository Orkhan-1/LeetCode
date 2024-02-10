
// Time complexity - O (N)
// Space complexity - O (1)
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int result = 0;

        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if (lMax < rMax) {
                result += lMax - height[l];
                l++;
            } else {
                result += rMax - height[r];
                r--;
            }
        }

        return result;
    }
}
