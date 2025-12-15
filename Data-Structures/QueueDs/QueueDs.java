package QueueDs;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDs {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("Oreo");
        queue.offer("Kitkat");
        queue.offer("Dairy Milk");

        System.out.println(queue.contains("Oreo"));
        System.out.println(queue.poll());
    }
}