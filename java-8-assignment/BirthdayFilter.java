import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BirthdayFilter {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Usage: BirthdayFilter <input file> <target month> <output file>");
            return;
        }

        String inputFile = args[0];
        int targetMonth = Integer.parseInt(args[1]);
        String outputFile = args[2];

        try (Stream<String> lines = Files.lines(Paths.get(inputFile))) {
            List<String> result = lines
                    .map(Person::fromString)
                    .filter(person -> person.getDateOfBirth().getMonth() == Month.of(targetMonth))
                    .sorted((p1, p2) -> {
                        int lastNameCompare = p1.getLastName().compareTo(p2.getLastName());
                        return lastNameCompare != 0 ? lastNameCompare : p1.getFirstName().compareTo(p2.getFirstName());
                    })
                    .map(Person::toString)
                    .collect(Collectors.toList());

            Files.write(Paths.get(outputFile), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

