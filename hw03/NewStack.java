
/**
 * A generic stack that supports push, pop, top, and an O(1) minElement 
 * operation.
 *
 * @param <E> the type of elements in the stack
 */

public class NewStack<E extends Comparable<E>> implements Stack<E> {

    private Object[] data;
    private Object[] minData;
    private int size;
    private int capacity;

    /**
     * Constructs a NewStack with a default capacity of 100.
     */

    public NewStack() {
        this(100);
    }

    /**
     * Constructs a NewStack with the specified capacity.
     *
     * @param capacity the capacity of the stack
     */

    public NewStack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        minData = new Object[capacity];
        size = 0;
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param element the element to push
     */

    public void push(E element) {
        if (size == capacity) {
            throw new RuntimeException("Stack is full");
        }    
        data[size] = element;
        if (size == 0) {
            minData[size] = element;
        } else {
            E currentMin = (E) minData[size - 1];
            if (element.compareTo(currentMin) < 0) {
                minData[size] = element;
            } else {
                minData[size] = currentMin;
            }
        }
        size++;
    }

    /**
     * Pops and returns the top element of the stack.
     *
     * @return the top element
     */

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }    
        E element = (E) data[size - 1];
        size--;
        return element;
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     */

    public E top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }    
        return (E) data[size - 1];
    }

    /**
     * Returns the minimum element in the stack.
     *
     * @return the minimum element
     */

    public E minElement() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }    
        return (E) minData[size - 1];
    }

    /**
     * Returns true if the stack is empty.
     *
     * @return true if empty, false otherwise
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */

    public int size() {
        return size;
    }

    /**
     * Returns a string representation of the stack in format (e1, e2, .., eN).
     *
     * @return a string representation of the stack
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }    
            sb.append(data[i].toString());
        }
        sb.append(")");
        return sb.toString();
    }
}
