# Input: logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5

# 0 - 2, 5
# 1 - 2, 3

# Output: [0,2,0,0,0]

class Solution:
    def findingUsersActiveMinutes(self, logs: List[List[int]], k: int) -> List[int]:
        user_minutes = {}

        # Step 1: Populate user activity sets
        for user, minute in logs:
            if user not in user_minutes:
                user_minutes[user] = set()
            user_minutes[user].add(minute)

        # Step 2: Count UAM frequencies
        result = [0] * k
        for minutes in user_minutes.values():
            uam = len(minutes)
            if uam <= k:
                result[uam - 1] += 1

        return result

# Time complexity - O(N)
# Space complexity - O (U) - unique users