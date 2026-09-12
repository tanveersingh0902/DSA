package DSA.Queue;
import java.util.Stack;

// ============================================================
// IMPLEMENT QUEUE USING TWO STACKS
//
// Idea:
//   Stack1 (inbox)  — always push new elements here
//   Stack2 (outbox) — for dequeue, if empty, transfer all from stack1
//
// This gives amortized O(1) for all operations.
// ============================================================


public class queueUsingTwoStacks {

    Stack<Integer> inbox  = new Stack<>();  // For enqueue
    Stack<Integer> outbox = new Stack<>();  // For dequeue

    // enqueue: always push to inbox
    public void enqueue(int data) {
        inbox.push(data);
    }

    // dequeue: transfer inbox→outbox if outbox is empty
    public int dequeue() {
        if (outbox.isEmpty()) {
            // Pour all from inbox into outbox (reverses order → FIFO!)
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        if (outbox.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return outbox.pop();
    }

    public int peek() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.isEmpty() ? -1 : outbox.peek();
    }

    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    public static void main(String[] args) {

        queueUsingTwoStacks q = new queueUsingTwoStacks();

        // -----------------------------------------------
        // DRY RUN:
        //
        // enqueue(10): inbox=[10], outbox=[]
        // enqueue(20): inbox=[10,20], outbox=[]
        // enqueue(30): inbox=[10,20,30], outbox=[]
        //
        // dequeue():
        //   outbox is empty → transfer inbox to outbox:
        //   pop 30 from inbox → push to outbox → outbox=[30]
        //   pop 20 from inbox → push to outbox → outbox=[30,20]
        //   pop 10 from inbox → push to outbox → outbox=[30,20,10]
        //   inbox=[]
        //   outbox.pop() → 10 ✅ (FIFO preserved!)
        //
        // dequeue(): outbox=[30,20] → pop → 20 ✅
        //
        // enqueue(40): inbox=[40], outbox=[30]
        //
        // dequeue(): outbox not empty → pop → 30 ✅
        // dequeue(): outbox empty → transfer inbox=[40]
        //            outbox=[40] → pop → 40 ✅
        // -----------------------------------------------

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue());  // 10 (first in, first out)
        System.out.println(q.dequeue());  // 20

        q.enqueue(40);

        System.out.println(q.dequeue());  // 30
        System.out.println(q.dequeue());  // 40
    }
}
