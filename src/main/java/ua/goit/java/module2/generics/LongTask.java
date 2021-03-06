package ua.goit.java.module2.generics;

public class LongTask implements Task<Long>{
    private Long value;
    private Long result;

    public LongTask(Long value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = value + 1L;
    }

    @Override
    public Long getResult() {
        return result;
    }

    @Override
    public Long getValue() {
        return value;
    }
}

