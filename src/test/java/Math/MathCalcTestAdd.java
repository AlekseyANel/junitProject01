package Math;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)//запускать данный класс MathCalcTest с этим
// классом параметризации
public class MathCalcTestAdd {
    int a, b, expRes;//установили начальные данные для хранения параметров

    public MathCalcTestAdd(int a, int b, int expRes) {//в конструкторе
        //создается объект класса MathCalcTest с параметрами
        this.a = a;
        this.b = b;
        this.expRes = expRes;
    }
    @Parameterized.Parameters//класс Параметрс
    public static Collection numbers() {//надо переопределить метод Намберc
        return Arrays.asList(new Object[] [] {{1,2,3},{4,5,9},{6,7,20}});
        //по три параметра a, b и expRes для созданного объекта класса MathCalcTest.
        // Один результат в третьем наборе параметров преднамеренно
        // неправильный: 6+7=13, а не 20.
    }

    @Before
    public void setUp(){//выполняется до каждого теста
    }
    @After
    public void tearDown(){//выполняется после каждого теста
    }


    @Test // "addition"
    public void testAdd() throws InterruptedException {
        //int expRes = 10; //установили начальные данные для проверки
        int actRes = MathCalc.addition(a, b);//запуск и самотестирование метода адд
        assertEquals("Not good!", expRes,actRes);//проверить правильность мат.расчета
    }



}
