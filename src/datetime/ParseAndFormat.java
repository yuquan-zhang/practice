package datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ParseAndFormat {
    public static void main(String[] args) {
        String input = "20180921";
        try{
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate date = LocalDate.parse(input, formatter);
            System.out.printf("%s%n", date);
        }catch (DateTimeParseException e) {
            System.out.printf("%s is not parsable!%n", input);
            throw e;
        }
    }
}
