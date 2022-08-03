package com.example.graphqltester;

public class Result {

    private final Integer numer;

    public Result(final Integer numer) {
        this.numer = numer;
    }

	@Override
	public String toString() {
		return "Result{" +
				"numer=" + numer +
				'}';
	}
}
