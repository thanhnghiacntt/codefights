/*
You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.
*/

ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    if(a == null){
        return b;
    }
    if(b == null){
        return a;
    }
    int sa = size(a);
    int sb = size(b);
    for (int i = sa; i < sb; i++) {
        ListNode<Integer> temp = new ListNode<Integer>(0);
        temp.next = a;
        a = temp;
    }
    for (int i = sb; i < sa; i++) {
        ListNode<Integer> temp = new ListNode<Integer>(0);
        temp.next = b;
        b = temp;
    }
    ListNode<Integer> at = revert(a);
    ListNode<Integer> bt = revert(b);
    int remember = 0;
    ListNode<Integer> asum = at;
    ListNode<Integer> bsum = bt;
    while(asum != null && bsum != null){
        int sum = asum.value + bsum.value + remember;
        remember = sum/10000;
        sum = sum%10000;
        asum.value = sum;
        asum = asum.next;
        bsum = bsum.next;
    }
    if(remember > 0){
        asum = at;
        while(asum.next != null){
            asum = asum.next;
        }
        asum.next = new ListNode<Integer>(remember);
    }
    return revert(at);
}

ListNode<Integer> revert(ListNode<Integer> root){
    if(root == null){
        return null;
    }
    Stack<ListNode<Integer>> stack = new Stack<ListNode<Integer>>();
    ListNode<Integer>temp = root;
    while(temp != null){
        stack.add(temp);
        temp = temp.next;
    }
    ListNode<Integer> result = stack.pop();
    temp = result; 
    while(stack.size() > 0){
        if(temp.equals(result)){
            result.next = stack.pop();
            temp = result.next;
        }else{
            temp.next = stack.pop();
            temp = temp.next;
        }
    }
    temp.next = null;
    return result;
}
int size(ListNode<Integer> a){
    if(a == null){
        return 0;
    }
    int count = 0;
    while(a != null){
        a = a.next;
        count++;
    }
    return count;
}