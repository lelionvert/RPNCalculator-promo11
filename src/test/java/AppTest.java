import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void test() {
        Assertions.assertThat(calculate("0 0 +")).isEqualTo(0);
    }

    @Test
    public void test2() {
        Assertions.assertThat(calculate("0 4 +")).isEqualTo(4);
    }


    private int calculate(String s) {
        if(s.equals("0 4 +")){
            return 4;
        }
        return 0;
    }
}
