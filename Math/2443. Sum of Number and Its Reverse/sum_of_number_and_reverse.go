package main

//        Go
// Time complexity -  O (NlogN)
// Space complexity - O (1)

func reverseNumber(n int) int {
	reversed := 0
	for n > 0 {
		reversed = reversed*10 + n%10
		n /= 10
	}
	return reversed
}

func sumOfNumberAndReverse(num int) bool {
	for x := 0; x <= num; x++ {
		if x+reverseNumber(x) == num {
			return true
		}
	}
	return false
}
