/*
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers, determine whether or not it's a palindrome.
*/

boolean isListPalindrome(ListNode<Integer> l) {
    List<Integer> list = new ArrayList<Integer>();
    while(l != null){
        list.add(l.value);
        l = l.next;
    }
    Integer[] temp = list.toArray(new Integer[list.size()]);
    int left = 0;
    int right = temp.length - 1;
    while(left<right){
        if(temp[left].equals(temp[right])){
            left++;
            right--;
        }else{
            return false;
        }			
    }
    return true;
}