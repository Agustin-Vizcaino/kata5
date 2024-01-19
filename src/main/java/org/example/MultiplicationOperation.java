package org.example;

public class MultiplicationOperation implements Operation {

    String[] parameters = new String[] { "multiplicand", "multiplier" };
    @Override
    public Float execute(Float[] parameters) {
        return parameters[0] * parameters[1];
    }

    @Override
    public String[] getParameterNames() {
        return parameters;
    }

    @Override
    public Boolean checkParameters(Float[] parameters) {
        return parameters.length == 2;
    }
}
