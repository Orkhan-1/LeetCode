
#        Python
# Time complexity -  O (NlogN)
# Space complexity - O (1)

class Solution(object):

    def sumOfNumberAndReverse(self, num: int) -> bool:
        for x in range(num + 1):
            if x + self.reverse_number(x) == num:
                return True
        return False

    def reverse_number(self, n: int) -> int:
        reversed_n = 0
        while n > 0:
            reversed_n = reversed_n * 10 + n % 10
            n //= 10
        return reversed_n