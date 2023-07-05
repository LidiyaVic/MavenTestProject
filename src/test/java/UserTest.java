import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private List<User> userList;

    @BeforeAll
    static void printMessage() {
        System.out.println("Running UserTest");
    }

    @BeforeEach
    void setup() {
        userList = new ArrayList<>();
        userList.add(new User("Ivan", "Artemenko", 66));
        userList.add(new User("Mariya", "Bondar", 30));
        userList.add(new User("Oleksandr", "Karas", 33));
        userList.add(new User("Olena", "Shevchenko", 28));
        userList.add(new User("Mykhailo", "Sydorenko", 15));
        userList.add(new User("Olha", "Kravchenko", 19));
        userList.add(new User("Dmytro", "Boyko", 31));
        userList.add(new User("Sofiya", "Lytovchenko", 47));
        userList.add(new User("Andriy", "Melnichenko", 92));
        userList.add(new User("Yana", "Ivanchenko", 23));
    }

    @Test
    @DisplayName("sortUsersByAgeTest Negative test")
    void sortUsersByAgeTest() {
        assertThrows(NullPointerException.class, () -> User.sortUsersByAge(null));
    }

    @Test
    @DisplayName("calculateAverageAgeEmptyListTest Positive test")
    void calculateAverageAgeEmptyListTest() {
        List<User> userList = new ArrayList<>();
        double expectedResult = 0;
        double result = User.calculateAverageAge(userList);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("checkLastNameWithFirstCharacters Positive test")
    void checkLastNameWithFirstCharacters() {
        List<User> users = new ArrayList<>();
        users.add(new User("Anna", "Holub", 25));
        users.add(new User("Igor", "Kulik", 30));
        boolean expectedResult = userList.stream()
                .anyMatch(user -> user.getLastName().startsWith("S") || user.getLastName().startsWith("A"));
        boolean result = User.checkLastNameWithFirstCharacter(userList);
        assertEquals(expectedResult, result);
    }

    @RepeatedTest(10)
    @DisplayName("checkLastNameWithFirstCharacter Negative test")
    void checkLastNameWithFirstCharacter() {
        List<User> users = new ArrayList<>();
        users.add(new User("Anna", "Holub", 25));
        boolean result = User.checkLastNameWithFirstCharacter(users);
        assertFalse(result);
    }

    @Test
    @DisplayName("checkLastNameWithFirstCharacterNull Negative test")
    void checkLastNameWithFirstCharacterNull() {
        List<User> users = new ArrayList<>();
        boolean result = User.checkLastNameWithFirstCharacter(users);
        assertFalse(result);
    }

    @Test
    @DisplayName("checkUsersOver18 Positive test")
    void checkUsersOver18() {
        List<User> users = new ArrayList<>();
        users.add(new User("Anna", "Holub", 25));
        users.add(new User("Igor", "Kulik", 30));
        boolean result = User.checkUsersOver18(users);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {17})
    @DisplayName("checkUsersOver18 Negative test")
    void checkUsersOver18(int age) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ira", "Starko", age));
        boolean result = User.checkUsersOver18(users);
        assertFalse(result);
    }

    @AfterEach
    void clearUserList() {
        userList.clear();
    }
}
