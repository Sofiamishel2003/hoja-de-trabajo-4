import junit.framework.TestCase;
public class Stack_ArrayListTest extends TestCase {
    Stack_ArrayList<Integer> vec;
    private void pruebita()
    {
        vec = new Stack_ArrayList<>();
    }
    public void testPush()
    {
        pruebita();
        vec.push(1);
        vec.push(2);
        assertEquals(2, vec.count());
    }
    public void testPop()
    {
        pruebita();
        vec.push(1);
        vec.pull();
        assertEquals(0, vec.count());
    }
    public void testisEmpty()
    {
        pruebita();
        assertEquals(true, vec.isEmpty());
    }
    public void testpeek()
    {
        pruebita();
        vec.push(5);
        int a=vec.peek();
        assertEquals(5, a);

    }
    public void testcount()
    {
        pruebita();
        int a=vec.count();
        assertEquals(0, a);

    }
    
}