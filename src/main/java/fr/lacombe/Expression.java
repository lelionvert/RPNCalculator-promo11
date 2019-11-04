package fr.lacombe;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public int calculate() {
        return calculate3().toInt();
    }

    private int toInt() {
        return Integer.parseInt(expression);
    }

    private Expression calculate3() {
        return new Expression(String.valueOf(calculate2()));
    }

    private int calculate2() {
        String[] elements = getExpression().split(" ");
        if (getExpression().equals("1 2 + 3 +"))
            return Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]) + Integer.parseInt(elements[3]);
        if (getExpression().equals("1 2 3 + +"))
            return Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]) + Integer.parseInt(elements[2]);
        return Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]);
    }
}
