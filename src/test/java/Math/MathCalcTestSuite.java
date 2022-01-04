package Math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//Один из способов запуска тестов/тестнаборов
//Создаём набор-suite тестов и запускаем их этим способом с аннотациями
@RunWith(Suite.class)//запускать данный наш класс MathCalcTestSuite с этими классами из Math Package
@Suite.SuiteClasses({MathCalcTestAdd.class, MathCalcTestBase.class})

public class MathCalcTestSuite {//запуск данного класса запустит весть набор тестов

}