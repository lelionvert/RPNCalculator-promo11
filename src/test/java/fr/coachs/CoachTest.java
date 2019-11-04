package fr.coachs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CoachTest {
    @Test
    void addition_of_0_and_0_should_return_0() {
        Assertions.assertThat(Expression.of("0 0 +").calculate()).isEqualTo(0);
    }

    @Test
    void addition_of_0_and_a_number_should_return_the_number() {
        Assertions.assertThat(Expression.of("0 1 +").calculate())
                .isEqualTo(1);
    }

    @Test
    void addition_of_0_and_a_number_should_return_the_number_1() {
        Assertions.assertThat(Expression.of("0 2 +").calculate())
                .isEqualTo(2);
    }
}
