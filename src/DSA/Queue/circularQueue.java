package DSA.Queue;

// ============================================================
// CIRCULAR QUEUE (Ring Buffer)
// Fixes customQueue's O(n) remove by using TWO pointers:
//
//   front → index of element to remove next
//   end   → index where next element will be inserted
//   size  → count of current elements
//
// KEY INSIGHT: Instead of shifting elements,
//   we move the POINTERS using modulo arithmetic:
//   newIndex = (oldIndex + 1) % data.length
//   This "wraps around" — after last index comes index 0
//
// All operations: O(1)!
// ============================================================

public class circularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int end   = 0;   // Next insertion slot
    protected int front = 0;   // Next removal slot
    private   int size  = 0;   // Current element count

    public circularQueue(){
        this(DEFAULT_SIZE);
    }

    public circularQueue(int size){
        this.data = new int[size];
    }

    // ========================
    // isFull(): size == array length
    // Uses 'size' counter — cleaner than end==front ambiguity
    // ========================
    public boolean isFull(){
        return size == data.length;
    }

    // ========================
    // isEmpty(): no elements
    // ========================
    private boolean isEmpty(){
        return size == 0;
    }

    // ========================
    // isEmpty(): no elements
    // ========================
    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;          // Place item, increment end
        end = end % data.length;     // Wrap around if end reached last index
        // Shorthand: end = (end + 1) % data.length (same thing split in 2 lines)
        size++;
        return true;
    }

    // ========================
    // remove(): Remove from 'front', then wrap front around
    // Time: O(1) ← KEY IMPROVEMENT over customQueue!
    // ========================
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[front++];             // Read front, increment front
        front = front % data.length;             // Wrap front around
        size--;
        return removed;
    }

    // ========================
    // front(): Peek at front element
    // ========================
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[front];
    }

    // ========================
    // display(): Must traverse circularly using do-while
    // Cannot use simple for loop (front may be > end due to wrap)
    // ========================
    public void display(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        int i = front;             // Start from front
        do{
            System.out.print (data[i] + " -> ");
            i++;
            i %= data.length;             // Wrap i around when needed
        }while(i != end);                 // Stop when we reach end
        System.out.println("END");
    }

}
