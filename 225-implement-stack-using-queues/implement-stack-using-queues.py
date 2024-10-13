class Slist():
    def __init__(self):
        # NOTHING CAN BE CHANGED HERE
        self._first = None
        self._last = None
        self._len = 0 
        
    #############################
    # WRITE All public functions BELOW
    # YOU CAN HAVE ANY NUMBER OF PRIVATE FUNCTIONS YOU WANT
    #############################

    def is_empty(self):
        return self._len == 0

    def append(self, value):
        new_node = ListNode(value)
        if self._first is None:
            self._first = new_node
            self._last = new_node
        else:
            self._last.next = new_node
            self._last = new_node
        self._len += 1

    def pop_last(self):
        if self.is_empty():
            return None
        if self._first == self._last:
            val = self._first.val
            self._first = None
            self._last = None
        else:
            current = self._first
            while current.next != self._last:
                current = current.next
            val = self._last.val
            self._last = current
            self._last.next = None
        self._len -= 1
        return val

    def pop_first(self):
        if self.is_empty():
            return None
        val = self._first.val
        self._first = self._first.next
        if self._first is None:
            self._last = None
        self._len -= 1
        return val

    def peek_first(self):
        if self.is_empty():
            return None
        return self._first.val

    def peek_last(self):
        if self.is_empty():
            return None
        return self._last.val

    def get_length(self):
        return self._len

    def insert_first(self, value):
        new_node = ListNode(value)
        if self.is_empty():
            self._first = new_node
            self._last = new_node
        else:
            new_node.next = self._first
            self._first = new_node
        self._len += 1

############################################################
#  class  MyStack
# 225. Implement Stack using Queues
# https://leetcode.com/problems/implement-stack-using-queues
########################################################### 
class MyStack:
    def __init__(self):
        # NOTHING CAN BE CHANGED HERE
        self._s = Slist()

    def push(self, x: int) -> None:
        self._s.append(x)

    def pop(self) -> int:
        return self._s.pop_last()

    def top(self) -> int:
        return self._s.peek_last()

    def empty(self) -> bool:
        return self._s.is_empty()