package DSA.linked_list;

import java.util.List;

public class InterviewQuestion {

    // 141 - floyd cycle
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;      // moves 2 step at a time
        ListNode slow = head;      // moves 1 step at a time
        // fast != null        → fast itself isn't null
        // fast.next != null   → fast.next.next won't throw NullPointerException
        while(fast != null && fast.next != null){
            fast = fast.next.next;   // hare jumps 2
            slow = slow.next;        // tortoise walks 1

            if(fast == slow){      // pointer equality — same node in memory
                return true;        // cycle confirmed
            }
        }
        return false;
    }

    // Find length of the cycle
    public int LengthCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        // Phase 1: detect cycle using Floyd's algorithm
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){

               // phase 2: count cycle length from meeting point
                ListNode temp = slow;   // anchor at meeting point
                int length = 0;

                // do-while ensures we move at least once before checking
                // if we used while, temp != slow would be false immediately
                do{
                    temp = temp.next;      // walk one step
                    length++;              // count it
                }while (temp!= slow);      // stop when we're back to meeting point
                return length;
            }
        }
        return 0;

    }

    // 142- detect cycle
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        // Phase 1: detect meeting point
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // 2 steps
            slow = slow.next;       // 1 step

            if (fast == slow) {

                // Phase 2: find cycle start
                // reset fast back to head — slow stays at meeting point
                fast = head;

                // move both ONE step at a time
                // they meet exactly at cycle start (proven by F = L - a)
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                // both point to cycle start
                return slow;
            }
        }

        // fast hit null → no cycle
        return null;
    }

    // 202 Happy Number
    public boolean isHappy(int n) {

        int slow = n;   // moves one step at a time (tortoise)
        int fast = n;   // moves two steps at a time (hare)

        // do-while: both start at n, so we must move before first check
        // if we used while(fast != slow), it exits immediately since both = n
        do {
            slow = findSquare(slow);                    // 1 step
            fast = findSquare(findSquare(fast));        // 2 steps
        } while (fast != slow);  // loop until they meet

        // meeting point is either 1 (happy) or inside a cycle (unhappy)
        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int findSquare(int number) {

        int ans = 0;

        while (number > 0) {
            int rem = number % 10;      // extract last digit
            ans += rem * rem;           // square it and accumulate
            number /= 10;               // remove last digit
        }

        return ans;
    }

    // 876 middle of linked list

    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f =head;

        while (f != null && f.next != null){
            s =s.next;
            f= f.next.next;
        }
        return s;
    }

    // 148 - sort list

    public ListNode sortList(ListNode head) {

        // base case: 0 or 1 node — already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Phase 1: find middle and split into two halves
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;  // second half starts here
        mid.next = null;                // cut the list into two halves

        // Phase 2: recursively sort both halves
        ListNode left = sortList(head);       // sort left half
        ListNode right = sortList(rightHead); // sort right half

        // Phase 3: merge two sorted halves
        return merge(left, right);
    }

    // find middle node using slow/fast pointers
    private ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next; // fast starts one step ahead — gives LEFT middle

        // fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now at the middle
        return slow;
    }

    // merge two sorted lists — same as LeetCode 21
    private ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // attach remaining nodes
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }

    // 92- reverse linkedlist 2

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // dummy handles the edge case where left=1 (nothing before window)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: move prev to node just before position 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // current = first node of window
        // stays fixed — naturally becomes tail of reversed sublist
        ListNode current = prev.next;

        // Step 2: pull next node to front of window (right-left) times
        for (int i = 0; i < right - left; i++) {

            ListNode nextTemp = current.next;   // node to pull to front

            current.next = nextTemp.next;       // skip over nextTemp

            nextTemp.next = prev.next;          // nextTemp points to current window head

            prev.next = nextTemp;               // nextTemp becomes new window head
        }

        return dummy.next;
    }

}









class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}
