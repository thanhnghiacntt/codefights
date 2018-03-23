/*
Note: Try to solve this task in O(list size) time using O(1) additional space, since this is what you'll be asked during an interview.

Given a singly linked list of integers l and a non-negative integer n, move the last n list nodes to the beginning of the linked list.
*/
func rearrangeLastN(l *ListNode, n int) *ListNode {
	var count = count(l);
	var last = count - n ;
	if(last < 1 || n == 0){
		return l;
	}
	var current = l;
	var result = l;
	for i := 1; current != nil && i < last; i++{
		current = current.Next;
	}
	var temp = current;
	if(temp != nil){
		result = temp.Next;
		for temp.Next != nil {
			temp = temp.Next;
		}
		temp.Next = l;
		current.Next = nil;
	}
	return result;
}
