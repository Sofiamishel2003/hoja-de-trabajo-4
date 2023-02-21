public class St_Factory {
    public static <T> IStack<T> make_stack(int e) {
        switch (e) {
            case 1: //Vector
                return new Stack_vector<T>();
            case 2: //Arraylist
                return new Stack_ArrayList<T>();
            case 3: //Lista Simple
                return new Stack_lista<T>();
            case 4: //Lista doblemente encadenada
                return new Stack_doble<T>();
            default:
            throw new IllegalArgumentException("Dato invalido");
            }
        }
    }
