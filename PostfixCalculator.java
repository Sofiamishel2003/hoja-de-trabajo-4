//
//
//  @ Project : hoja de trabajo 4
//  @ File Name : PostfixCalculator.java
//  @ Date : 31/01/2023
//  @ Author : Sofía Velásquez, Joaquín Campos, Julio García Salas
// 
//
import java.util.ArrayList;
import java.util.Arrays;
public class PostfixCalculator implements IPostfixCalculator {

    private static PostfixCalculator instance;
    private IStack stack;
    /** 
     * @param operandos Se ingresa un tipo de objeto Istack con los operandos para poder comprobar que el count sea 1
     * @return boolean
     */
    PostfixCalculator(IStack stack) {
        this.stack = stack;
    }

	public boolean isOneItem (IStack operandos)
    {
        return operandos.count() == 1;
    }
    public static PostfixCalculator getInstance(IStack stack) {
        if (instance == null) {
            instance = new PostfixCalculator(stack);
        }
        System.out.println("La instancia es:"+instance);
        return instance;
    }
    public boolean instance()
    {
        if (instance==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /** 
     * @param a se ingresan dos dígitos para poder sumar y retorna la suma de los dos dígitos
     * @param b 
     * @return int
     */
    public int suma(int a, int b)
    {
        return a+b;
    }
    
    /** 
     * @param a Se ingresan dos dígitos para que se restén, y retorna el numero restado de los dos dígitos
     * @param b
     * @return int
     */
    public int resta(int a, int b)
    {
        return a-b;
    }
    
    
    /** 
     * @param a se ingresan dos dígitos para que se puedan multiplicar y retorna el número de los digitos multiplicados
     * @param b
     * @return int
     */
    public int multiplicacion(int a, int b)
    {
        return a*b;
    }
    
    /** 
     * @param a se ingresan dos digitos para que se puedan dividir retorna el número de los dígitos divididos
     * @param b
     * @return int
     */
    public int division(int a, int b)
    {
        return a/b;
    }
    
    /** 
     * @param item ingresa una string que será el operando para poder ver cual de todos los operandos es
     * @return boolean
     */
    public boolean isOperator(String item)
    {
        return item.equals("+") || item.equals("-") || item.equals("/") || item.equals("*");
    }
    
  
  /** 
   * @param _expresion Se ingresa una expresion para poder retornar una ArrayList 
   * @return ArrayList<String>
   */
  //  java.util.ArrayList<String> getItems(String _expresion);
    public ArrayList<String> getItems(String _expresion) 
    {
        String[] separado = _expresion.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(separado));
        return list;
    }
}
