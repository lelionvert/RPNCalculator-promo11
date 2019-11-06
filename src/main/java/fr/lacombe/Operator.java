package fr.lacombe;

import java.util.List;
import java.util.function.Predicate;

public enum Operator {
    MULTIPLICATION("*"),
    ADDITION("+");

    private static final List<Operator> values = List.of(values());
    public final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    static Predicate<String> isOperator() {
        return element -> values.stream().map(o -> o.operator).anyMatch(element::equals);
    }
}
