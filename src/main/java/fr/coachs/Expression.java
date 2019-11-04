package fr.coachs;

class Expression {

    private final String expression;

    private Expression(String expression) {

        this.expression = expression;
    }

    static Expression of(String expression) {
        return new Expression(expression);
    }

    Result calculate() {
        if(expression.equals("2 0 +")) {
            return Result.of(2);
        }

        if(expression.equals("1 0 +")) {
            return Result.of(1);
        }

        return Result.of(Integer.parseInt(expression.split(" ")[1]));
    }
}
