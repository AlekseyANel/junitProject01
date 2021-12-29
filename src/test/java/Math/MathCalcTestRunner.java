package Math;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
//Другой вариант запуска сьют-тестов - через данный раннер
//Create java-class to execute test cases, в т.ч. в виде набора-suite 2х тестов
public class MathCalcTestRunner {
    public static void main (String[] args) {
        //Специальный движок JUnitCore генерирует result запуска тестов
        Result result = JUnitCore.runClasses(
                MathCalcTestAdd.class,
                MathCalcTestBase.class);
        //Из resulta дайте в цикле нам посмотреть только на фейлы-Failures, к примеру
        for (Failure failure : result.getFailures()){
            System.out.println("Битый кейс: " + result.getClass().getName() + failure.toString());
        }
        //вцелом показать результат нашего тест-сюита, был ли он саксесфул?
        System.out.println(result.wasSuccessful());
    }

}