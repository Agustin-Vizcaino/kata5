package org.example;

import org.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public class CommandOperationAdapter implements Command {
    Operation operation;

    public CommandOperationAdapter(Operation inputOperation) {
        operation = inputOperation;
    }

    @Override
    public Output execute(Input input) {

        return new Output() {
            Float[] par = new Float[] {};
            @Override
            public int response() {
                List<Float> parList = new ArrayList<Float>();
                for (String i : operation.getParameterNames()) {
                    String buffer = input.get(i);
                    if (buffer == null || !isFloat(buffer)) {
                        return 502;
                    }
                    parList.add(Float.parseFloat(buffer));
                }
                try {
                    par = parList.toArray(par);
                    if (!operation.checkParameters(par)) return 502;
                    return 200;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return 502;
                }
            }

            @Override
            public String result() {
                if (response() == 200) return "Result: " + String.valueOf(operation.execute(par));
                String returner = "Error: the components of this operation are: ";
                for (String i : operation.getParameterNames()) returner += i + " ";
                return returner;
            }
        };
    }

    public boolean isFloat(String input) {
        try{
            Float.parseFloat(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
