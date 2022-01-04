package Thing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

//Другой вариант запуска сьют-тестов в Thing Package - через данный раннер
//Create java-class to execute test cases, в т.ч. в виде набора-suite 2х и более тестов
public class ThingTestRunner {
    public static void main (String[] args) {
        //Специальный движок JUnitCore генерирует result запуска тестов
        Result result = JUnitCore.runClasses(
                ThingTest.class);
        //Из resulta дайте в цикле нам посмотреть только на фейлы-Failures, к примеру
        for (Failure failure : result.getFailures()){
            System.out.println("Битый кейс: " + result.getClass().getName() + failure.toString());
        }
        //подсчитать кол-во кейсов в тест-сюите
        System.out.println("Number of test cases = " + result.getRunCount());
        //вцелом показать результат нашего тест-сюита, был ли он саксесфул?
        System.out.println("Is 'Thing' test-suite successful? - "+result.wasSuccessful());
    }

}