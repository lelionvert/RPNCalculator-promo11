package fr.lacombe;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static java.lang.String.join;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

public class Expression {
    private static final int NUMBER_OF_OPERANDS = 2;
    private static final int OPERATION_SIZE = 3;
    private static final String DELIMITER = " ";
    private final List<String> elements;

    public Expression(String expression) {
        this.elements = List.of(expression.split(DELIMITER));
    }

    private Expression(int expression) {
        this(valueOf(expression));
    }

    public Expression calculate() {

        if (elements.contains("*")){
            if (containsMultipleOperations()) {
                int firstExpression = getFirstExpression(Operation.MULTIPLICATION).parse().multiplyElements();
                Expression nextExpression = getNextExpression(firstExpression, Operation.MULTIPLICATION);
                return nextExpression.calculate();
            }
            return new Expression(parse().multiplyElements());
        }

        if (containsMultipleOperations()) {
            int firstExpression = getFirstExpression(Operation.ADDITION).parse().addElements();
            Expression nextExpression = getNextExpression(firstExpression, Operation.ADDITION);
            return nextExpression.calculate();
        }

        return new Expression(parse().addElements());
    }

    private boolean containsMultipleOperations() {
        return elements.stream().filter(isOperator())
                .count() > 1;
    }

    private Predicate<String> isOperator() {
        return element -> element.equals(Operation.ADDITION) || element.equals(Operation.MULTIPLICATION);
    }

    private Expression getNextExpression(int firstExpression, String operator) {
        int index = elements.indexOf(operator);

        return new Expression(firstExpression + DELIMITER + join(DELIMITER, elements.subList(index + 1, elements.size())));
    }

    private Expression getFirstExpression(String operator) {
        int index = elements.indexOf(operator);

        return new Expression(elements.stream()
                .skip(index - NUMBER_OF_OPERANDS)
                .limit(OPERATION_SIZE)
                .collect(joining(DELIMITER)));
    }

    private Operation parse() {
        return new Operation(
                Integer.parseInt(elements.get(0)),
                Integer.parseInt(elements.get(1))
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;
        Expression that = (Expression) o;
        return elements.equals(that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        return "Expression{" +
                "elements=" + elements +
                '}';
    }
}
