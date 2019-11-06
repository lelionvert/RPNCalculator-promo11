package fr.lacombe;

public class Addition extends Operation {
    Addition(int first, int second) {
        super(first, second);
    }

    @Override
    public int operate() {
        return first + second;
    }
}
