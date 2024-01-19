package org.example;

public class DivisionOperation implements Operation {
    @Override
    public Float execute(Float[] parameters) {
        return parameters[0] / parameters[1];
    }

    @Override
    public Boolean checkParameters(Float[] parameters) {
        return parameters.length == 2 && parameters[1] != 0;
    }
}