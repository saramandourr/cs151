public class ExpandableArray<E> {
    private Object[] data;
    private int size;
    
    public ExpandableArray(int initialCapacity) {
        data = new Object[initialCapacity];
        size = 0;
    }
    
    public ExpandableArray() {
        this(10);
    }
    
    public void add(E element) {
        if (size == data.length) {
            resize();
        }
        data[size++] = element;
    }
    
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        return (E) data[index];
    }
    
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        data[index] = element;
    }
    
    public int size() {
        return size;
    }
    
    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += data[i].toString();
            if (i < size - 1) result += ", ";
        }
        return result;
    }
}

