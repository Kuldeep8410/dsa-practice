package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQ {
    public static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // Check if stack is empty
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Push element into stack
        public void push(int x) {
            // Always push into q1
            q1.add(x);
        }

        // Pop element from stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            // Leave last element in q1 and push others in q2
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            // Last element in q1 is the top of stack
            int top = q1.remove();

            // Swap names of q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return top;
        }

        // Peek top element without removing
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            int top = q1.peek(); 
            q2.add(q1.remove()); 

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(4);
        s.push(5);
        s.push(2);
        s.push(6);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
