package fr.lacombe;

class Operation {
    private final int first;
    private final int second;

    Operation(int first, int second) {
        this.first = first;
        this.second = second;
    }

    int addElements() {
        return first
                + second;
    }

    int multiplyElements() {
        return first * second;
    }

    int operate(String operator){
        return operator.equals(Operator.MULTIPLICATION.operator) ? multiplyElements() : addElements();
    }
}
