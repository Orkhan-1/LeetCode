//        C++
// Time complexity -  O (NlogN)
// Space complexity - O (1)

class SumOfNumberAndItsReverse {
public:
    int reverseNumber(int n) {
        int reversed_n = 0;
        while (n > 0) {
            reversed_n = reversed_n * 10 + n % 10;
            n /= 10;
        }
        return reversed_n;
    }
    
    bool sumOfNumberAndReverse(int num) {
        for (int x = 0; x <= num; ++x) {
            if (x + reverseNumber(x) == num) {
                return true;
            }
        }
        return false;
    }
};