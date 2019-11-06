package fr.lacombe;

public class Multiplication extends Operation2 {
    Multiplication(int first, int second) {
        super(first, second);
    }

    @Override
    public int operate() {
        return first * second;
    }
}
