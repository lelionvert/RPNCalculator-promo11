package fr.lacombe;

public class Addition {
    private final int first;
    private final int second;

    public Addition(int first, int second) {
        this.first = first;
        this.second = second;
    }

    int addElements() {
        return first
                + second;
    }
}
