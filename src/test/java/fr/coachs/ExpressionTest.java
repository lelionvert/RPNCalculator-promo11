package fr.coachs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    @Test
    void addition_of_0_and_0_should_return_0() {
        assertThat(Expression.of("0 0 +").calculate()).isEqualTo(Result.ZERO);
    }

    @Test
    void addition_of_0_and_a_number_should_return_the_number() {
        assertThat(Expression.of("0 1 +").calculate()).isEqualTo(Result.of(1));
    }

    @Test
    void addition_of_0_and_a_number_should_return_the_number_1() {
        assertThat(Expression.of("0 2 +").calculate()).isEqualTo(Result.of(2));
    }

    @Test
    void addition_of_a_number_and_0_should_return_the_number() {
        assertThat(Expression.of("2 0 +").calculate()).isEqualTo(Result.of(2));
    }


    @Test
    void addition_of_a_number_and_0_should_return_the_number_1() {
        assertThat(Expression.of("1 0 +").calculate()).isEqualTo(Result.of(1));
    }

    @Test
    void addition_of_two_numbers_should_return_the_sum() {
        assertThat(Expression.of("1 2 +").calculate()).isEqualTo(Result.of(3));
    }
}
