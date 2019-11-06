package fr.lacombe;

abstract class Operation {
    final int first;
    final int second;

    Operation(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public abstract int operate();

}
