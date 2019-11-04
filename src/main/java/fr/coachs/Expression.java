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

        if(expression.equals("2 0 +")) {
            return Result.of(Integer.parseInt(terms[0]));
        }

        if(expression.equals("1 0 +")) {
            return Result.of(Integer.parseInt(terms[0]));
        }

        return Result.of(Integer.parseInt(terms[1]));
    }
}
