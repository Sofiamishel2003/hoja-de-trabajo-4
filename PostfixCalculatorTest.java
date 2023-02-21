import junit.framework.TestCase;
public class PostfixCalculatorTest extends TestCase {
    PostfixCalculator calc;
    Stack_ArrayList<Integer> stack = new Stack_ArrayList();

    private void pruebita()
    {
        calc = new PostfixCalculator(stack);
    }
    public void testdivision()
    {
        pruebita();
        int a=4;
        int b=2;
        assertEquals(2, calc.division(a,b));
    }
    public void testinstance()
    {
        pruebita();
        assertEquals(true, calc.instance());
    }
    public void testsuma()
    {
        pruebita();
        int a=4;
        int b=2;
        assertEquals(6, calc.suma(a,b));
    }
    public void testresta()
    {
        pruebita();
        int a=4;
        int b=2;
        assertEquals(2, calc.resta(a,b));

    }
    public void testmultiplicacion()
    {
        pruebita();
        int a=4;
        int b=2;
        assertEquals(8, calc.multiplicacion(a,b));

    }
    
}

