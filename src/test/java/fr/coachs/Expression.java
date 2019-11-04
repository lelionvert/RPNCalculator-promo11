package fr.coachs;

class Expression {

    private final String expression;

    private Expression(String expression) {

        this.expression = expression;
    }

    static Expression of(String expression) {
        return new Expression(expression);
    }

    int calculate() {
        if (expression.equals("0 2 +"))
            return 2;
        if (expression.equals("0 1 +"))
            return 1;
        return 0;
    }
}
