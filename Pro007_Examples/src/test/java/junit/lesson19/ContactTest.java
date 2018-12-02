package junit.lesson19;

import junit.lesson19.contscts.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactTest extends Assert {

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;

    /* @Before - аннотация позволяет нам, зараанее определить
                 объекты необходимые для тестирования
                 Метод помеченный данной аннотацией выполняется
                 перед каждым запуском теста*/
    @Before
    public void initContacts() {
        contact1 = new Contact("Ivan", 25, "Vanya@mail.ru");
        contact2 = new Contact("Anna", 25, "Co@mail.ru");
        contact3 = new Contact("Ivan", 25, "Vanya@mail.ru");
    }

    @Test
    public void testContactEquals() {
        /* assertTrue - тест будет пройден если результат работы метода вернет
        * положительное значение */
        assertTrue("Сравнение контактов на равенство",
                contact1.equals(contact3));
    }

    @Test
    public void testContactEqualsNegative() {
        /* assertFalse - тест будет пройден если результат работы метода вернет
         * отрицательное значение */
        assertFalse("Проверка контактов на неравенство",
                contact1.equals(contact2));
    }

    @Test
    public void testContactHashPositive() {
        assertTrue(contact1.hashCode() == contact3.hashCode());
    }

    @Test
    public void testContactHashNegative() {
        assertFalse(contact1.hashCode() == contact2.hashCode());
    }
}
