package org.operations;

import org.operations.Operation;

public class AdditionOperation implements Operation {
    String[] parameters = new String[] { "summand1", "summand2" };
    @Override
    public Float execute(Float[] parameters) {
        return parameters[0] + parameters[1];
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
