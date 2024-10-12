# Time complexity - put, remove, get O(1) -> O(n)
# Space complexity - O(n)
class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

class MyHashSet:
    SIZE = 1000

    def __init__(self):
        self.buckets = [None] * MyHashSet.SIZE

    def hash(self, value):
        return value % MyHashSet.SIZE

    def add(self, value: int) -> None:
        index = self.hash(value)
        if self.buckets[index] is None:
            self.buckets[index] = Node(value)
        else:
            current = self.buckets[index]
            if current.value == value:
                return
            while current.next is not None:
                if current.next.value == value:
                    return
                current = current.next
            current.next = Node(value)

    def contains(self, value: int) -> bool:
        index = self.hash(value)
        current = self.buckets[index]
        while current is not None:
            if current.value == value:
                return True
            current = current.next
        return False

    def remove(self, value: int) -> None:
        index = self.hash(value)
        if self.buckets[index] is None:
            return
        if self.buckets[index].value == value: # 10 -> 5 ==> 5
            self.buckets[index] = self.buckets[index].next
            return
        current = self.buckets[index]
        while current.next is not None: # 10 -> 12 -> 18 ==> 10 -> 18
            if current.next.value == value:
                current.next = current.next.next
                return
            current = current.next
