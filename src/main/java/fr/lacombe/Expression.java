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
        if (elements.contains("/") && elements.contains("0")){
            return new Expression("INVALID");
        }
        Operator operator = getFirstOperator();
        if (containsMultipleOperations()) {
            Expression firstExpression = getFirstExpression(operator.getOperatorIndex(elements)).calculate();
            Expression nextExpression = getNextExpression(firstExpression, operator.getOperatorIndex(elements));
            return nextExpression.calculate();
        }
        return new Expression(operator.parse(elements).operate());
    }

    private Expression getNextExpression(Expression firstExpression, int operatorIndex) {

        return new Expression(firstExpression + DELIMITER + join(DELIMITER, elements.subList(operatorIndex + 1, elements.size())));
    }

    private Expression getFirstExpression(int operatorIndex) {

        return new Expression(elements.stream()
                .skip(operatorIndex - NUMBER_OF_OPERANDS)
                .limit(OPERATION_SIZE)
                .collect(joining(DELIMITER)));
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
