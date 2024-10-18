# Time complexity - O (min (n1,n2)) - where n1 and n2 are the number of non-zero elements in the vectors
# Space complexity - O (1)
class SparseVector:
    def __init__(self, nums):
        self.non_zero_elements = {i: num for i, num in enumerate(nums) if num != 0}

    def dotProduct(self, vec):
        result = 0
        for index, value in self.non_zero_elements.items():
            if index in vec.non_zero_elements:
                result += value * vec.non_zero_elements[index]
        return result
