package org.example;

import java.util.HashMap;

public interface Operation {
    Float execute(Float[] parameters);
    String[] getParameterNames();
    Boolean checkParameters(Float[] parameters);

}
