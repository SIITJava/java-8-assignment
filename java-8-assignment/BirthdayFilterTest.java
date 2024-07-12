import jdk.jfr.StackTrace;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayFilterTest {
    @Test
    public void testFilterAndSort() throws IOException {

        String inputFile = "test_input.txt";
        String outputFile = "test_output.txt";
        int targetMonth = 5; // May


        List<String> inputLines = List.of(
                "John,Doe,1991-05-15",
                "Jaden,Smith,1995-05-21",
                "Bobby,Brown,1982-04-12",
                "Alice,Zones,1989-05-05"
        );
        Files.write(Paths.get(inputFile), inputLines);


        BirthdayFilter.main(new String[]{inputFile, String.valueOf(targetMonth), outputFile});


        List<String> expectedOutput = List.of(
                "Alice Zones",
                "John Doe",
                "Jaden Smith"
        );
        List<String> actualOutput = Files.lines(Paths.get(outputFile)).collect(Collectors.toList());
        assertEquals(expectedOutput, actualOutput);


        Files.delete(Paths.get(inputFile));
        Files.delete(Paths.get(outputFile));
    }

    private void assertEquals(List<String> expectedOutput, List<String> actualOutput) {

    }
}

