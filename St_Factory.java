/**
 * La clase St_Factory es una factoría para la creación de diferentes implementaciones de pilas.
 */
public class St_Factory {
    
    /**
     * Crea una nueva instancia de la implementación de pila especificada por el parámetro e.
     *
     * @param e el entero que indica la implementación de pila a crear:
     *          1 para una pila implementada con Vector
     *          2 para una pila implementada con ArrayList
     *          3 para una pila implementada con Lista Simple
     *          4 para una pila implementada con Lista Doblemente Encadenada
     * @return una nueva instancia de la implementación de pila especificada por el parámetro e.
     * @throws IllegalArgumentException si se proporciona un valor de e no válido.
     */
    public static <T> IStack<T> make_stack(int e) throws IllegalArgumentException {
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
