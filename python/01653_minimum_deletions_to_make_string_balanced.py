#        Python
# Time complexity - O (n)
# Space complexity - O (1)
class Solution:

    # "aababbab" => "aaabbb" => 2

    # "aaaabbbbaaaaaaa"
    def minimumDeletions(self, s: str) -> int:
        b = 0
        delete = 0

        for char in s:
            if char == 'b':
                b += 1
            else:
                delete += 1
                delete = min(delete, b) # aaaabbbb,  aaaabbbbaaa, aaaabbbbaaaaaaa

        return delete
