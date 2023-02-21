import junit.framework.TestCase;
public class Infix_to_postfixTest extends TestCase{
    infix_to_postfix conversor;
    private void pruebita()
    {
        conversor = new infix_to_postfix();
    }
    public void testinfixToPostfix()
    {
        pruebita();
        String infix="(1+2)*9";
        String postfix=infix_to_postfix.infixToPostfix(infix);
        assertEquals("1 2 + 9 *",  postfix);
    }
}
