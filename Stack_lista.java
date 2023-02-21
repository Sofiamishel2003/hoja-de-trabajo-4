/**
 * @author sofia.velasquez,dsf
 */
import java.util.SinglyLinkedList;

public class stack_<T> implements IStack<T>
{ 
    private SinglyLinkedList<T> lista;

    public Stack() {
        lista = new SinglyLinkedList<T>();
    }

    public int count() {
        return lista.size();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }
    public void push(T e) {
        lista.add(0, e);
    }

    public T pull() {
        return lista.remove(0);
    }

    public T peek() {
        return lista.get(0);
    }
}
