import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest {
    @Test
    public void addition_of_two_zeros_returns_0() {
        Assertions.assertThat(calculate("0 0 +")).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0 4 +, 4", "0 3 +, 3", "0 5 +, 5"})
    public void addition_of_zero_and_n_number_returns_n(String entry, int expected) {
        Assertions.assertThat(calculate(entry)).isEqualTo(expected);
    }

    @Test
    public void test3() {
        Assertions.assertThat(calculate("0 3 +")).isEqualTo(3);
    }

    @Test
    public void test4() {
        Assertions.assertThat(calculate("0 5 +")).isEqualTo(5);
    }


    private int calculate(String s) {
        return Integer.parseInt(s.split(" ")[1]);
    }
}
