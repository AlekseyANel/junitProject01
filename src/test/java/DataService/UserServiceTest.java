package DataService;

import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD) for @BeforeAll-static and @AfterAll-static, чтобы были разные экземпляры userService в тестовых методах
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) for @BeforeAll and @AfterAll, чтобы был один экземпляр userService в тестовых методах этого класса
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class UserServiceTest {
    //инициализируем переменную userService класса UserService
    private UserService userService;

    @BeforeAll
    static void init() {
        System.out.println("Before All: initialisationPool"/*without + this, because Static*/);
    }
    @AfterAll
    static void closeConnectionPool() {
        System.out.println("After All: closeConnectionPool"/*without + this, because Static*/);
    }
    @BeforeEach
    void prepare() {
        System.out.println("Before Each: "+ this);
        //Перед каждым тестом создаем новый экземпляр userService класса UserService,
        //чтобы обеспечить тестам независимость
        userService = new UserService();
    }
    @AfterEach
    void deleteDataFromBb() {
        System.out.println("After Each: "+ this);
    }

    @Test
    void usersEmptyIfNoUserAdded() {
        System.out.println("TestNoUserAdded: "+ this);
        //создаем переменную users (типа List<User>) и присваиваем ей результат метода getAll
        var users = userService.getAll();
        assertTrue(users.isEmpty());
    }
    @Test
    void usersSizeIfUserAdded() {
        System.out.println("TestUserAdded: "+ this);
        //добавляем новых "пустых" юзеров методом адд из того же класса UserService
        userService.add(new User("Alex", "Black","+380509999999"));
        userService.add(new User("John", "Doe","+380509999999"));
        //вызываем весь уже новый список и сравниваем его размер
        var users = userService.getAll();
        assertEquals(2, users.size());
    }
}