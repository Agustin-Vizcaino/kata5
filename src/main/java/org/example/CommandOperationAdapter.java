package org.example;

public class CommandOperationAdapter implements Command {
    Operation operation;

    public void CommandOperationAdapter(Operation inputOperation) {
        operation = inputOperation;
    }

    @Override
    public Output execute(Input input) {

        return new Output() {
            @Override
            public int response() {
                return 0;
                //operation.checkParameters() ? return 200 : return 502;
            }

            @Override
            public String result() {
                return String.valueOf("");
            }
        };
    }
}
