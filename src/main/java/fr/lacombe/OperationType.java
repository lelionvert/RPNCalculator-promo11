package fr.lacombe;

public enum OperationType {
    MULTIPLICATION( "*");

    public final String operator;

    OperationType(String operator) {
        this.operator = operator;
    }
}
