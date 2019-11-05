package fr.lacombe;

class Addition {
    static final String OPERATOR = "+";
    private final int first;
    private final int second;

    Addition(int first, int second) {
        this.first = first;
        this.second = second;
    }

    int addElements() {
        return first
                + second;
    }
}
