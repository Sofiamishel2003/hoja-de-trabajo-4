
/**
 * @author sofia.velasquez,dsf
 */
import java.util.Vector;

public class Stack_vector<T> implements IStack<T>
{ 
    private Vector<T> vec;
    
    public Stack_vector() {
        vec = new Vector<T>();
    }

    public int count() {
        return vec.size();
    }

    public boolean isEmpty() {
        return vec.isEmpty();
    }
    public void push(T e) {
        vec.add(0, e);
    }

    public T pull() {
        return vec.remove(0);
    }

    public T peek() {
        return vec.get(0);
    }
}
