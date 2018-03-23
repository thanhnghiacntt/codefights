/*
You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.
*/
func addTwoHugeNumbers(a *ListNode, b *ListNode) *ListNode {
	var lenA = count(a);
	var lenB = count(b);
    if(lenA == 0){
        return b;
    }
    if(lenB == 0){
        return a;
    }
	if(lenA > lenB){
		 return addTwoNumbers(a, b)
	}
	return addTwoNumbers(b, a)
}

func addTwoNumbers(langer *ListNode, small *ListNode) *ListNode {
	var l = revert(langer);
	var s = revert(small);
	var nodeL = l;
	var nodeS = s;
	var mem = 0;
    var pre = nodeL;
	for nodeS != nil {
		var temp = nodeL.Value.(int) + nodeS.Value.(int) + mem;
		nodeL.Value = temp%10000;
		mem = temp / 10000;
        pre = nodeL;
		nodeL = nodeL.Next;
		nodeS = nodeS.Next;
	}
	for nodeL != nil && mem > 0 {
		var temp = nodeL.Value.(int) + mem;
		nodeL.Value = temp%10000;
		mem = temp / 10000;
        pre = nodeL
		nodeL = nodeL.Next;
	}
    if(mem > 0){
        pre.Next = &ListNode{
            Next: nil,
            Value:  mem,
        }
    }
	var result = revert(l);
	return result;
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

func count(a *ListNode) (int){
	if(a == nil){
		return 0;
	}
	return count(a.Next) + 1;
}
