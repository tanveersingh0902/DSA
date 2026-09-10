package DSA.linked_list;

public class DLL {

   private Node head;


    public void insertFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.previous = null;
        if(head != null){
            head.previous = newNode;
        }
        head = newNode;
    }

    public void insertEnd(int val){
        Node newNode = new Node(val);
        Node last = head;
        newNode.next = null;

        if(head == null){
            newNode.previous = null;
            head =newNode;
            return;
        }
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
        newNode.previous = last;
    }

    public void insert(int after , int val ){
        Node p = find(after);

        if(p == null){
            System.out.println("Does not exist");
            return;
        }
        Node newNode = new Node(val);
        newNode.next = p.next;
        p.next = newNode;
        newNode.previous = p;

        if(newNode.next != null){
            newNode.next.previous = newNode;
        }
    }
    public void deleteFirst(){
        if(head == null){
            return ;
        }
        int temp = head.val;
        head = head.next;
        head.previous = null;
        return ;
    }

    public void deleteLast() {
        // If list is empty
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // If list has only one node
        if (head.next == null) {
            head = null;
            return;
        }

        // Traverse to the last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Remove the last node
        temp.previous.next = null;
    }

    public Node find(int val){
        Node node = head;
        while (node != null){
            if(node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public Node get(int index){
        Node node = head;
        for(int i = 0; i< index; i++){
            node = node.next;
        }
        return node;
    }


    public void display(){
        Node node = head;
        Node last = null;
        while(node != null){
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in rev");
        while (last != null){
            System.out.print(last.val + " -> ");
            last = last.previous;
        }
        System.out.println("START");
    }


    private class Node{
        int val;
       Node next;
       Node previous;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next, Node previous){
            this.val = val;
            this.next = next;
            this.previous = previous;
        }
    }
}
