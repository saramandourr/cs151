import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque {

    @Test
    public void testEmptyDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
        assertEquals("()", deque.toString());
    }

    @Test
    public void testAddRemoveFirst() {
        ArrayDeque<String> deque = new ArrayDeque<>(10);
        deque.addFirst("a");
        deque.addFirst("b");
        assertEquals(2, deque.size());
        assertEquals("(b, a)", deque.toString());
        assertEquals("b", deque.removeFirst());
        assertEquals("a", deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testAddRemoveLast() {
        ArrayDeque<String> deque = new ArrayDeque<>(10);
        deque.addLast("a");
        deque.addLast("b");
        assertEquals(2, deque.size());
        assertEquals("(a, b)", deque.toString());
        assertEquals("b", deque.removeLast());
        assertEquals("a", deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testAddFirstAddLastMixed() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(10);
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        assertEquals("(0, 1, 2)", deque.toString());
        assertEquals((Integer)0, deque.removeFirst());
        assertEquals((Integer)2, deque.removeLast());
        assertEquals((Integer)1, deque.removeFirst());
    }

    @Test
    public void testFirstLastMethods() {
        ArrayDeque<String> deque = new ArrayDeque<>(10);
        deque.addLast("first");
        deque.addLast("middle");
        deque.addLast("last");
        assertEquals("first", deque.first());
        assertEquals("last", deque.last());
    }

    @Test
    public void testFullDequeException() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(3);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        try {
            deque.addLast(4);
            fail("Expected RuntimeException for full deque");
        } catch(RuntimeException e) {
            // expected
        }
    }
}
