/*
Note: Your solution should have O(l1.length + l2.length) time complexity, since this is what you will be asked to accomplish in an interview.

Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In other words, return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.
*/

type List struct{
	Header *ListNode;
	Tail *ListNode;
}

func mergeTwoLinkedLists(l1 *ListNode, l2 *ListNode) *ListNode {
	merge := &List{
		Header: nil,
		Tail: nil,
	}
	for l1!= nil && l2 != nil {
		if(l1.Value.(int) < l2.Value.(int)){
			merge.Insert(l1.Value);
			l1 = l1.Next;
		}else{
			merge.Insert(l2.Value);
			l2 = l2.Next;
		}
	}
	for l1!= nil {
		merge.Insert(l1.Value);
		l1 = l1.Next;
	}
	for l2 != nil {
		merge.Insert(l2.Value);
		l2 = l2.Next;
	}
	return merge.Header;
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
