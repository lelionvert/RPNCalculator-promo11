package fr.lacombe;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.lang.String.valueOf;

public class Expression {
    private final List<String> elements;

    public Expression(String expression) {
        this.elements = List.of(expression.split(" "));
    }

    private Expression(int expression) {
        this(valueOf(expression));
    }

    public Expression calculate() {

        if (elements.size() > 3) {
            int firstExpression = getFirstExpression().parse().addElements();
            Expression nextExpression = getNextExpression(firstExpression);
            return nextExpression.calculate();
        }

        return new Expression(parse().addElements());
    }

    private Expression getNextExpression(int firstExpression) {
        int index = elements.indexOf("+");

        return new Expression(firstExpression + " " + join(" ", elements.subList(index + 1, elements.size())));
    }

    private Expression getFirstExpression() {
        int index = elements.indexOf("+");

        return new Expression(elements.stream()
                .skip(index - 2)
                .limit(3)
                .collect(Collectors.joining(" ")));
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
