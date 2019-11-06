package fr.lacombe;

public class Multiplication extends Operation {
    Multiplication(int first, int second) {
        super(first, second);
    }

    @Override
    public int operate() {
        return first * second;
    }
}
