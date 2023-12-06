package pairmatching.exception;

public enum IllegalStateExceptionType implements ExceptionType<IllegalStateException> {
    ;

    private final String message;

    IllegalStateExceptionType(String message) {
        this.message = String.format("%s %s", MESSAGE_HEADER, message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IllegalStateException getException() {
        return new IllegalStateException(getMessage());
    }
}
