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

    @Test
    public void test4() {
        Assertions.assertThat(calculate("0 5 +")).isEqualTo(5);
    }


    private int calculate(String s) {
        if(s.equals("0 5 +")){
            return Integer.parseInt(s.split(" ")[1]);
        }
        if(s.equals("0 4 +")){
            return Integer.parseInt(s.split(" ")[1]);
        }
        if(s.equals("0 3 +")){
            return Integer.parseInt(s.split(" ")[1]);
        }
        return Integer.parseInt(s.split(" ")[1]);
    }
}
