package DSA.Queue;


// ============================================================
// DYNAMIC QUEUE — extends circularQueue
// When full, doubles the array size and resets to linear layout
//
// TRICKY PART: When copying from circular array,
//   elements are NOT necessarily at indices 0,1,2...
//   They start at 'front' and may wrap around!
//
//   WRONG copy: temp[i] = data[i]  (copies wrong order!)
//   RIGHT copy: temp[i] = data[(front + i) % data.length]
//               (starts at front, wraps using modulo)
//
// After copy: front=0, end=data.length (old size = count of elements)
// ============================================================

public class dynamicQueue extends circularQueue {
    public dynamicQueue(){
        super();
    }

    public dynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item) {

        if (this.isFull()) {
            // Step 1: Double-sized temp array
            int[] temp = new int[data.length * 2];

            // Step 2: Copy elements in CORRECT circular order
            // Starting from front, going around using modulo
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
                //  front=2, data.length=3:
                //    i=0: data[(2+0)%3] = data[2]  ← first element
                //    i=1: data[(2+1)%3] = data[0]  ← wrapped element
                //    i=2: data[(2+2)%3] = data[1]  ← last element
            }

            // Step 3: Reset pointers — now layout is linear again
            front = 0;
            end = data.length;  // Old length = number of elements copied
            data = temp;        // Point to new bigger array
        }

        // Step 4: Insert normally using parent's logic
        return super.insert(item);
    }
}
