# Time complexity - put, remove, get O(1) -> O(n)
# Space complexity - O(n)
class MyHashMap:

    def __init__(self):
        self.SIZE = 10000
        self.map = [None] * self.SIZE

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def hash(self, key: int) -> int:
        return key % self.SIZE

    def put(self, key: int, value: int) -> None:
        index = self.hash(key)
        if self.map[index] is None:
            self.map[index] = self.Node(key, value)
        else:
            current = self.map[index]
            while True:
                if current.key == key:
                    current.value = value
                    return
                if current.next is None:
                    break
                current = current.next
            current.next = self.Node(key, value)

    def get(self, key: int) -> int:
        index = self.hash(key)
        current = self.map[index]
        while current is not None:
            if current.key == key:
                return current.value
            current = current.next
        return -1

    def remove(self, key: int) -> None:
        index = self.hash(key)
        current = self.map[index]
        if current is None:
            return

        if current.key == key:
            self.map[index] = current.next # (3, 11) -> (5, 10) ==> (5, 10)
            return

        prev = current # (3, 11) -> (5, 10) -> (8->20) ==> (3, 11) -> (8->20)
        while current is not None:
            if current.key == key:
                prev.next = current.next
                return
            prev = current
            current = current.next
