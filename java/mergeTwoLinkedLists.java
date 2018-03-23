/*
Note: Your solution should have O(l1.length + l2.length) time complexity, since this is what you will be asked to accomplish in an interview.

Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In other words, return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.
*/
ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    if(l1 == null){
        return l2;
    }
    if(l2 == null){
        return l1;
    }

    ListNode<Integer> temp = l1;
    if(l1.value < l2.value){
        temp = l1;
        l1 = l1.next;
    }else{
        temp = l2;
        l2 = l2.next;
    }
    ListNode<Integer> result = temp;
    while(l1 != null && l2 != null){
        if(l1.value < l2.value){
            temp.next = l1;
            l1 = l1.next;
        }else{
            temp.next = l2;
            l2 = l2.next;
        }
        temp = temp.next;
    }
    if(l1 != null){
        temp.next = l1;
    }
    if(l2 != null){
        temp.next = l2;
    }
    return result;
}