/*
You need to climb a staircase that has n steps, and you decide to get some extra exercise by jumping up the steps. You can cover at most k steps in a single jump. Return all the possible sequences of jumps that you could take to climb the staircase, sorted.
*/

func climbingStaircase(n int, k int) [][]int {
	var s = &List{};
	var rs = &List{}
	climbing(n, k, s, rs);
	return convert(rs);
}

func climbing(n int, k int, temp *List, rs *List){
	if(n == 0){
		rs.push(temp);
	}else{
	for i := 1; i <= k; i++ {
		if(n - i >= 0){
			var clone = cloneList(temp);
			clone.push(i);
			climbing(n-i, k, clone, rs);
		}
		}
	}
}

func cloneList(list *List) (*List){
	var rs = &List{}
	var temp = list.head;
	for temp != nil{
		rs.push(temp.value);
		temp = temp.next;
	}
	return rs;
}

func convert(list *List) ([][]int)  {
	var rs = make([][]int, list.size);
	var node = list.head;
	var i = 0;
	for node != nil {
		var value = node.value;
		subList, ok := value.(*List)
		if(ok){
			rs[i] = make([]int, subList.size)
			var subNode = subList.head;
			var j = 0;
			for subNode != nil {
				rs[i][j],_ = subNode.value.(int);
				j++;
				subNode = subNode.next;
			}
		}
		node = node.next;
		i++;
	}
	return rs;
}

type Node struct {
	value interface{};
	next, prev  *Node
}
type List struct {
	head, tail *Node
	size int;
}
func (l *List) first() *Node {
	return l.head
}
func (n *Node) Next() *Node {
	return n.next
}
func (n *Node) Prev() *Node {
	return n.prev
}
// Create new node with value
func (l *List) push(v interface{}) *List {
	n := &Node{value: v}
	l.size++;
	if l.head == nil {
		l.head = n		// First node
	} else {
		l.tail.next = n	// Add after prev last node
		n.prev = l.tail // Link back to prev last node
	}
	l.tail = n  		// reset tail to newly added node
	return l
}