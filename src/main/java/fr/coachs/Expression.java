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
        String[] terms = expression.split(" ");

        if (terms[0].equals("0"))
            return Result.of(Integer.parseInt(terms[1]));

        return Result.of(Integer.parseInt(terms[0]));
    }
}
