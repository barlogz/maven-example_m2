package ua.goit.java.module2.generics;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<T> implements Executor<T> {
    private List<Task<? extends T>> tasks = new ArrayList<>();
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();

    private boolean isExecuteActivated;

    @Override
    public void addTask(Task<? extends T> task) {
        try {
            if (isExecuteActivated) {
                throw new Exception("[ERROR]: Method execute() was already activated!");
            }
            tasks.add(task);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        try {
            if (isExecuteActivated) {
                throw new Exception("[ERROR]: Method execute() was already activated!");
            }
            task.execute();
            if (validator.isValid(task.getResult())) {
                validResults.add(task.getValue());
            } else {
                invalidResults.add(task.getValue());
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public void execute() {
        Validator<Number> validator = new NumberValidator();
        for (Task<? extends T> task : tasks) {
            task.execute();
            if (validator.isValid((Number) task.getResult())) {
                validResults.add(task.getValue());
            } else {
                invalidResults.add(task.getValue());
            }
        }
        isExecuteActivated = true;
    }

    @Override
    public List<T> getValidResults() {
        try {
            if (isExecuteActivated) {
                return validResults;
            } else {
                throw new Exception("[ERROR]: Method execute() does not activate yet!");
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }

    @Override
    public List<T> getInvalidResults() {
        try {
            if (isExecuteActivated) {
                return invalidResults;
            } else {
                throw new Exception("[ERROR]: Method execute() does not activated yet!");
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }

    /** Method for test only **/
    public List<Task<? extends T>> getTasks() {
        return tasks;
    }
}
