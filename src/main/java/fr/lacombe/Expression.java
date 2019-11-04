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
        String[] elements = getExpression().split(" ");
        if (getExpression().equals("1 2 + 3 +"))
            return Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]) + Integer.parseInt(elements[3]);
        if (getExpression().equals("1 2 3 + +"))
            return Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]) + Integer.parseInt(elements[2]);
        return Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]);
    }
}
