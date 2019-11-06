package fr.lacombe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public enum Operator {
    MULTIPLICATION( "*"),
    ADDITION("+");

    public final String operator;
    private static final List<Operator> values = List.of(values());

    Operator(String operator) {
        this.operator = operator;
    }

    static Predicate<String> isOperator() {
        return element -> values.stream().map(o -> o.operator).anyMatch(element::equals);
    }
}
