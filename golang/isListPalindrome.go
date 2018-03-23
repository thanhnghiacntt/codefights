/*
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers, determine whether or not it's a palindrome.
*/
type List struct{
	Header *ListNode;
	Tail *ListNode;
}

func isListPalindrome(l *ListNode) bool {
	if(l == nil){
		return true;
	}
	R := &List{
		Header: nil,
		Tail: nil,
	}
	var next = l;
	for next != nil {
		R.Insert(next.Value);
		next = next.Next
	}
	var temp = revert(R.Header);
	for temp != nil{
		if(temp.Value != l.Value){
			return false;
		}
		temp = temp.Next;
		l = l.Next;
	}
	 return true;
}

func (L *List) Insert(key interface{}) {
	list := &ListNode{
		Next: nil,
		Value:  key,
	}
	if(L.Header == nil){
		L.Header = list;
	}
	if(L.Tail == nil){
		L.Tail = list;
	}else{
		L.Tail.Next = list;
		L.Tail = list;
	}
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
