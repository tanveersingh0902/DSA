package practice;
import DSA.linked_list.LL;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class practice {

    public class ab {

        private Node head;
        private Node tail;
        private int size;

        public ab() {
            this.size = 0;
        }

        public void insertRec (int val , int index){
            head = insertRec(val , index , head);
        }

        private Node insertRec(int val , int index , Node node){
            if(index == 0 || node == null){
                Node temp = new Node(val , node);
                size++;
                return temp;

            }
            node.next = insertRec(val , index-1 , node.next);
            return node;
        }


















































        private class Node {
            private int value;
            private Node next;

            public Node(int value) {
                this.value = value;
            }

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }

        }

    }
}