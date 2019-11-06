package fr.lacombe;

public class Division extends Operation {

    Division(int first, int second) {
        super(first, second);
    }

    @Override
    public int operate() {
        return first / second;
    }
}
