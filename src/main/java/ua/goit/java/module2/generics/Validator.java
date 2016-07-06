package ua.goit.java.module2.generics;

public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);
}
