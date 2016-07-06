package ua.goit.java.module2.generics;

public class Main {

    public static void main(String[] args) {
       Task<Integer>[] intTasks = new IntegerTask[3];
        intTasks[0] = new IntegerTask(-10);
        intTasks[1] = new IntegerTask(20);
        intTasks[2] = new IntegerTask(30);

        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(-25L), new NumberValidator());
        numberExecutor.addTask(new IntegerTask(-35));

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }
}
