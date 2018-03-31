import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ribake on 26/03/2018.
 */
public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);

        }

        public T peek() {
            return stackNewestOnTop.elementAt(0);

        }

        public T dequeue() {
            // return bottom of left stack
            T top = stackNewestOnTop.elementAt(0);

            // empty right stack
            empty(stackOldestOnTop);

            // transfer left stack onto right stack
            while(!stackNewestOnTop.isEmpty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }

            // remove the topmost element (i.e bottom element of left stack) from right stack
            stackOldestOnTop.pop();

            // transfer remaining elements in right stack to left stack
            while(!stackOldestOnTop.isEmpty()){
                stackNewestOnTop.push(stackOldestOnTop.pop());
            }

            return top;
        }

        private void empty(Stack<T> stack){
            while(!stack.isEmpty()){
                stack.pop();
            }
        }

    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

