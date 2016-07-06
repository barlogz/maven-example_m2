package ua.goit.java.module2.generics;

public class IntegerTask implements Task<Integer> {
    private Integer value;
    private Integer result;

    public IntegerTask(Integer value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = value + 2;
    }

    @Override
    public Integer getResult() {
        return result;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
