package ua.goit.java.module2.generics;

public class DoubleTask implements Task<Double>{
    private Double value;
    private Double result;

    public DoubleTask(Double value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = value - 2.1;
    }

    @Override
    public Double getResult() {
        return result;
    }

    @Override
    public Double getValue() {
        return result;
    }
}
