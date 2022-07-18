import org.junit.Test;

import static org.junit.Assert.*;

public class StringManipulationsTest {
    @Test
    public void testSimpleExpression() {
        String simpleStr = "5+3";
        int res = StringManipulations.findMathExpressionFromString(simpleStr);
        assertEquals(res, 8);
    }
    @Test
    public void testComplicatedExpression() {
        String compStr = "5+3*4";
        int res = StringManipulations.findMathExpressionFromString(compStr);
        assertEquals(res, 17);
    }
    @Test
    public void testExpressionWithParanthesesAtLast() {
        String compStr = "9/3*(4+2)";
        int res = StringManipulations.findMathExpressionFromString(compStr);
        assertEquals(res, 18);
    }
    @Test
    public void testExpressionWithParanthesesInMiddle() {
        String compStr = "(4+2)*9/2";
        int res = StringManipulations.findMathExpressionFromString(compStr);
        assertEquals(res, 27);
    }

    @Test
    public void testExpressionWithNoParantheses() {
        String compStr = "4+2*9/2";
        int res = StringManipulations.findMathExpressionFromString(compStr);
        assertEquals(res, 13);
    }
}
