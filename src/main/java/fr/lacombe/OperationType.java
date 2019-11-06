package fr.lacombe;

public enum OperationType {
    MULTIPLICATION( "*"), ADDITION("+");

    public final String operator;

    OperationType(String operator) {
        this.operator = operator;
    }
}
