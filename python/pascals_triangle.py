#        Python
# Time complexity -  O (N2)
# Space complexity - O (N2)
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        triangle = []
        if numRows == 0:
            return triangle

        first_row = [1]
        triangle.append(first_row)

        for row_num in range(1, numRows):
            prev_row = triangle[row_num - 1]
            row = []

            row.append(1) # first

            for i in range(1, row_num):
                row.append(prev_row[i - 1] + prev_row[i])
            row.append(1) # last
            triangle.append(row)

        return triangle