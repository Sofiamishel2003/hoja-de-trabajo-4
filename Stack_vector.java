
/**
 * @author sofia.velasquez,dsf
 */
import java.util.ArrayList;
import java.util.List;

public class stack_<T> implements IStack<T>
{ 
    private Vector<T> vec;
    
    public Stack() {
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
