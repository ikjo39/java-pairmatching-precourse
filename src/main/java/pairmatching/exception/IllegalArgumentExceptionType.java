package pairmatching.exception;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException>{
    INVALID_FUNCTION_TYPE("유효하지 않은 기능 입력입니다."),
    INVALID_INFORMATION_SIZE("요구한 입력 개수와 일치하지 않습니다."),
    INVALID_COURSE("입력하신 과정이 존재하지 않습니다."),
    INVALID_LEVEL("입력하신 레벨이 존재하지 않습니다."),
    INVALID_MISSION("입력하신 미션이 존재하지 않습니다."),
    ;

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
