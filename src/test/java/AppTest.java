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

    private int calculate(String s) {
        return Integer.parseInt(s.split(" ")[1]);
    }
}
