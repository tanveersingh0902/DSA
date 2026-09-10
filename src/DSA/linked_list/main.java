package DSA.linked_list;

public class main {
    public static void main(String[] args) {

        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insert(100,3);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
        list.insertRec(88 , 2);
        list.display();

//        DLL list = new DLL();
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.insertEnd(99);
//        list.insert(8,65);
//        list.display();
//        list.deleteFirst();
//        list.display();
//        list.deleteLast();
//        list.display();
//
//        CLL list = new CLL();
//        list.insertLast(23);
//        list.insertLast(3);
//        list.insertLast(19);
//        list.insertLast(75);
//        list.display();
//        list.delete(19);
//        list.display();









    }
}
