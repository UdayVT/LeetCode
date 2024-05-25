# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        
        num1 = 0
        digit = 1
        while l1 != None:
            num1 += l1.val * digit
            digit *= 10
            l1 = l1.next
        
        num2 = 0
        digit = 1
        while l2 != None:
            num2 += l2.val * digit
            digit *= 10
            l2 = l2.next
        
        num3 = (str(num1 + num2))[::-1]

        start = ListNode(num3[0])
        prev = start
        for dig in num3[1:]:
            node = ListNode(dig)
            prev.next = node
            prev = prev.next

        return start