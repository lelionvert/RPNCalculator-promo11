package fr.lacombe;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public enum Operator {
    MULTIPLICATION("*", (a, b) -> a * b),
    ADDITION("+", (a, b) -> a + b);

    private static final List<Operator> values = List.of(values());
    public final String operator;
    private final BinaryOperator<Integer> operation;

    Operator(String operator, BinaryOperator<Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    static Predicate<String> isOperator() {
        return element -> values.stream().map(o -> o.operator).anyMatch(element::equals);
    }
}
