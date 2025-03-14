import static org.junit.Assert.*;
import org.junit.Test;

public class TestNewStack {

    @Test
    public void testEmptyStack() {
        NewStack<Integer> stack = new NewStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        try {
            stack.pop();
            fail("Expected exception on pop from empty stack");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testPushPop() {
        NewStack<Integer> stack = new NewStack<>();
        stack.push(5);
        stack.push(3);
        stack.push(8);
        assertEquals(3, stack.size());
        assertEquals((Integer)8, stack.top());
        assertEquals((Integer)8, stack.pop());
        assertEquals((Integer)3, stack.top());
        assertEquals((Integer)3, stack.pop());
        assertEquals((Integer)5, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testMinElement() {
        NewStack<Integer> stack = new NewStack<>();
        stack.push(5);
        assertEquals((Integer)5, stack.minElement());
        stack.push(3);
        assertEquals((Integer)3, stack.minElement());
        stack.push(4);
        assertEquals((Integer)3, stack.minElement());
        stack.push(2);
        assertEquals((Integer)2, stack.minElement());
        stack.pop();
        assertEquals((Integer)3, stack.minElement());
    }

    @Test
    public void testToString() {
        NewStack<String> stack = new NewStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        assertEquals("(a, b, c)", stack.toString());
    }
}
