package DSA.linked_list;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public void  insertFirst(int value){
        Node newNode = new Node(value);
       newNode.next = head;
        head = newNode;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insert(int val ,int index ){
         if(index == 0){
             insertFirst(val);
             return;
         }
         if(index == size){
             insertLast(val);
             return;
         }
         Node temp = head;
         for(int  i = 1; i< index; i++){
             temp = temp.next;
         }
         Node newNode = new Node(val , temp.next);
             temp.next = newNode;
             size++;
    }

    // insert using recursion
    public void insertRec(int val, int index) {
        // Public entry point: kicks off recursion from head,
        // and reassigns head because the head itself might change
        // (e.g., inserting at index 0)
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        // Base case: we've walked 'index' steps, this is the insertion point
        if (index == 0 || node == null) {
            // New node's `next` points to current node (shifts everything right)
            Node temp = new Node(val, node);
            size++;
            return temp; // this becomes the new "next" of the caller (previous node)
        }

        // Recursive case: move one step forward, decrement index
        // Whatever node comes back from the recursive call becomes
        // this node's `next` (this is how we "reconnect" the list)
        node.next = insertRec(val, index - 1, node.next);

        // return the current node unchanged, so the caller
        // (one level up) keeps pointing to it correctly
        return node;
    }


    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size - 1){
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value , Node next){
            this.value = value;
            this.next = next;
        }

    }

}
