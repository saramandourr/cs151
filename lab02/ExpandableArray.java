public class ExpandableArray<E> {
    private Object[] array;
    private int size;
    
    public ExpandableArray(int capacity) {
        array = new Object[capacity];
        size = 0;
    }
    
    public ExpandableArray() { this(10); }
    
    public void insert(E item) {
        insert(item, 0);
    }
    
    public void insert(E item, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == array.length) {
            resize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }
    
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return (E) array[index];
    }
    
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        E removed = (E) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
              size--;
        return removed;
    }
    
    public void set(E item, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        array[index] = item;
    }
    
    public int size() { return size; }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
        }
    
    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}

