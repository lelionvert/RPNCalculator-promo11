import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void test() {
        Assertions.assertThat(calculate()).isEqualTo(0);
    }

    private int calculate() {
        return 0;
    }
}
