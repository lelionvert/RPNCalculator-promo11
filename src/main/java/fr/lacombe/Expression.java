package fr.lacombe;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

public class Expression {
    public static final int NUMBER_OF_OPERANDS = 2;
    public static final int OPERATION_SIZE = 3;
    public static final String DELIMITER = " ";
    private final List<String> elements;

    public Expression(String expression) {
        this.elements = List.of(expression.split(DELIMITER));
    }

    private Expression(int expression) {
        this(valueOf(expression));
    }

    public Expression calculate() {

        if (containsMultipleOperations()) {
            int firstExpression = getFirstExpression().parse().addElements();
            Expression nextExpression = getNextExpression(firstExpression);
            return nextExpression.calculate();
        }

        return new Expression(parse().addElements());
    }

    private boolean containsMultipleOperations() {
        return elements.stream().filter(isOperator())
                .count() > 1;
    }

    private Predicate<String> isOperator() {
        return element -> element.equals("+");
    }

    private Expression getNextExpression(int firstExpression) {
        int index = elements.indexOf("+");

        return new Expression(firstExpression + DELIMITER + join(DELIMITER, elements.subList(index + 1, elements.size())));
    }

    private Expression getFirstExpression() {
        int index = elements.indexOf("+");

        return new Expression(elements.stream()
                .skip(index - NUMBER_OF_OPERANDS)
                .limit(OPERATION_SIZE)
                .collect(joining(DELIMITER)));
    }

    private Addition parse() {
        return new Addition(
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
