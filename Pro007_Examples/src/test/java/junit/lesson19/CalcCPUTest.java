package junit.lesson19;

/* Всегда обращаем внимание на импорты
* компоненты с импортом:
* junit.framework.* не рекомендованы к
* использованию*/

import junit.lesson19.calculator.CalcCPU;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.InputMismatchException;

public class CalcCPUTest extends Assert {
    /* @Test - позваляет отметить метод как JUnitTest*/
    @Test
    public void testCalcAdditionPositive() {
        /* assertEquals - тест считается пройденым в том случае если ожидаемый результат
        *                 будет равен фактическому */
        assertEquals("Сложение", 4, (int) CalcCPU.calc(2, "+", 2));
        assertEquals("Сложение", 5, (int) CalcCPU.calc(2, "+", 3));
        assertEquals("Сложение", 8, (int) CalcCPU.calc(1, "+", 7));
        assertEquals("Сложение", 9, (int) CalcCPU.calc(3, "+", 6));
        assertEquals("Сложение", 2, (int) CalcCPU.calc(1, "+", 1));
    }

    @Test
    public void testCalcAdditionNegative() {
        /* assertNotEquals - тест считается успешным, если ожидаемый результат не равен фактическому*/
        assertNotEquals("Сложение", 3, (int) CalcCPU.calc(2, "+", 3));
        assertNotEquals("Сложение", 8, (int) CalcCPU.calc(4, "+", 3));
        assertNotEquals("Сложение", 1, (int) CalcCPU.calc(3, "+", 5));
        assertNotEquals("Сложение", 2, (int) CalcCPU.calc(4, "+", 6));
        assertNotEquals("Сложение", 3, (int) CalcCPU.calc(1, "+", 8));
    }

    @Test
    public void testCalcSubtractionPositive() {
        assertEquals("Вычитание", 4, (int) CalcCPU.calc(9, "-", 5));
        assertEquals("Вычитание", 2, (int) CalcCPU.calc(5, "-", 3));
        assertEquals("Вычитание", 3, (int) CalcCPU.calc(7, "-", 4));
        assertEquals("Вычитание", 1, (int) CalcCPU.calc(9, "-", 8));
        assertEquals("Вычитание", 0, (int) CalcCPU.calc(5, "-", 5));
    }

    @Test
    public void testCalcSubtractionNegative() {
        assertNotEquals("Вычитание", 8, (int) CalcCPU.calc(4, "-", 3));
        assertNotEquals("Вычитание", 2, (int) CalcCPU.calc(6, "-", 3));
        assertNotEquals("Вычитание", 3, (int) CalcCPU.calc(5, "-", 4));
        assertNotEquals("Вычитание", 1, (int) CalcCPU.calc(4, "-", 4));
        assertNotEquals("Вычитание", 4, (int) CalcCPU.calc(1, "-", 0));
    }

    @Test
    public void testCalcMultiplicationPositive() {
        assertEquals("Умножение", 4, (int) CalcCPU.calc(2, "*", 2));
        assertEquals("Умножение", 6, (int) CalcCPU.calc(2, "*", 3));
        assertEquals("Умножение", 9, (int) CalcCPU.calc(3, "*", 3));
        assertEquals("Умножение", 8, (int) CalcCPU.calc(2, "*", 4));
        assertEquals("Умножение", 7, (int) CalcCPU.calc(7, "*", 1));
    }

    @Test
    public void testCalcMultiplicationNegative() {
        assertNotEquals("Умножение", 2, (int) CalcCPU.calc(4, "*", 3));
        assertNotEquals("Умножение", 7, (int) CalcCPU.calc(6, "*", 3));
        assertNotEquals("Умножение", 9, (int) CalcCPU.calc(5, "*", 4));
        assertNotEquals("Умножение", 2, (int) CalcCPU.calc(4, "*", 4));
        assertNotEquals("Умножение", 5, (int) CalcCPU.calc(1, "*", 0));
    }

    @Test
    public void testCalcDivisionPositive() {
        assertEquals("Деление", 3, (int) CalcCPU.calc(9, "/", 3));
        assertEquals("Деление", 4, (int) CalcCPU.calc(8, "/", 2));
        assertEquals("Деление", 1, (int) CalcCPU.calc(3, "/", 3));
        assertEquals("Деление", 2, (int) CalcCPU.calc(4, "/", 2));
        assertEquals("Деление", 1, (int) CalcCPU.calc(7, "/", 7));
    }

    @Test
    public void testCalcDivisionNegative() {
        assertNotEquals("Деление", 2, (int) CalcCPU.calc(4, "*", 3));
        assertNotEquals("Деление", 7, (int) CalcCPU.calc(6, "*", 3));
        assertNotEquals("Деление", 9, (int) CalcCPU.calc(5, "*", 4));
        assertNotEquals("Деление", 2, (int) CalcCPU.calc(4, "*", 4));
        assertNotEquals("Деление", 5, (int) CalcCPU.calc(1, "*", 6));
    }

    /* expected - позволяет указать исключение которое мы ожитаем при выполнении теста

       Тест считается успешным, если будет сгенерировано ожидаемое исключение */
    @Test(expected = ArithmeticException.class)
    public void testCalcDivisionByZeroNegative() {
        CalcCPU.calc(4, "/", 0);
    }

    @Test
    public void testParseExpressionPositive() {
        CalcCPU.parseExpression("2 + 3");
        assertEquals(2, (int) CalcCPU.first);
        assertEquals("+", CalcCPU.operation);
        assertEquals(3, (int) CalcCPU.second);
        assertEquals("2 + 3", CalcCPU.exp);

        CalcCPU.parseExpression("4 - 1");
        assertEquals(4, (int) CalcCPU.first);
        assertEquals("-", CalcCPU.operation);
        assertEquals(1, (int) CalcCPU.second);
        assertEquals("4 - 1", CalcCPU.exp);

        CalcCPU.parseExpression("5 * 3");
        assertEquals(5, (int) CalcCPU.first);
        assertEquals("*", CalcCPU.operation);
        assertEquals(3, (int) CalcCPU.second);
        assertEquals("5 * 3", CalcCPU.exp);

        CalcCPU.parseExpression("7 / 3");
        assertEquals(7, (int) CalcCPU.first);
        assertEquals("/", CalcCPU.operation);
        assertEquals(3, (int) CalcCPU.second);
        assertEquals("7 / 3", CalcCPU.exp);
    }

    @Test(expected = InputMismatchException.class)
    public void testParseExpressionNegative() {
        CalcCPU.parseExpression("2-5");
    }

    @Test
    @Ignore
    public void testParseExpressionInputMismatchException() {
        try {
            CalcCPU.parseExpression("2-5");
        } catch (InputMismatchException e) {
            fail("Сгенерировано не обработаное исключение");
        }
    }
}
