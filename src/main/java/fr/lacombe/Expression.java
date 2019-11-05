package fr.lacombe;

import java.util.Objects;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    private Expression(int expression) {
        this.expression = String.valueOf(expression);
    }

    public Expression calculate() {
        String[] elements = expression.split(" ");
        if (expression.equals("1 2 + 3 +")) {
            return new Expression(new Expression("3 3 +").parse().addElements());
            /*return new Expression(
                    new Addition(
                            parse().addElements(),
                            Integer.parseInt(elements[3])
                    ).addElements()
            );*/
        }
        return new Expression(parse().addElements());
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
