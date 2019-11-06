package fr.lacombe;

import java.util.function.Predicate;

public enum OperationType {
    MULTIPLICATION( "*"), ADDITION("+");

    public final String operator;

    OperationType(String operator) {
        this.operator = operator;
    }

    static Predicate<String> isOperator() {
        return element -> element.equals(ADDITION.operator) || element.equals(MULTIPLICATION.operator);
    }
}
