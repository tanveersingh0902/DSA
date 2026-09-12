package DSA.Queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

// ============================================================
// JAVA BUILT-IN QUEUE IMPLEMENTATIONS
// ============================================================



public class BuiltInQueue {
    public static void main(String[] args) {

        // --- Option 1: LinkedList as Queue ---
        Queue<Integer> q = new LinkedList<>();

        q.offer(10);   // enqueue (preferred over add, doesn't throw exception)
        q.offer(20);
        q.offer(30);

        System.out.println("Queue: " + q);           // [10, 20, 30]
        System.out.println("Peek: " + q.peek());     // 10 (does NOT remove)
        System.out.println("Poll: " + q.poll());     // 10 (removes front)
        System.out.println("Queue: " + q);           // [20, 30]

        // --- Option 2: ArrayDeque as Stack AND Queue ---
        // ArrayDeque is faster than Stack and LinkedList for both uses

        // As Stack:
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);         // adds to front
        stack.push(2);
        System.out.println("Stack peek: " + stack.peek());  // 2 (LIFO)
        System.out.println("Stack pop: "  + stack.pop());   // 2

        // As Queue:
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);        // adds to rear
        queue.offer(2);
        System.out.println("Queue peek: " + queue.peek());  // 1 (FIFO)
        System.out.println("Queue poll: " + queue.poll());  // 1
    }
}
