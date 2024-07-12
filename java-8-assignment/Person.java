import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static Person fromString(String line) {
        String[] parts = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new Person(parts[0].trim(), parts[1].trim(), LocalDate.parse(parts[2].trim(), formatter));
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

