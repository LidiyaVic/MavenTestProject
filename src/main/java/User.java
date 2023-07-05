import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {
    private final String firstName;
    private final String lastName;
    private final int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public static void sortUsersByAge(List<User> userList) {
        List<User> sortedByAge = new ArrayList<>(userList);
        sortedByAge.sort(Comparator.comparingInt(User::getAge));

        System.out.println("Сортування користувачів за віком ");
        sortedByAge.forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName() + " - " + user.getAge()));
    }

    public static double calculateAverageAge(List<User> userList) {
        double averageAge = userList.stream()
                .mapToDouble(User::getAge)
                .average()
                .orElse(0);
        System.out.println("Середній вік користувачів " + averageAge);
        return averageAge;
    }

    public static void sortUsersByFirstNameAndAge(List<User> userList) {
        List<User> sortedByFirstNameAndAge = new ArrayList<>(userList);
        sortedByFirstNameAndAge.sort(
                Comparator.comparing(User::getFirstName)
                        .thenComparingInt(User::getAge)
        );
        sortedByFirstNameAndAge.forEach(user -> System.out.println("Користувачі, відсортовані за firstName та age " + user.getFirstName() + " " + user.getLastName() + " - " + user.getAge()));
    }

    public static boolean checkLastNameWithFirstCharacter(List<User> userList) {
        boolean lastNameWithFirstCharacter = userList.stream()
                .anyMatch(user -> user.getLastName().startsWith("S") || user.getLastName().startsWith("A"));
        System.out.println("Користувачі з прізвищем на 'S' та 'A' " + lastNameWithFirstCharacter);
        return lastNameWithFirstCharacter;
    }

    public static boolean checkUsersOver18(List<User> userList) {
        boolean usersOver18 = userList.stream()
                .allMatch(user -> user.getAge() > 18);
        System.out.println("Користувачі старше 18 років " + usersOver18);
        return usersOver18;
    }
}
