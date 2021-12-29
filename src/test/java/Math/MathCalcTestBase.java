package Math;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;


import static org.junit.Assert.assertEquals;

public class MathCalcTestBase {
    int a = 8;
    int b = 2 ;//установили начальные данные для хранения параметров

    @Rule //общие правила для всех методов данного класса
    public TestRule timeout = new Timeout(6);//ограничение по времени

    @Before
    public void setUp(){//выполняется до каждого теста
    }
    @After
    public void tearDown(){//выполняется после каждого теста
    }


    @Test // "addition"
    public void testAdd() throws InterruptedException {
        int expRes = 10; //установили начальные данные для проверки
        int actRes = MathCalc.addition(a,b);//запуск и самотестирование метода адд
        assertEquals("Not good!", expRes,actRes);//проверить правильность
        // мат.расчета: ER must equal AR, otherwise throw the message "Not good!"
    }
    @Test // "multiplication"
    public void testMult() {
        int expRes = 16;
        int actRes = MathCalc.multiplication(a,b);
        assertEquals("Not good!", expRes,actRes);//проверить правильность мат.расчета
    }
    @Test // "subtraction"
    public void testSub() {
        int expRes = 6;
        int actRes = MathCalc.subtraction(a,b);
        assertEquals("Not good!", expRes,actRes);//проверить правильность мат.расчета
    }
    @Test (expected = ArithmeticException.class) // в тесте ожидаем арифметическое исключение
    // из-за деления на ноль, и тест с ним должен PASSED
    public void testDiv() {
        int b = 0; //преднамеренно проверим деление на ноль.
        int expRes = 4;
        int actRes = MathCalc.division(a,b);
        assertEquals("Not good!", expRes,actRes); //проверить правильность мат.расчета
    }

}
