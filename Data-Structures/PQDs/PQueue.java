package PQDs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQueue {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // max heap
        pq.offer(11);
        pq.offer(10);
        pq.offer(5);
        pq.offer(9);
        pq.offer(8);

        System.out.println(pq);
    }
}
