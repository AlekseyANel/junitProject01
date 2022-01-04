package DataService;

import java.util.Comparator;
import java.util.List;
//Класс обрабатывает коллекцию чисел
public class DataService {
    //это первый статик метод поиска максимадьного элемента.
    //На вход ему даем список элементов. На выходе - максимальный элемент из списка 'numbers'
    public static int findMax(List<Integer> numbers) throws Exception {
        if (numbers == null || numbers.isEmpty()) {
            //проверяем входящий список на такие вот условия и выбрасываем исключение
            throw  new Exception("List of numbers is empty");
            //выкидывание эксепшена тоже будем тестировать
        }
        //поиск макс элемента
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size() ; i++) {
            int current = numbers.get(i);
            if (max<current) {
                max=current;
            }
        }
        //возврат методом макс элемента
        return max;
    }

    //это второй более короткий метод поиска максимального элемента, но уже из стрима элементов
    public static int findMaxByStreams (List<Integer> numbers) throws Exception {
        //Comparator.naturalOrder() - порядок ищет макс
        //Comparator.reverseOrder() - порядок ищет мин
        // или иначе выкидываем эксепшен с сообщением
        Integer max = numbers.stream().max(Comparator.naturalOrder()).
                orElseThrow(()->new Exception("List of numbers is empty"));
        return max;
    }
}
