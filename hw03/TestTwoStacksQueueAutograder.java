import static org.junit.Assert.*;
import org.junit.Test;

public class TestTwoStacksQueueAutograder {

    @Test
    public void testIsEmptyAndSize() {
        TwoStacksQueue<Integer> q = new TwoStacksQueue<>();
        assertTrue(q.isEmpty());
        assertEquals(0, q.size());
    }

    @Test
    public void testEnqueueAndFirst() {
        TwoStacksQueue<String> q = new TwoStacksQueue<>();
        q.enqueue("a");
        q.enqueue("b");
        assertEquals("a", q.first());
        assertEquals("a", q.front());
    }

    @Test
    public void testDequeue() {
        TwoStacksQueue<Integer> q = new TwoStacksQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals((Integer)1, q.dequeue());
        assertEquals((Integer)2, q.first());
    }

    @Test
    public void testToStringFormat() {
        TwoStacksQueue<String> q = new TwoStacksQueue<>();
        q.enqueue("x");
        q.enqueue("y");
        q.enqueue("z");
        assertEquals("(x, y, z)", q.toString());
    }
}
