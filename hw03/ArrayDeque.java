/**
 * A circular array implementation of a double-ended queue.
 *
 * @param <E> the type of elements held in this deque
 */

public class ArrayDeque<E> implements Deque<E> {

    private Object[] data;
    private int front;
    private int size;
    private int capacity;

    /**
     * Constructs an empty ArrayDeque with a default capacity of 100.
     */
    public ArrayDeque() {
        this(100);
    }

    /**
     * Constructs an empty ArrayDeque with the specified capacity.
     *
     * @param capacity the capacity of the deque
     */
    public ArrayDeque(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        front = 0;
        size = 0;
    }

    /**
     * Adds the specified element at the front of the deque.
     *
     * @param element the element to add
     */

    public void addFirst(E element) {
        if (size == capacity) {
            throw new RuntimeException("Deque is full");
        }
        front = (front - 1 + capacity) % capacity;
        data[front] = element;
        size++;
    }

    /**
     * Adds the specified element at the end of the deque.
     *
     * @param element the element to add
     */

    public void addLast(E element) {
        if (size == capacity) {
            throw new RuntimeException("Deque is full");
        }
        int back = (front + size) % capacity;
        data[back] = element;
        size++;
    }

    /**
     * Removes and returns the first element of the deque.
     *
     * @return the first element, or null if the deque is empty
     */

    public E removeFirst() {
        if (size == 0) {
            return null;
        }    
        E element = (E) data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    /**
     * Removes and returns the last element of the deque.
     *
     * @return the last element, or null if the deque is empty
     */

    public E removeLast() {
        if (size == 0) {
            return null;
        }    
        int back = (front + size - 1) % capacity;
        E element = (E) data[back];
        data[back] = null;
        size--;
        return element;
    }

    /**
     * Returns the first element without removing it.
     *
     * @return the first element, or null if the deque is empty
     */

    public E first() {
        if (size == 0) {
            return null;
        }    
        return (E) data[front];
    }

    /**
     * Returns the last element without removing it.
     *
     * @return the last element, or null if the deque is empty
     */

    public E last() {
        if (size == 0) {
            return null;
        }    
        int back = (front + size - 1) % capacity;
        return (E) data[back];
    }

    /**
     * Returns true if the deque is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the deque.
     *
     * @return the size of the deque
     */

    public int size() {
        return size;
    }

    /**
     * Returns a string representation of the deque in format (e1, e2, .., eN).
     *
     * @return a string representation of the deque
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }    
            int index = (front + i) % capacity;
            sb.append(data[index].toString());
        }
        sb.append(")");
        return sb.toString();
    }
}
