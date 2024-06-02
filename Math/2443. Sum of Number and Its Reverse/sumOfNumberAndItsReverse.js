//        JS
// Time complexity -  O (NlogN)
// Space complexity - O (1)
var sumOfNumberAndReverse = function(num) {
    var reverseNumber = function(n) {
        let reversed_n = 0;
        while (n > 0) {
            reversed_n = reversed_n * 10 + n % 10;
            n = Math.floor(n / 10);
        }
        return reversed_n;
    };

    for (let x = 0; x <= num; ++x) {
        if (x + reverseNumber(x) === num) {
            return true;
        }
    }
    return false;
};