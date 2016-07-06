package ua.goit.java.module2.generics;

import org.junit.Test;

import static org.junit.Assert.*;


public class GenericTest {

    @Test
    public void testAddNumberExtendsTypes() throws Exception {
        Executor<Number> executor = new ExecutorImpl<>();
        executor.addTask(new LongTask(15L));
        executor.addTask(new DoubleTask(25.7));
        executor.addTask(new IntegerTask(128));

        assertEquals(3, executor.getTasks().size());
    }

    @Test
    public void testMainWithDouble() throws Exception {
        Task<Double> task = new DoubleTask(25.6);
        task.execute();

        assertEquals(23.5, task.getResult(), 0.1);
    }

    @Test
    public void testMainWithDouble2() throws Exception {
        Task<Double> task = new DoubleTask(12345.123456789135);
        task.execute();

        assertEquals(12343.023456789135, task.getResult(), 0.1);
    }

    @Test
    public void testMainWithInteger() throws Exception {
        Task<Integer> task = new IntegerTask(35);
        task.execute();

        assertEquals(37, task.getResult(), 0.1);
    }

    @Test
    public void testMainWithLong() throws Exception {
        Task<Long> task = new LongTask(101L);
        task.execute();

        assertEquals(102L, task.getResult(), 0.1);
    }

    @Test
    public void testValidator() throws Exception {
        Validator<Number> validator = new NumberValidator();

        Task<Double> validDouble = new DoubleTask(-1.9);
        Task<Double> invalidDouble = new DoubleTask(4.563);
        validDouble.execute();
        invalidDouble.execute();
        assertTrue(validator.isValid(validDouble.getResult()));
        assertFalse(validator.isValid(invalidDouble.getResult()));

        Task<Integer> validInteger = new IntegerTask(-2654);
        Task<Integer> invalidInteger = new IntegerTask(25263);
        validInteger.execute();
        invalidInteger.execute();
        assertTrue(validator.isValid(validInteger.getResult()));
        assertFalse(validator.isValid(invalidInteger.getResult()));

        Task<Long> validLong = new LongTask(-1231325648549875412L);
        Task<Long> invalidLong = new LongTask(99489122123487L);
        validLong.execute();
        invalidLong.execute();
        assertTrue(validator.isValid(validLong.getResult()));
        assertFalse(validator.isValid(invalidLong.getResult()));
    }
}
