package Lists;

import java.util.LinkedList;

public class LL {
    public static void main(String[] args) {
        // linear data structure
        // can implement as stack, queue, deque
        // insert and delete are easy compared to Arraylist
        // search operation takes time O(n)
        // non consecutive memory location

        // uses
        // implement stack/queue
        // music playlist
        // GPS Navigation

        LinkedList<Integer> li = new LinkedList<>();
//        li.push(1);
//        li.push(5);
//        li.push(3);
//        li.push(4);
//        System.out.println(li.peek());

        li.add(11);
        li.add(9);
        li.addFirst(5);
        li.addLast(3);
        li.add(7);
        System.out.println(li.peekLast());
        System.out.println(li.pollLast());
        System.out.println(li);
    }
}
