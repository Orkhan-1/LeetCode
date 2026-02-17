class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0;

        while (i<flowerbed.length) {
            if (flowerbed [i]==1) {
                i = i+2;
            } else {
                if (i+1< flowerbed.length && flowerbed [i+1]==0) {
                    n--;
                    i = i+2;
                } else if (i==flowerbed.length-1 && flowerbed [i]==0) {
                    n--;
                    i++;
                }
            }
        }
        return n <= 0 ? true : false;
    }
}