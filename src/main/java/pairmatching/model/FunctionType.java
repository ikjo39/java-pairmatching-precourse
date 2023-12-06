package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import pairmatching.exception.IllegalArgumentExceptionType;

public class FunctionType {
    private static final String PAIR_MATCHING = "1";
    private static final String PAIR_INQUIRY = "2";
    private static final String PAIR_CLEAR = "3";
    private static final String EXIT_CODE = "Q";
    private static final List<String> CODES = Arrays.asList(PAIR_MATCHING, PAIR_CLEAR, PAIR_INQUIRY, EXIT_CODE);

    private final String type;

    public FunctionType(String type) {
        validateFunctionType(type);
        this.type = type;
    }

    private void validateFunctionType(String type) {
        if (!CODES.contains(type)) {
            throw IllegalArgumentExceptionType.INVALID_FUNCTION_TYPE.getException();
        }
    }

    public boolean isMatchingEnd() {
        return EXIT_CODE.equals(type);
    }

    public boolean isPressPairMatching() {
        return PAIR_MATCHING.equals(type);
    }

    public boolean isPressPAIR_INQUIRY() {
        return PAIR_INQUIRY.equals(type);
    }

    public boolean isPressPAIR_CLEAR() {
        return PAIR_CLEAR.equals(type);
    }
}
