from collections import defaultdict
from typing import List, Set

class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        # Build reverse graph: node -> list of parents
        graph = defaultdict(list)
        for parent, child in edges:
            graph[child].append(parent)

        # Memoization: node -> set of ancestors
        memo = {}

        def dfs(node: int) -> Set[int]:
            if node in memo:
                return memo[node]

            ancestors = set()
            for parent in graph[node]:
                ancestors.add(parent)
                ancestors.update(dfs(parent))

            memo[node] = ancestors
            return ancestors

        # Build final result
        result = []
        for i in range(n):
            ancestors = sorted(dfs(i))
            result.append(ancestors)

        return result

# Time complexity - O(n^2 logn)
# Space complexity - O(n^2)