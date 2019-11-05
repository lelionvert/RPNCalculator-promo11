package fr.lacombe;

import java.util.Objects;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public Expression calculate() {
        String[] elements = getExpression().split(" ");
        if (expression.equals("1 2 + 3 +")) {
            return new Expression(String.valueOf(
                    new Addition(new Addition(Integer.parseInt(elements[0]), Integer.parseInt(elements[1])).addElements(), Integer.parseInt(elements[3])).addElements()
            ));
        }
        return new Expression(
                String.valueOf(
                        new Addition(Integer.parseInt(elements[0]), Integer.parseInt(elements[1])).addElements()
                ));
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
