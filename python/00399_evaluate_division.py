from collections import defaultdict

# Time complexity - O(E + Q * V)
#
# Graph Construction: O(E) -  E is the number of equations (edges)
# DFS Search: in the worst case, we visit all nodes V and we do it for Q times for each query O(Q * V)
#
# Space complexity - O(E + V)
#
# Graph Storage: For each of the E equations, we store two edges in this adjacency list => O(E).
# Visited Set: in the worst case it'll contain all nodes => O (V)
# DFS recursion stack: in the worst case it'll contain all nodes => O (V)
#
# O(E + 2V) => O(E + V)

class Solution:
    def calcEquation(self, equations, values, queries):
        graph = defaultdict(dict)
        for (A, B), value in zip(equations, values):
            graph[A][B] = value
            graph[B][A] = 1.0 / value

        def dfs(A, B, visited):
            if A not in graph or B not in graph:
                return -1.0
            if A == B:
                return 1.0
            visited.add(A)
            for neighbor, value in graph[A].items():
                if neighbor in visited:
                    continue
                result = dfs(neighbor, B, visited)
                if result != -1.0:
                    return result * value
            return -1.0

        result = []
        for A, B in queries:
            result.append(dfs(A, B, set()))

        return result
