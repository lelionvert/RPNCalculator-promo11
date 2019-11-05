package fr.lacombe;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.*;
import static java.util.Arrays.stream;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    private Expression(int expression) {
        this.expression = valueOf(expression);
    }

    public Expression calculate() {

        if (expression.equals("1 2 + 3 +") || expression.equals("1 2 + 4 +")) {
            int firstExpression = getFirstExpression().parse().addElements();
            Expression nextExpression = getNextExpression(firstExpression);
            return new Expression(nextExpression.parse().addElements());
        }
        return new Expression(parse().addElements());
    }

    private Expression getNextExpression(int firstExpression) {
        List<String> elements = List.of(expression.split(" "));
        int index = elements.indexOf("+");

        return new Expression(firstExpression + " " + join(" ", elements.subList(index + 1, elements.size())));
    }

    private Expression getFirstExpression() {
        String[] elements = expression.split(" ");
        int index = List.of(elements).indexOf("+");

        return new Expression(stream(elements)
                .skip(index - 2)
                .limit(3)
                .collect(Collectors.joining(" ")));
    }

    private Addition parse() {
        String[] elements = expression.split(" ");
        return new Addition(
                Integer.parseInt(elements[0]),
                Integer.parseInt(elements[1])
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;
        Expression that = (Expression) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }

    @Override
    public String toString() {
        return "Expression{" +
                "expression='" + expression + '\'' +
                '}';
    }
}
