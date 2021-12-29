package Math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Создаём набор-suite тестов
@RunWith(Suite.class)//запускать данный наш класс MathCalcTestSuite с этими классами
@Suite.SuiteClasses({MathCalcTestAdd.class, MathCalcTestBase.class})

public class MathCalcTestSuite {//запуск данного класса запустит весть набор тестов

}