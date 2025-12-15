package StackDs;
import java.util.*;

public class StackDs {
    public static void main(String[] args) {
        System.out.println("Hello Stacks");
        Stack<String> movieDisks = new Stack<>();

        movieDisks.push("Race Gurram");
        movieDisks.push("Bahubali");
        movieDisks.push("Hanuman");
        movieDisks.push("Darling");
        movieDisks.push("Mirchi");


        System.out.println(movieDisks.pop());
        System.out.println(movieDisks.peek());
        System.out.println(movieDisks.search("Darling"));
        System.out.println(movieDisks.empty());
    }
}