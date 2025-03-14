/**
 * A queue implemented using two stacks.
 *
 * @param <E> the type of elements held in this queue
 */

public class TwoStacksQueue<E> implements Queue<E> {

    private ArrayStack<E> inStack;
    private ArrayStack<E> outStack;

    /**
     * Constructs a TwoStacksQueue with a default capacity of 100.
     */

    public TwoStacksQueue() {
        this(100);
    }

    /**
     * Constructs a TwoStacksQueue with the specified capacity.
     *
     * @param capacity the capacity for each stack
     */

    public TwoStacksQueue(int capacity) {
        inStack = new ArrayStack<E>(capacity);
        outStack = new ArrayStack<E>(capacity);
    }

    /**
     * Enqueues the specified element.
     *
     * @param element the element to enqueue
     */

    public void enqueue(E element) {
        inStack.push(element);
    }

    /**
     * Dequeues and returns the front element.
     *
     * @return the front element
     */

    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }    
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /**
     * Returns the front element without removing it.
     *
     * @return the front element
     */

    public E front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.top();
    }

    /**
     * Returns the first element (alias for front).
     *
     * @return the first element
     */

    public E first() {
        return front();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if empty, false otherwise
     */

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * Returns the total number of elements in the queue.
     *
     * @return the size of the queue
     */

    public int size() {
        return inStack.size() + outStack.size();
    }

    /**
     * Returns a string representation of the queue in format (e1, e2, .., eN).
     *
     * @return a string representation of the queue
     */

    public String toString() {
        String outStr = stackToString(outStack, true);
        String inStr = stackToString(inStack, false);
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        boolean first = true;
        if (!outStr.isEmpty()) {
            sb.append(outStr);
            first = false;
        }
        if (!inStr.isEmpty()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(inStr);
        }
        sb.append(")");
        return sb.toString();
    }

    private String stackToString(ArrayStack<E> stack, boolean reverse) {
        int n = stack.size();
        Object[] temp = new Object[n];
        for (int i = 0; i < n; i++) {
            temp[i] = stack.pop();
        }
        for (int i = n - 1; i >= 0; i--) {
            stack.push((E) temp[i]);
        }
        StringBuilder sb = new StringBuilder();
        if (reverse) {
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(temp[i].toString());
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (i < n - 1) {
                    sb.append(", ");
                }
                sb.append(temp[i].toString());
            }
        }
        return sb.toString();
    }
}
