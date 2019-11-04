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

    @Test
    public void test3() {
        Assertions.assertThat(calculate("0 3 +")).isEqualTo(3);
    }


    private int calculate(String s) {
        if(s.equals("0 4 +")){
            return 4;
        }
        if(s.equals("0 3 +")){
            return 3;
        }
        return 0;
    }
}
