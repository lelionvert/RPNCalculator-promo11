package fr.coachs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoachTest {
    @Test
    void addition_of_0_and_0_should_return_0() {
        Assertions.assertThat(Expression.of("0 0 +").calculate()).isEqualTo(0);
    }

}
