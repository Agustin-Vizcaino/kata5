package org.example;

import java.util.List;

public class CommandOperationAdapter implements Command {
    Operation operation;

    public void CommandOperationAdapter(Operation inputOperation) {
        operation = inputOperation;
    }

    @Override
    public Output execute(Input input) {

        return new Output() {
            Float[] par;
            @Override
            public int response() {
                List<Float> parList = null;
                for (String i : operation.getParameterNames()) {
                    String buffer = input.get(i);
                    if (buffer == null || !isFloat(buffer)) {
                        return 502;
                    }
                    parList.add(Float.parseFloat(buffer));
                }
                par = (Float[]) parList.toArray();
                if (!operation.checkParameters(par)) return 502;
                return 200;
                //operation.checkParameters() ? return 200 : return 502;
            }

            @Override
            public String result() {
                if (response() == 200) return operation.execute(par).toString();
                String returner = "The components of this operation are: ";
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
