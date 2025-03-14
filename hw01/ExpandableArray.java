//package hw01;

@SuppressWarnings("unchecked")
public class ExpandableArray<E> {
    private Object[] array;
    private int size;
    
    public ExpandableArray(int capacity) {
        array = new Object[capacity];
        size = 0;
    }
    
    public ExpandableArray() {
        this(10);
    }
    
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        if (size == 0) return "";
        //StringBuilder sb = new StringBuilder("[");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) sb.append(", ");
        }
        //sb.append("]");
        return sb.toString();
    }
    
    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    
    public void insert(E item) {
         if (size == array.length) resize();
         System.arraycopy(array, 0, array, 1, size);
         array[0] = item;
         size++;
    }
    
    public void insertAOB(E item) {
         if (size == array.length) resize();
         array[size++] = item;
    }
    
    public void insert(E item, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == array.length) resize();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return (E) array[index];
    }
    
    public void set(E item, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        array[index] = item;
    }
    
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        E removed = (E) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removed;
    }
    
    public E removeAOB() {
        if (size == 0) throw new IndexOutOfBoundsException("Array is empty");
        E removed = (E) array[size - 1];
        array[--size] = null;
        return removed;
    }
}
