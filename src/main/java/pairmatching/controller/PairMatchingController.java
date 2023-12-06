package pairmatching.controller;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import pairmatching.model.CourseInformation;
import pairmatching.model.FunctionType;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> matchingResult = Collections.emptyList();
        while (true) {
            FunctionType functionType = getFunctionType();
            if (functionType.isMatchingEnd()) break;
            if (functionType.isPressPairMatching()) {
                CourseInformation courseInformation = getCourseInformation();
            }
        }
    }

    private FunctionType getFunctionType() {
        return retryUntilSuccess(() -> new FunctionType(inputView.readFunctionType()));
    }

    private CourseInformation getCourseInformation() {
        return retryUntilSuccess(() -> new CourseInformation(inputView.readCourseInformation()));
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
