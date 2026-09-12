package DSA.Stacks;

// ============================================================
// BASE STACK CLASS (Fixed Size)
// Uses an array internally
// ptr = pointer to TOP element (index-based)
//
// KEY DESIGN DECISIONS:
//   - data[] is 'protected' → subclasses (dynamicStack) can access it
//   - DEFAULT_SIZE = 10 if no size given
//   - ptr = -1 means EMPTY stack
// ============================================================

public class customStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public customStack(){
        this(DEFAULT_SIZE);
    }

    public customStack(int size){
        this.data = new int[size];
    }


    // ========================
    // push(): Add element at top
    // Returns true if pushed, false if full
    // Time: O(1)
    // ========================

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    // ========================
    // pop(): Remove and return top element
    // Throws stackException if empty
    // Time: O(1)
    // ========================

    public int pop() throws stackException {
        if(isEmpty()){
            throw new stackException("Cannot pop from an empty stack!!");
        }
        return data[ptr--];

        // ptr-- is POST-decrement:
        //   1. First returns data[ptr]  (current top value)
        //   2. Then decrements ptr      (moves top down)
        // Equivalent to: int val = data[ptr]; ptr--; return val;
    }

    // ========================
    // peek(): View top without removing
    // Throws stackException if empty
    // Time: O(1)
    // ========================

    public int peek() throws stackException {
        if(isEmpty()){
            throw new stackException("Cannot peek from an Empty stack");
        }
        return data[ptr];
    }


    // ========================
    // isFull(): Check if no space left
    // ptr == data.length - 1 means ptr is at last valid index
    // ========================

    protected boolean isFull(){
        return ptr == data.length - 1;
        // Example: data.length=10 → last index=9
        //          if ptr==9, array is full
    }


    // ========================
    // isEmpty(): Check if stack has no elements
    // ========================
    private boolean isEmpty() {
        return ptr == -1;  // -1 was our "empty" signal
    }


}
