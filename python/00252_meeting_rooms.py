
# intervals = [[2, 4], [1, 3], [5, 6]]

# sort
# intervals = [[1, 3], [2, 4], [5, 6]]

# Time complexity - O(n log n)
# Space complexity - O(1)

def canAttendMeetings(intervals):
    intervals.sort(key=lambda x: x[0])

    for i in range(1, len(intervals)):
        if intervals[i][0] < intervals[i - 1][1]:
            return False

    return True
