package DSA.Stacks;


// ============================================================
// DYNAMIC STACK — extends customStack
// Overrides push() to auto-resize when full
//
// STRATEGY:
//   When array is full → create new array of DOUBLE the size
//   Copy all elements → assign to data
//   Then push normally
//
// This is the SAME strategy used by Java's ArrayList internally!
// Time complexity: O(1) amortized for push
//                  (occasionally O(n) when resize happens)
// ============================================================



public class dynamicStack extends customStack{

    public dynamicStack(){
        super();    // it will call customStack()
    }

    public dynamicStack(int size){
        super(size);      // it will call customStack(int size)
    }

    // ========================
    // @Override push()
    // Adds auto-resize behavior on top of parent's push
    // ========================

    @Override
    public boolean push(int item) {

        if (this.isFull()) {
            // Step 1: Create new array with DOUBLE capacity
            int[] temp = new int[data.length * 2];
            // data.length=3 → temp has size 6

            // Step 2: Copy ALL existing elements to temp
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
                // Copies element by element: index 0,1,2...
            }

            // Step 3: Make 'data' point to the new bigger array
            data = temp;
            // Old small array is now garbage collected by JVM
        }

        // Step 4: Now array is guaranteed NOT full
        // Call parent's push() which does: ptr++; data[ptr]=item;
        return super.push(item);
    }

}
