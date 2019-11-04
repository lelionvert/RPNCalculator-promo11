import fr.lacombe.Expression;
import org.assertj.core.api.Assertions;
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
    public void addition_of_zero_and_n_number_returns_n(String entry, String expected) {
        Expression expected1 = new Expression(expected);
        Assertions.assertThat(new Expression(entry).calculate3()).isEqualTo(expected1);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 0 +, 1",
            "2 0 +, 2",
            "7 0 +, 7"
    })
    public void addition_of_n_number_and_zero_returns_n(String entry, int expected) {
        Assertions.assertThat(new Expression(entry).calculate3().toInt()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 4 +, 5"
    })
    public void addition_of_two_different_numbers_returns_sum(String entry, int expected) {
        Assertions.assertThat(new Expression(entry).calculate3().toInt()).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "1 2 + 3 +, 6",
            "1 2 3 + +, 6"
    })
    public void addition_of_three_different_numbers_returns_sum(String entry, int expected) {
        Assertions.assertThat(new Expression(entry).calculate3().toInt()).isEqualTo(expected);
    }

}
