package fr.lacombe;

abstract class Operation2 {
    final int first;
    final int second;

    Operation2(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public abstract int operate();

}
