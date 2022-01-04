package DataService;

import java.util.ArrayList;
import java.util.List;
//Класс обрабатывает коллекцию ЮЗЕРОВ
class UserService {
//создаем, пока что, коллекцию вместо DAO-слоя
// (который, в свою очередь, должен обращаеться к БД и сохранять там юзеров)
private List<User> userList = new ArrayList<>();

    //Метод возвращает список всех юзеров класса User
    public List<User> getAll() {
        return userList;
                /*Collections.emptyList();//пока пустой возвращаем*/
    }
    //Метод добавляет в список List<User>users принятого юзера
    public boolean add(User user) {
        //а на выходе выдаёт только фолс или тру операции добавления
        return userList.add(user);
    }



}
