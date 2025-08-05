class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        from collections import defaultdict

        # Build the graph: course -> set of prerequisites
        graph = defaultdict(set)
        for course, prereq in prerequisites:
            graph[course].add(prereq)

        visited = set()

        def hasCycle(node, stack):
            if node in stack:
                return True
            if node in visited:
                return False

            stack.add(node)
            for neighbor in graph.get(node, []):
                if hasCycle(neighbor, stack):
                    return True
            stack.remove(node)
            visited.add(node)
            return False

        for course in range(numCourses):
            if hasCycle(course, set()):
                return False

        return True

# Time complexity - O(n + p) - n is the number of courses and p is the number of prerequisites
# Space complexity - O(n + p)