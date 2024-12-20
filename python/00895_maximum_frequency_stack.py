# Time complexity - push, pop, peek: O (1)
# Space complexity - O (N)

# ["push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
# [ [5],    [7],    [5],    [7],    [4],    [5]],    5      7      5      4

# 5 - 3
# 7 - 2
# 4 - 1

# 3 - 5
# 2 - 7
# 1 - 4

class FreqStack:
    def __init__(self):
        self.freq_map = {}
        self.group_map = {}
        self.max_freq = 0

    def push(self, x: int) -> None:
        freq = self.freq_map.get(x, 0) + 1
        self.freq_map[x] = freq

        self.max_freq = max(self.max_freq, freq)

        if freq not in self.group_map:
            self.group_map[freq] = []

        self.group_map[freq].append(x)

    def pop(self) -> int:
        if self.max_freq in self.group_map and self.group_map[self.max_freq]:
            val = self.group_map[self.max_freq].pop()
            self.freq_map[val] -= 1

            if not self.group_map[self.max_freq]:
                self.max_freq -= 1

            return val
        return -1

    def peek(self) -> int:
        if self.max_freq in self.group_map and self.group_map[self.max_freq]:
            return self.group_map[self.max_freq][-1]
        return -1
