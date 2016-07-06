package ua.goit.java.module2.generics;

public class NumberValidator implements Validator<Number>{
    @Override
    public boolean isValid(Number result) {
        return result.intValue() <=0;
    }
}
