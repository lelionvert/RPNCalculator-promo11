package fr.lacombe;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Operator operator = getFirstOperator();
        String firstOperator = operator.operator;
        if (containsMultipleOperations()) {
            Expression firstExpression = getFirstExpression(firstOperator).calculate();
            Expression nextExpression = getNextExpression(firstOperator, firstExpression);
            return nextExpression.calculate();
        }
        return new Expression(operator.parse(elements).operate());
    }

    private Expression getNextExpression(String firstOperator, Expression firstExpression) {
        int operatorIndex = elements.indexOf(firstOperator);

        return new Expression(firstExpression + DELIMITER + join(DELIMITER, elements.subList(operatorIndex + 1, elements.size())));
    }

    private Operator getFirstOperator() {
        return elements.stream()
                .filter(Operator::isOperator)
                .map(Operator::of)
                .map(Optional::get)
                .findFirst()
                .get();
    }

    private boolean containsMultipleOperations() {
        return elements.stream().filter(Operator::isOperator)
                .count() > 1;
    }

    private Expression getFirstExpression(String operator) {
        int index = elements.indexOf(operator);

        return new Expression(elements.stream()
                .skip(index - NUMBER_OF_OPERANDS)
                .limit(OPERATION_SIZE)
                .collect(joining(DELIMITER)));
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
        return join(DELIMITER, elements);
    }
}
