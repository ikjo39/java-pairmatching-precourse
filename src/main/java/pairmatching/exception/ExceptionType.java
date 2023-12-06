package pairmatching.exception;

public interface ExceptionType<T> {
    String MESSAGE_HEADER = "[ERROR]";

    String getMessage();
    T getException();
}
