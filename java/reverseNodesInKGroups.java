/*
Note: Your solution should have O(n) time complexity, where n is the number of element in l, and O(1) additional space complexity, since this is what you would be asked to accomplish in an interview.

Given a linked list l, reverse its nodes k at a time and return the modified list. k is a positive integer that is less than or equal to the length of l. If the number of nodes in the linked list is not a multiple of k, then the nodes that are left out at the end should remain as-is.

You may not alter the values in the nodes - only the nodes themselves can be changed.
*/

func reverseNodesInKGroups(l *ListNode, k int) *ListNode {
	var current = l;
	if(k < 2){
		return l;
	}
	var next = l.Next;
	for i:=1 ; i < k; i++{
		current = current.Next;
		next = next.Next;
	}
	var count = next;
    var i = 0;
	for i = 0; count != nil && i < k; i++ {
		count = count.Next
	}
	if(count != nil || i == k){
		next = reverseNodesInKGroups(next, k);
	}
	current.Next = nil;
	var temp = revert(l);
	current = temp;
	for current.Next != nil{
		current = current.Next;
	}
	current.Next = next;
	return temp;
}


func revert(l *ListNode) (*ListNode){
	var current = l;
	if(l == nil || l.Next == nil){
		return l;
	}
	var next = l.Next;
	if(next.Next == nil){
		next.Next = current;
		current.Next = nil;
		return next;
	}
	var nextNext = next.Next;
	current.Next = nil;
	for nextNext != nil {
		next.Next = current;
		current = next;
		next = nextNext;
		nextNext = nextNext.Next;
	}
	next.Next = current;
	return next;
}