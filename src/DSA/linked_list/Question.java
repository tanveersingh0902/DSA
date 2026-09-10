package DSA.linked_list;

public class Question {
    private Question.Node head;
    private Question.Node tail;
    private int size;

    public Question(){
        this.size = 0;
    }


    // 83 Remove Duplicate
      public void duplicate(){
          Node node = head;
          while (node.next != null && node.next != null){
                if(node.value == node.next.value){
                      node.next = node.next.next;
                }
                else{
                      node = node.next;
                }
          }
      }
      // 21 merge two sorted list on leetcode















































    private class Node{
        private int value;
        private Question.Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value , Question.Node next){
            this.value = value;
            this.next = next;
        }

    }






}




























