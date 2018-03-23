/*
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.
*/

ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    if(l == null){
        return null;
    }

    ListNode<Integer>current = l;
    ListNode<Integer>next = l.next;
    while(next != null){
        if(next.value.equals(k)){
            current.next = next.next;
        }else{
            current = next;
        }
        next = next.next;
    }
    if(l != null && l.value.equals(k)){
        l = l.next;
    }
    return l;
}