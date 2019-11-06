package fr.lacombe;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum Operator {
    MULTIPLICATION("*", Operation::operate, Multiplication::new),
    ADDITION("+", Operation::operate, Addition::new);

    private static final List<Operator> values = List.of(values());
    public final String operator;
    public final Function<Operation, Integer> operation;
    public final BiFunction<Integer, Integer, Operation> operation2;

    Operator(String operator, Function<Operation, Integer> operation, BiFunction<Integer, Integer, Operation> operation2) {
        this.operator = operator;
        this.operation = operation;
        this.operation2 = operation2;
    }

    static boolean isOperator(String element) {
        return values.stream().map(o -> o.operator).anyMatch(element::equals);
    }

    static Optional<Operator> of(String element) {
        return values.stream().filter(o -> o.operator.equals(element)).findFirst();
    }

    Operation parse(List<String> elements) {
        int first = Integer.parseInt(elements.get(0));
        int second = Integer.parseInt(elements.get(1));
        return operation2.apply(first, second);
    }
}
