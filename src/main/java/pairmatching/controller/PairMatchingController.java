package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.model.FunctionType;
import pairmatching.model.MatchCondition;
import pairmatching.model.MatchingResults;
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
        MatchingResults matchingResults = new MatchingResults();
        while (true) {
            FunctionType functionType = getFunctionType();
            if (functionType.isMatchingEnd()) {
                break;
            }
            if (functionType.isPressPairMatching()) {
                MatchCondition matchCondition = getCourseInformation();

            }
            if (functionType.isPressPAIR_INQUIRY()) {

            }
            if (functionType.isPressPAIR_CLEAR()) {
                matchingResults.clear();
            }
        }
    }

    private FunctionType getFunctionType() {
        return retryUntilSuccess(() -> new FunctionType(inputView.readFunctionType()));
    }

    private MatchCondition getCourseInformation() {
        return retryUntilSuccess(() -> MatchCondition.from(inputView.readCourseInformation()));
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
