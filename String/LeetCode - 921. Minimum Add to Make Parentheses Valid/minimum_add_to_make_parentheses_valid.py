#     Python
# Time complexity - O (N)
# Space complexity - O (1)

def minAddToMakeValid(self, s: str) -> int:
    open_parentheses = 0
    min_add = 0

    for char in s:
        if char == '(':
            open_parentheses += 1
        elif char == ')':
            if open_parentheses == 0:
                min_add += 1
            else:
                open_parentheses -= 1

    return min_add + open_parentheses
