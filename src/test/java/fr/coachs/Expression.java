package fr.coachs;

public class Expression {

    private final String expression;

    public Expression(String expression) {

        this.expression = expression;
    }

    public static Expression of(String expression) {
        return new Expression(expression);
    }

    int calculate() {
        return 0;
    }
}
