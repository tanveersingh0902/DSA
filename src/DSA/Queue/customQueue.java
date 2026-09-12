package DSA.Queue;

// ============================================================
// BASE QUEUE CLASS (Simple Array-based Queue)
//
// KEY FIELDS:
//   data[]  → stores elements (private)
//   end     → index where NEXT element will be inserted
//             (starts at 0, not -1 like stack's ptr)
//
// PROBLEM WITH THIS DESIGN:
//   remove() shifts ALL elements left → O(n) time
//   This is the naive approach — circularQueue fixes it
// ==========================================================

public class customQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;


    int end = 0;  // Points to NEXT empty slot
    // end=0 means queue is empty
    // end=3 means

    public customQueue(){
        this(DEFAULT_SIZE);
    }

    public customQueue(int size){
        this.data = new int[size];
    }


    // ========================
    // isFull(): Array completely filled?
    // end == data.length means all slots used
    // ========================

    public boolean isFull(){
        return end == data.length;
    } // Example: data.length=3, end=3 → indices 0,1,2 all filled

    // ========================
    // isEmpty(): No elements present?
    // ========================

    private boolean isEmpty(){
        return end == 0;
    }  // end=0 means no elements inserted yet (or all removed)


    // ========================
    // insert(): Add element at REAR (end)
    // Time: O(1)
    // ========================
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }

    // ========================
    // remove(): Remove from FRONT (index 0)
    // Time: O(n) ← THIS IS THE BOTTLENECK!
    // ========================
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[0];      // Always remove from front (index 0)

        // shift the elements to left
        for(int i = 1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }


    // ========================
    // front(): Peek at front element
    // Time: O(1)
    // ========================
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];     // Front is always at index 0
    }

    // ========================
    // display(): Print all elements
    // Iterates from index 0 to end (exclusive)
    // ========================
    public void display(){
        for(int i = 0; i<end; i++){
            System.out.print(data[i] + " <- ");
        }
        System.out.println("End");
    }
}
