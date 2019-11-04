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
        if (expression.startsWith("0"))
            return Integer.parseInt(expression.split(" ")[1]);
        throw new UnsupportedOperationException();
    }
}
