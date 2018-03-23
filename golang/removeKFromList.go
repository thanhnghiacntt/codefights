/*
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.
*/
func removeKFromList(l *ListNode, k int) *ListNode {
	var result = l;
	// Remove all node if first is k.
	for result != nil && result.Value == k {
		result = result.Next;
	}
	var current = l;
	var next = current;
	if(current != nil){
		next = current.Next;
	}
	for next != nil {
		if(next.Value == k){
				next = next.Next;
				current.Next = next;
		}else{
				next = next.Next;
				current = current.Next;
		}
	}
	return result;
}
