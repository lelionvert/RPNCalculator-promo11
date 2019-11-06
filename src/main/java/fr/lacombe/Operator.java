package fr.lacombe;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public enum Operator {
    MULTIPLICATION("*", Operation2::operate),
    ADDITION("+", Operation2::operate);

    private static final List<Operator> values = List.of(values());
    public final String operator;
    public final Function<Operation2, Integer> operation;

    Operator(String operator, Function<Operation2, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    static boolean isOperator(String element) {
        return values.stream().map(o -> o.operator).anyMatch(element::equals);
    }

    static Optional<Operator> of(String element) {
        return values.stream().filter(o -> o.operator.equals(element)).findFirst();
    }
}
