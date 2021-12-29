package DataService;

import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class DataServiceTest {

    @BeforeClass//аннотация junit один раз
    public static void beforeClass() throws Exception {
        System.out.println("Executes it before this class;)");
    }
    @AfterClass//аннотация junit один раз
    public static void afterClass() throws Exception {
        System.out.println("Executes it after this class;)");
    }
    @Before//аннотация junit
    public void setUp() throws Exception {
        System.out.println("Executes it before every test;)");
    }
    @After//аннотация junit
    public void tearDown() throws Exception {
        System.out.println("Executes it after every test;)");
    }

    @Test //тестируем нахождение максимального элемента
    public void testFindMax() throws Exception {
        //создаём разные вариации данных в списках
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,10,20,30,40);
        //отправляем разные списки в обработку статическому методу findMax класса DataService
        int max = DataService.findMax(numbers);
        int max2 = DataService.findMax(numbers2);
        assertEquals(max,6);//Равно ли этому макс числу, которое мы знаем
        assertEquals(max2,40);
        //c помощью библиоеки AssertJ можно делать цепочки сравнений
        assertThat(max2).isNotNull()
                .isGreaterThan(10).isLessThan(100)
                .isEqualTo(40);
    }
    @Test(expected = Exception.class)//тестируем выброс эксепшена
    public void testFindMaxException() throws Exception {
        //создаём пустые и нулл данные в списке
        List<Integer> numbers = Arrays.asList();
        List<Integer> numbers2 = null;
        DataService.findMax(numbers);
        DataService.findMax(numbers2);
        //тест - фейл "List of numbers is empty", если не запишем в аннотации вверу какой эксепшн мы ожидаем!!
        //(expected = Exception.class) вписываем и ожидаем появление эксепшена, в итоге тест - passed
    }
    @Test //тестируем нахождение максимального элемента через стрим
    public void testFindMaxByStreams() throws Exception {
        //создаём разные вариации данных в списках
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,10,20,30,40);
        //отправляем разные списки в обработку статическому методу findMax класса DataService
        int max = DataService.findMaxByStreams(numbers);
        int max2 = DataService.findMaxByStreams(numbers2);
        assertEquals(max,6);//Равно ли этому макс числу, которое мы знаем
        assertEquals(max2,40);
    }
    @Test(expected = Exception.class)//тестируем выброс эксепшена  через стрим, ожидаем его и тест будет passed
    public void testFindMaxExceptionByStreams() throws Exception {
        //создаём пустые и нулл данные в списке
        List<Integer> numbers = Arrays.asList();
        DataService.findMaxByStreams(numbers);
        DataService.findMaxByStreams(null);
    }
    @Test (timeout = 100)//тест производительности должен отработать за определенные ms
    public  void testPerformance() throws Exception {
        //большой стрим чисел от 0 по единичке до 2000 собрать в лист
        List<Integer> numbers = Stream.iterate(0, n->n+1).limit(2000)
                .collect(Collectors.toList());
        DataService.findMaxByStreams(numbers);


    }
}