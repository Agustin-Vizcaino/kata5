package org.example;

import org.operations.AdditionOperation;
import org.operations.DivisionOperation;
import org.operations.MultiplicationOperation;
import org.operations.SubtractionOperation;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        String[] operations = new String[] { "factorial", "addition", "subtraction", "division", "multiplication" };

        SparkCommandExecutor.put("factorial", new FactorialCommand());
        SparkCommandExecutor.put("addition", new CommandOperationAdapter(new AdditionOperation()));
        SparkCommandExecutor.put("subtraction", new CommandOperationAdapter(new SubtractionOperation()));
        SparkCommandExecutor.put("division", new CommandOperationAdapter(new DivisionOperation()));
        SparkCommandExecutor.put("multiplication", new CommandOperationAdapter(new MultiplicationOperation()));
        Spark.port(8080);
        for (String i : operations) {
            Spark.get("/" + i,(req,res)-> SparkCommandExecutor
                    .with(req,res)
                    .execute(i));
        }
    }


}