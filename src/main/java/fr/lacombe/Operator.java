package fr.lacombe;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Operator {
    MULTIPLICATION( "*"),
    ADDITION("+");

    public final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    static Predicate<String> isOperator() {
        return element -> Arrays.stream(values()).map(o -> o.operator).anyMatch(element::equals);
    }
}
