import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void test() {
        Assertions.assertThat(calculate("0 0 +")).isEqualTo(0);
    }

    private int calculate(String s) {
        return 0;
    }
}
