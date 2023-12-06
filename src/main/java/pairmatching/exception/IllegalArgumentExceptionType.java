package pairmatching.exception;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException>{
    INVALID_FUNCTION_TYPE("유효하지 않은 기능 입력입니다.");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return String.format("%s %s", MESSAGE_HEADER, message);
    }

    @Override
    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
