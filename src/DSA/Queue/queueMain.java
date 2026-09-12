package DSA.Queue;

public class queueMain {
    public static void main(String[] args) throws Exception {
//        customQueue queue = new customQueue(5);
//        queue.insert(3);
//        queue.insert(6);
//        queue.insert(5);
//        queue.insert(19);
//        queue.insert(1);
//        queue.display();
//        System.out.println( queue.remove());
//        queue.display();


        circularQueue queue = new circularQueue(5);
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);
        queue.display();
        System.out.println( queue.remove());
        queue.insert(133);
        queue.display();
    }
}
