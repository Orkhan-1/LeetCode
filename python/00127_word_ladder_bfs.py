class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0  # No transformation possible

        queue = deque([beginWord])
        level = 1  # BeginWord is level 1

        while queue:
            for _ in range(len(queue)):
                word = queue.popleft()
                if word == endWord:
                    return level

                for i in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if c == word[i]:
                            continue
                        next_word = word[:i] + c + word[i+1:]
                        if next_word in word_set:
                            queue.append(next_word)
                            word_set.remove(next_word)  # Mark visited

            level += 1

        return 0  # No path found
