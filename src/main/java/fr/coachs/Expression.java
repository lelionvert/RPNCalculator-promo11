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
        return Integer.parseInt(expression.split(" ")[1]);
    }
}
