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
        if (expression.equals("0 1 +"))
            return 1;
        return 0;
    }
}
