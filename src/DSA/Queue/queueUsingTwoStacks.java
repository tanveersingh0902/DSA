package DSA.Queue;
import java.util.Stack;


// ============================================================
// APPROACH 2: OPTIMAL — TWO STACK LAZY TRANSFER
// This is the BEST solution — used in real interviews
//
// TWO STACKS:
//   inbox  (stack1) → always push new elements here
//   outbox (stack2) → always pop/peek from here
//
// KEY INSIGHT (Lazy Transfer):
//   Transfer inbox → outbox ONLY when outbox is EMPTY
//   Don't transfer on every push — wait until needed!
//
// This gives AMORTIZED O(1) for all operations:
//   Each element is moved AT MOST ONCE (inbox → outbox)
//   So total cost across all operations = O(n) total
//   = O(1) amortized per operation
//
// push():  O(1)         ← just push to inbox
// pop():   O(1) amortized ← transfer only when needed
// peek():  O(1) amortized
// empty(): O(1)
// ============================================================

public class queueUsingTwoStacks {

    Stack<Integer> inbox  = new Stack<>();  // For enqueue
    Stack<Integer> outbox = new Stack<>();  // For dequeue

    // ========================
    // push(): Always to inbox
    // Time: O(1) always
    // ========================
    public void push(int x) {
        inbox.push(x);
        // No rearranging needed!
    }

    // pop(): O(1) amortized
    public int pop() {
        // If outbox empty, pour inbox into outbox
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {       // ← transfer inlined here
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

    // peek(): O(1) amortized
    public int peek() {
        // Same logic as pop() but don't remove
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {       // ← transfer inlined here
                outbox.push(inbox.pop());
            }
        }
        return outbox.peek();
    }

    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

   }

