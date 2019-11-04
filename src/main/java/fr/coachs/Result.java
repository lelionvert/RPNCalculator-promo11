package fr.coachs;

import java.util.Objects;

public class Result {
    private final int value;

    private Result(int value) {

        this.value = value;
    }

    public static Result of(int value) {
        return new Result(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return value == result.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
