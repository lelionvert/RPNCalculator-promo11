import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0 0 +, 0",
            "0 3 +, 3",
            "0 4 +, 4",
            "0 5 +, 5"
    })
    public void addition_of_zero_and_n_number_returns_n(String entry, int expected) {
        Assertions.assertThat(calculate(entry)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 0 +, 1",
            "2 0 +, 2",
            "7 0 +, 7"
    })
    public void addition_of_n_number_and_zero_returns_n(String entry, int expected) {
        Assertions.assertThat(calculate(entry)).isEqualTo(expected);
    }

    private int calculate(String s) {
        String secondElement = s.split(" ")[1];
        if (secondElement.equals("0"))
            return Integer.parseInt(s.split(" ")[0]);
        if (s.equals("2 0 +"))
            return Integer.parseInt(s.split(" ")[0]);
        if (s.equals("7 0 +"))
            return Integer.parseInt(s.split(" ")[0]);
        return Integer.parseInt(s.split(" ")[1]);
    }
}
