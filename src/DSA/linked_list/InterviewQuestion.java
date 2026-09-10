package DSA.linked_list;

import java.util.List;

public class InterviewQuestion {

    // 141 - floyd cycle
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;      // moves 2 step at a time
        ListNode slow = head;      // moves 1 step at a time
        // fast != null        → fast itself isn't null
        // fast.next != null   → fast.next.next won't throw NullPointerException
        while (fast != null && fast.next != null) {
            fast = fast.next.next;   // hare jumps 2
            slow = slow.next;        // tortoise walks 1

            if (fast == slow) {      // pointer equality — same node in memory
                return true;        // cycle confirmed
            }
        }
        return false;
    }

    // Find length of the cycle
    public int LengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // Phase 1: detect cycle using Floyd's algorithm
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {

                // phase 2: count cycle length from meeting point
                ListNode temp = slow;   // anchor at meeting point
                int length = 0;

                // do-while ensures we move at least once before checking
                // if we used while, temp != slow would be false immediately
                do {
                    temp = temp.next;      // walk one step
                    length++;              // count it
                } while (temp != slow);      // stop when we're back to meeting point
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
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
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

    // 234 - palindrome
    public boolean isPalindrome(ListNode head) {

        // Step1: find the middle node
        ListNode mid = middleNode(head);

        // step2: reverse second half in place
        // headSecond = new head of reversed second half
        ListNode headSecond = reverseList(mid);

        // save pointer to restore list later
        ListNode rereverseHead = headSecond;

        // Step 3: compare first half and reversed second half
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;          // mismatch found — not a palindrome
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        // Step 4: restore the list (good practice, avoids corrupting structure)
        reverseList(rereverseHead);

        // if both reached null → all matched → palindrome
        // if either is non-null → loop broke early on mismatch
        return head == null || headSecond == null;
    }

    // standard iterative reverse
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }


    // 143 Reorder list
    public void reorderList(ListNode head) {

        // ── Edge case: 0 or 1 node needs no reordering ──────────────────────
        if (head == null || head.next == null) {
            return;
        }

        // ── Step 1: Find the MIDDLE node (slow/fast pointer) ─────────────────
        // For [1,2,3,4,5] → mid = node(3)
        // For [1,2,3,4]   → mid = node(3)  (upper mid for even length)
        ListNode mid = middleNode(head);

        // ── Step 2: Reverse the SECOND HALF starting from mid ────────────────
        // Before: 1 → 2 → 3 → 4 → 5   (mid points to 3)
        // After:  second = 5 → 4 → 3 → null
        // Note:   first half still exists as  1 → 2 → 3 (3's next was cut by reversal)
        ListNode second = reverseList(mid);
        ListNode first  = head;

        // ── Step 3: MERGE two halves by interleaving ─────────────────────────
        // first:  1 → 2 → 3
        // second: 5 → 4 → 3
        //
        // Each iteration:
        //   - Wire first  → second
        //   - Wire second → first's original next
        //   - Advance both pointers

        while (first != null && second != null) {

            // Save next pointers before breaking links
            ListNode nextFirst  = first.next;   // e.g. 2 (will be processed next)
            ListNode nextSecond = second.next;  // e.g. 4

            first.next  = second;    // 1 → 5
            second.next = nextFirst; // 5 → 2

            // Advance both pointers to their saved "next" nodes
            first  = nextFirst;   // move to 2
            second = nextSecond;  // move to 4
        }

        // ── Termination: cut off the tail ────────────────────────────────────
        // When first half is longer (odd-length list), the last node of
        // the first half may still point somewhere — null it out cleanly.
        if (first != null) {
            first.next = null;
        }
    }

    // 25 reverse k group
    public ListNode reverseKGroup(ListNode head, int k) {

        // Dummy node so we never have to special-case the real head changing
        ListNode dummy    = new ListNode(0);
        dummy.next        = head;
        ListNode groupPrev = dummy;  // tail of the already-processed portion

        while (true) {

            // ── Step 1: Check if k nodes are available ────────────────────────
            // getKthNode walks k steps; returns null if fewer than k nodes exist
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break;               // < k nodes remain → stop

            ListNode groupNext = kth.next;        // first node AFTER this group

            // ── Step 2: Reverse exactly k nodes ──────────────────────────────
            // Reverse window: [groupPrev.next  ...  kth]
            // We set prev = groupNext so the reversed tail auto-connects forward
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;       // first node of current group

            while (curr != groupNext) {           // stop when we've passed kth
                ListNode next = curr.next;
                curr.next     = prev;             // flip the pointer
                prev          = curr;
                curr          = next;
            }
            // After loop: prev = kth (new head), groupPrev.next (old head = new tail)

            // ── Step 3: Stitch the reversed group into the list ───────────────
            ListNode newTail  = groupPrev.next;   // original head is now the tail
            groupPrev.next    = kth;              // connect previous part → new head (kth)
            // newTail.next is already = groupNext (set during reversal via prev=groupNext)

            // ── Step 4: Advance groupPrev to the tail of the reversed group ───
            groupPrev = newTail;
        }

        return dummy.next;
    }

    // ── Helper: Walk k steps from 'curr'; return that node (or null) ──────────
// Used to check whether a full group of k nodes exists before reversing
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;   // null  → fewer than k nodes existed
    }



    // 61 rotate list
    public ListNode rotateRight(ListNode head, int k) {

        // ── Edge Case ─────────────────────────────────────────────────────────
        // k <= 0    : zero or negative rotation → no change needed
        // head==null: empty list               → nothing to rotate
        // head.next : single node              → rotating changes nothing
        if(k <= 0 || head == null || head.next == null){
            return head;
        }

        // ── Step 1: Find LENGTH and LAST node ─────────────────────────────────
        // 'last' will walk to the final node of the list
        // 'length' counts total nodes (starts at 1 because head already counts)
        ListNode last = head;
        int length = 1;

        while(last.next != null){   // keep walking until we hit the final node
            last = last.next;       // move one step forward
            length++;               // count this node
        }
        // After loop:
        //   last   = final node (e.g. node(5))
        //   length = total count  (e.g. 5)
        //
        // Example: [1→2→3→4→5]
        //                    ↑
        //                  last = node(5), length = 5

        // ── Step 2: Make the list CIRCULAR ────────────────────────────────────
        // Connect tail back to head → forms a ring
        // Now we just need to find the correct place to CUT the ring
        last.next = head;
        //
        // Before: 1 → 2 → 3 → 4 → 5 → null
        // After:  1 → 2 → 3 → 4 → 5
        //         ↑ ←←←←←←←←←←←←← ↑
        //              (ring formed)

        // ── Step 3: Calculate actual ROTATIONS and SKIP ───────────────────────
        // Rotating by full 'length' = back to original = wasted work
        // k % length removes all full cycles, keeps only meaningful rotation
        int rotations = k % length;
        //
        // k=7, length=5 → 7%5=2  (only 2 effective rotations)
        // k=5, length=5 → 5%5=0  (full cycle = no change)
        // k=2, length=5 → 2%5=2  (unchanged, less than length)

        // 'skip' = nodes that stay at front and shift to the end
        // These nodes form the TAIL portion of the final result
        // 'rotations' nodes come to FRONT, remaining 'skip' nodes go to END
        int skip = length - rotations;
        //
        // length=5, rotations=2:
        //   skip = 5 - 2 = 3
        //   [1 → 2 → 3]  →  [4 → 5]
        //    ←skip=3→         ←rot=2→
        //    goes to END      comes to FRONT
        //   Result: 4 → 5 → 1 → 2 → 3

        // ── Step 4: Walk to NEW TAIL (newLast) ───────────────────────────────
        // New tail is the node at position 'skip' from head
        // We start AT head (position 1), so walk (skip - 1) more steps
        ListNode newLast = head;
        for(int i = 0; i < skip - 1; i++){  // walk (skip-1) steps
            newLast = newLast.next;
        }
        // After loop: newLast = node at position 'skip' = new tail
        //
        // skip=3, walk (skip-1)=2 steps from head:
        //   start : newLast = node(1)   [position 1]
        //   i=0   : newLast = node(2)   [position 2]
        //   i=1   : newLast = node(3)   [position 3 = skip] → STOP
        //
        // newLast = node(3) ← this is the NEW TAIL ✓

        // ── Step 5: Cut the Circle and Set NEW HEAD ───────────────────────────
        // newLast.next is the first node of rotated portion = new head
        head = newLast.next;
        // Example: node(3).next = node(4)  →  new head = node(4)
        //
        // Ring before cut:
        //   1 → 2 → 3 → 4 → 5
        //             ↑   ↑
        //          newLast  new head

        // Cut the ring here → newLast becomes the true final node (null terminated)
        newLast.next = null;
        //
        // After cut:
        //   4 → 5 → 1 → 2 → 3 → null
        //   ↑                    ↑
        // new head            newLast

        // ── Return new head ───────────────────────────────────────────────────
        return head;    // node(4) in our example
    }


    // 160 - intwrsection of two linkedlist

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // ── Edge Case ─────────────────────────────────────────────────────────
        // If either list is empty, there can't be any intersection
        if(headA == null || headB == null){
            return null;
        }

        // ── Two Pointer Setup ─────────────────────────────────────────────────
        // Both pointers start at the head of their respective lists
        ListNode a = headA;     // pointer for list A
        ListNode b = headB;     // pointer for list B

        // ── Walk Until They Meet ──────────────────────────────────────────────
        // Loop runs until both pointers point to the SAME node
        // (either the intersection node, or both null = no intersection)
        while(a != b){

            // Move pointer A one step forward
            // If A has reached end of listA → redirect to headB
            // If A is in listB already → keep moving normally
            a = (a == null) ? headB : a.next;

            // Move pointer B one step forward
            // If B has reached end of listB → redirect to headA
            // If B is in listA already → keep moving normally
            b = (b == null) ? headA : b.next;
        }

        // ── Return Result ─────────────────────────────────────────────────────
        // Case 1: a == b == intersection node → return it
        // Case 2: a == b == null → no intersection → return null
        return a;
    }

    // 237 - delete a node in linked list
    public void deleteNode(ListNode node) {
        // We don't have access to the previous node or head.
        // So we can't do the classic: prev.next = node.next

        // TRICK: Make this node look like its next node,
        // then skip (unlink) the next node.

        // Step 1: Copy the value of the next node into current node
        node.val = node.next.val;

        // Step 2: Skip over the next node
        // The original node.next is now orphaned (no reference to it)
        // Java garbage collector will clean it up automatically
        node.next = node.next.next;
    }


    // 203 remove linkedlist elements

    public ListNode removeElements(ListNode head, int val) {

        // Create a dummy node before the actual head.
        // It helps us easily handle deletion of the head node.
        ListNode dummy = new ListNode(0);

        // Connect the dummy node to the original head.
        dummy.next = head;

        // 'current' will be used to traverse the linked list.
        ListNode current = dummy;

        // Continue until current.next becomes null.
        // We check current.next because we need to modify
        // the link of the node before the node we want to delete.
        while (current.next != null) {

            // Check whether the next node contains the value
            // that we want to remove.
            if (current.next.val == val) {

                // Skip the next node.
                //
                // Example:
                // current → 6 → 3
                //
                // After this:
                // current → 3
                //
                // Therefore, the node containing 6 is removed
                // from the linked list.
                current.next = current.next.next;

            } else {

                // If the next node does not contain val,
                // move current one step forward.
                current = current.next;
            }
        }

        // Return the actual head, not the dummy node.
        return dummy.next;
    }

    // 2 Add two numbers
    public ListNode addTwoNumbers(ListNode l1 , ListNode l2){
        // Dummy node to simplify result list building
        // we return dummy.next at the end
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;    // carry starts at 0

        // loop runs as long as either list has digits or there is a carry left
        while (l1 != null || l2 != null || carry != 0){

            // get current digit from l1
            // if l1 is exhausted, treat its digit as 0
            int digit1;
            if(l1 != null){
                digit1 = l1.val;
            }
            else{
                digit1 = 0;
            }

            // get current digit from 12
            // if 12 is exhausted, treat its digit as 0
            int digit2;
            if(l2 != null){
                digit2 = l2.val;
            }
            else{
                digit2 = 0;
            }

            // Add both digits plus carry from previous step
            int sum = digit1 + digit2 + carry;

            // new carry for next step(can only be 0 or 1)
            carry = sum/10;

            // Actual digit to store in result node(ones place)
            int digit = sum % 10;

            //Create new result node and attach to result list
            current.next = new ListNode(digit);
            current = current.next;          // move result pointer forward

            // move l1 forward only if it is not null
            if(l1 != null){
                l1 = l1.next;
            }

            // move l2 forward only if it is not null
            if(l2 != null){
                l2 = l2.next;
            }
        }
        // dummy.next is the actual head of result list
        return dummy.next;
    }

    // 328 - odd even linkedlist

    public ListNode oddEvenList(ListNode head) {

        // Edge case: if list is empty or has only one node, return as is
        if (head == null || head.next == null) {
            return head;
        }

        // odd  → pointer to the current tail of odd chain
        // even → pointer to the current tail of even chain
        // evenHead → saved head of even chain (to attach at end)
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;  // save even head — never moves

        // Traverse until even chain is exhausted
        // even == null  → list had even number of nodes
        // even.next == null → list had odd number of nodes
        while (even != null && even.next != null) {

            // Connect odd to the next odd node (skip one even node)
            odd.next = even.next;

            // Move odd pointer forward to the next odd node
            odd = odd.next;

            // Connect even to the next even node (skip one odd node)
            even.next = odd.next;

            // Move even pointer forward to the next even node
            even = even.next;
        }

        // Attach even chain after the odd chain
        odd.next = evenHead;

        // Head of odd chain is still the original head
        return head;
    }


    // 23 - merge k sorted list
    public ListNode mergeKLists(ListNode[] lists) {

        // If there are no lists, return null.
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Start the divide-and-conquer process.
        // '0' is the first list.
        // 'lists.length - 1' is the last list.
        return mergeRange(lists, 0, lists.length - 1);
    }


    // This function divides the array of lists into smaller parts.
    private ListNode mergeRange(ListNode[] lists, int left, int right) {

        // Base case:
        // If there is only one list, nothing needs to be merged.
        if (left == right) {
            return lists[left];
        }

        // Find the middle index.
        int mid = left + (right - left) / 2;

        // Recursively merge the left half.
        ListNode leftList = mergeRange(lists, left, mid);

        // Recursively merge the right half.
        ListNode rightList = mergeRange(lists, mid + 1, right);

        // Merge the two sorted lists.
        return mergeTwoLists(leftList, rightList);
    }


    // This function merges two sorted linked lists.
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Create a dummy node to make insertion easier.
        ListNode dummy = new ListNode(0);

        // 'current' keeps track of the last node
        // in the merged list.
        ListNode current = dummy;

        // Continue while both lists still have nodes.
        while (list1 != null && list2 != null) {

            // If list1's current value is smaller,
            // attach list1's node.
            if (list1.val <= list2.val) {

                current.next = list1;

                // Move list1 forward.
                list1 = list1.next;

            } else {

                // Otherwise, attach list2's node.
                current.next = list2;

                // Move list2 forward.
                list2 = list2.next;
            }

            // Move current to the newly added node.
            current = current.next;
        }

        // If list1 still has nodes, attach them.
        if (list1 != null) {
            current.next = list1;
        }

        // If list2 still has nodes, attach them.
        if (list2 != null) {
            current.next = list2;
        }

        // Return the actual head of the merged list.
        return dummy.next;
    }

    // 83 partiiton list
    public ListNode partition(ListNode head, int x) {

        // --- Step 1: Create two dummy (sentinel) nodes ---

        // 'lessDummy' acts as the anchor/head of the "less than x" partition
        // Using value 0 — doesn't matter, it's just a placeholder
        ListNode lessDummy = new ListNode(0);

        // 'greaterDummy' acts as the anchor/head of the "greater than or equal to x" partition
        ListNode greaterDummy = new ListNode(0);

        // --- Step 2: Create two tail pointers for each partition ---

        // 'less' always points to the LAST node in the "less than x" chain
        // Starts at the dummy node (chain is empty initially)
        ListNode less = lessDummy;

        // 'greater' always points to the LAST node in the "≥ x" chain
        ListNode greater = greaterDummy;

        // --- Step 3: Traverse the original linked list ---

        // 'curr' starts at the head and moves node by node through the list
        ListNode curr = head;

        while (curr != null) {          // Loop runs until we've visited every node

            if (curr.val < x) {         // This node belongs in the "less" partition

                less.next = curr;       // Attach curr to the END of the less chain
                less = less.next;       // Move the less tail pointer one step forward

            } else {                    // curr.val >= x → belongs in "greater" partition

                greater.next = curr;    // Attach curr to the END of the greater chain
                greater = greater.next; // Move the greater tail pointer one step forward
            }

            curr = curr.next;           // Move to the next node in the ORIGINAL list
        }

        // --- Step 4: Terminate the greater partition ---
        // CRITICAL STEP: The last node of the greater chain may still have its
        // old .next pointer from the original list, which could cause a cycle.
        // We MUST set it to null to properly end the list.
        greater.next = null;

        // --- Step 5: Connect the two partitions ---
        // The end of the "less" chain should point to the START of the "greater" chain
        // greaterDummy.next skips the dummy node and gives the first real greater node
        less.next = greaterDummy.next;

        // --- Step 6: Return the head of the merged partitioned list ---
        // lessDummy is a fake node — the real list starts at lessDummy.next
        return lessDummy.next;
    }

    // 147 - insertion sort list

    public ListNode insertionSortList(ListNode head) {

        // --- Step 1: Create a dummy node ---
        // Acts as the anchor/head of our new SORTED list
        // All sorted nodes will be attached after this dummy
        ListNode dummy = new ListNode(0);

        // --- Step 2: 'curr' traverses the ORIGINAL (unsorted) list ---
        // Starts at head, picks one node at a time to insert into sorted list
        ListNode curr = head;

        while (curr != null) {              // Loop until all nodes are processed

            // --- Step 3: Save the next node BEFORE breaking links ---
            // Because we will change curr.next when inserting, we must
            // save the reference to the next original node first
            ListNode nextNode = curr.next;

            // --- Step 4: Find the correct insertion position in sorted list ---
            // 'prev' starts at dummy and scans the sorted list
            // We stop when prev.next is null OR prev.next.val >= curr.val
            // That means curr should be inserted BETWEEN prev and prev.next
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;           // Move forward in the sorted list
            }

            // --- Step 5: Insert curr between prev and prev.next ---

            // curr's next should point to whatever was after prev
            curr.next = prev.next;

            // prev's next should now point to curr
            // This inserts curr into the correct sorted position
            prev.next = curr;

            // --- Step 6: Move to the next node in the ORIGINAL list ---
            curr = nextNode;                // We saved this in Step 3
        }

        // --- Step 7: Return the sorted list ---
        // dummy is a fake node — real sorted list starts at dummy.next
        return dummy.next;
    }

    // 2095 delete the middle node of the linkedlist
    public ListNode deleteMiddle(ListNode head) {

        // Edge case: only one node — middle is head itself, so return null
        if (head.next == null) return null;

        // slow will land one BEFORE the middle node
        // No dummy needed — we handle n=1 above
        ListNode slow = head;

        // fast starts 2 steps ahead of slow (head.next.next)
        // This pre-advances fast so slow stops one node earlier
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow.next is the middle node — skip it
        slow.next = slow.next.next;

        return head;
    }

    // 2095 - maximum twin sum of the linked list
    public int pairSum(ListNode head) {

        // Step 1: Find the middle using slow and fast pointers
        // slow moves 1 step, fast moves 2 steps
        // When fast reaches end, slow is at the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // 1 step
            fast = fast.next.next;    // 2 steps
        }
        // slow is now at the START of the second half

        // Step 2: Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow;         // start reversing from slow

        while (curr != null) {
            ListNode nextNode = curr.next;  // save next
            curr.next = prev;              // reverse the link
            prev = curr;                   // move prev forward
            curr = nextNode;              // move curr forward
        }
        // prev is now the HEAD of the reversed second half

        // Step 3: Walk first half (head) and reversed second half (prev) together
        // Compute twin sums and track the maximum
        int maxSum = 0;
        ListNode left = head;   // starts from beginning
        ListNode right = prev;  // starts from reversed end

        while (right != null) {
            int twinSum = left.val + right.val;  // twin pair sum
            if (twinSum > maxSum) {
                maxSum = twinSum;                // update max
            }
            left = left.next;
            right = right.next;
        }

        return maxSum;
    }




}

//













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
