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

    public Expression calculate3() {
        return new Expression(String.valueOf(calculate2()));
    }

    private int calculate2() {
        String[] elements = getExpression().split(" ");
        return Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]);
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
}
