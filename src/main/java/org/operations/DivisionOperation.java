package org.operations;

import org.operations.Operation;

public class DivisionOperation implements Operation {
    String[] parameters = new String[] { "dividend", "divisor" };
    @Override
    public Float execute(Float[] iparameters) {
        return iparameters[0] / iparameters[1];
    }

    @Override
    public String[] getParameterNames() {
        return parameters;
    }

    @Override
    public Boolean checkParameters(Float[] iparameters) {
        return iparameters.length == 2 && iparameters[1] != 0;
    }
}
